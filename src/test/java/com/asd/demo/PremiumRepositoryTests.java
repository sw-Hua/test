package com.asd.demo;


import com.asd.demo.premium.Premium;
import com.asd.demo.premium.PremiumRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PremiumRepositoryTests {
    @Autowired private PremiumRepository repo;

    @Test
    public void testAddNewPremium(){
        Premium premium = new Premium();
        premium.setUserID(10002);
        premium.setVipID(3);
        Premium savePremium = repo.save(premium);
        Assertions.assertThat(savePremium).isNotNull();
        Assertions.assertThat(savePremium.getPremiumID()).isGreaterThan(0);
    }

    @Test
    public void testListAllPremium(){
        // 查
        Iterable<Premium> AllInPremium = repo.findAll();
        Assertions.assertThat(AllInPremium).hasSizeGreaterThan(0);

        for (Premium premium : AllInPremium) {
            System.out.println(premium);
        }
    }

    @Test
    public void testUpdatePremium(){
        //改
        Integer premiumID = 6;
        Optional<Premium> optionalPremium = repo.findById(6);
        Premium premium = optionalPremium.get();
        premium.setUserID(10003);
        premium.setVipID(1);
        repo.save(premium);

        Premium updatePremium = repo.findById(premiumID).get();
        Assertions.assertThat(updatePremium.getUserID()).isEqualTo(10003);
        Assertions.assertThat(updatePremium.getVipID()).isEqualTo(1);
    }

    @Test
    public void testDeletePremium(){
        Integer premiumId = 6;
        repo.deleteById(premiumId);

        Optional<Premium> optionalPremium = repo.findById(premiumId);
        Assertions.assertThat(optionalPremium).isNotPresent(); // 不会不存在
    }




}

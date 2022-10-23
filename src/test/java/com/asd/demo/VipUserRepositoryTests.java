package com.asd.demo;

import com.asd.demo.vip.VipUser;
import com.asd.demo.vip.VipUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class VipUserRepositoryTests {
    @Autowired private VipUserRepository repo;

    @Test
    public void testAddNewVipUser(){
        // 增
        VipUser vipUser = new VipUser();
        vipUser.setVipName("songwen.hua");
        vipUser.setEmail("songwen.hua-2@student.uts.au");

        VipUser saveVipUser = repo.save(vipUser);

        Assertions.assertThat(saveVipUser).isNotNull();
        Assertions.assertThat(saveVipUser.getVipID()).isGreaterThan(0);
    }

    @Test
    public void testListAllVipUser(){
        // 查
        Iterable<VipUser> vipUsers = repo.findAll();
        Assertions.assertThat(vipUsers).hasSizeGreaterThan(0);

        for (VipUser vipUser : vipUsers) {
            System.out.println(vipUser);
        }
    }

    @Test
    public void testUpdateVipUser(){
        //改
        Integer vipId = 33;
        Optional<VipUser> optionalVipUser = repo.findById(vipId);
        VipUser vipUser = optionalVipUser.get();
        vipUser.setEmail("aSongwenHua@yahoo.com");
        vipUser.setVipName("HuaSongwen");
        repo.save(vipUser);

        VipUser updateVipUser = repo.findById(vipId).get();
        Assertions.assertThat(updateVipUser.getEmail()).isEqualTo("aSongwenHua@yahoo.com");
        Assertions.assertThat(updateVipUser.getVipName()).isEqualTo("HuaSongwen");
    }

    @Test
    public void testDeleteVipUser(){
        //删
        Integer vipId = 32;
        repo.deleteById(32);

        Optional<VipUser> optionalVipUser = repo.findById(vipId);
        Assertions.assertThat(optionalVipUser).isNotPresent(); // 不会不存在
        
    }


}

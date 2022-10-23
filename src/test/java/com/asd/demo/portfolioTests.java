package com.asd.demo;

import com.asd.demo.pointSystem.PointSystem;
import com.asd.demo.pointSystem.PointSystemRepository;
import com.asd.demo.portfolio.Portfolio;
import com.asd.demo.portfolio.PortfolioRepository;
import com.asd.demo.premium.Premium;
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
public class portfolioTests {
    @Autowired
    private PortfolioRepository repo;

    @Test
    public void testEditNew(){

        //Optional<Portfolio> optionalPortfolio = repo.findById(4);
        //Portfolio portfolio = optionalPortfolio.get();

        Portfolio portfolio = new Portfolio();
        portfolio.setID(4);
        portfolio.setUserID(10002);
        portfolio.setAddress("testAddress");
        portfolio.setPhone(123456);
        portfolio.setUserEmail("131213@163.com");
        portfolio.setUserName("songwen");

        System.out.println("查看: "+ portfolio);
        repo.save(portfolio);


    }
}

package com.asd.demo;

import com.asd.demo.premium.Premium;
import com.asd.demo.premium.PremiumRepository;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testTest {

    @BeforeTest
    public void before(){
        System.out.println("This is the before method.");
    }

    @Test
    public void testCase(){
        System.out.println("this is testcase");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("This is after test. ");
    }


}

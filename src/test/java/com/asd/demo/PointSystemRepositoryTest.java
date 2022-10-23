package com.asd.demo;

import com.asd.demo.pointSystem.PointSystem;
import com.asd.demo.pointSystem.PointSystemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;
import java.awt.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PointSystemRepositoryTest {
    @Autowired
    private PointSystemRepository repo;



    @Test
    public void testListAllPointSystem(){
        // check
        Iterable<PointSystem> pointSystems = repo.findAll();
        Assertions.assertThat(pointSystems).hasSizeGreaterThan(0);

        for (PointSystem pointSystem : pointSystems) {
            System.out.println(pointSystem);
        }
    }

    @Test
    public void testUpdatePointSystem(){
        // upload
        Integer pointSystemID = 0;
        Optional<PointSystem> optionalPointSystem = repo.findById(pointSystemID);
        PointSystem pointSystem = optionalPointSystem.get();
        pointSystem.setPointNumber(1800);
        pointSystem.setUserID(10001);
        repo.save(pointSystem);

        PointSystem updatePointSystem = repo.findById(pointSystemID).get();
        Assertions.assertThat(updatePointSystem.getPointNumber()).isEqualTo(1800);
        Assertions.assertThat(updatePointSystem.getUserID()).isEqualTo(10001);
    }

    @Test
    public void minusPointNumber(){
        Integer minusPointNumber = 0;
        Optional<PointSystem> optionalPointSystem = repo.findById(0);
        PointSystem pointSystem = optionalPointSystem.get();
        minusPointNumber = pointSystem.getPointNumber() - 200;
        pointSystem.setPointNumber(minusPointNumber);
        repo.save(pointSystem);
    }

}

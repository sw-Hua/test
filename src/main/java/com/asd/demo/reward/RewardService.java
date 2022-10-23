package com.asd.demo.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RewardService {
    @Autowired private RewardRepository repo;
    public List<Reward> listAll(){
        return (List<Reward>) repo.findAll();
    }
}

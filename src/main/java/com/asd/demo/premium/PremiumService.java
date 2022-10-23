package com.asd.demo.premium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PremiumService {
    @Autowired private PremiumRepository repo;
     public List<Premium> listAll(){
            return (List<Premium>) repo.findAll();
    }

    public void save(Premium premium){
         repo.save(premium);
    }
}

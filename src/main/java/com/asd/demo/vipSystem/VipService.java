package com.asd.demo.vipSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VipService {
    @Autowired private  VipSystemRepository repo;
    public List<VipSystem> listAll(){
        return (List<VipSystem>) repo.findAll();
    }
}

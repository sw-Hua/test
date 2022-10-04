package com.asd.demo.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired private ActivityRepository repo;
    public List<Activity> listAll(){
        return (List<Activity>) repo.findAll();
    }
}

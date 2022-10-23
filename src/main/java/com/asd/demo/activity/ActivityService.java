package com.asd.demo.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired private ActivityRepository repo;
    public List<Activity> listAll(){
        return (List<Activity>) repo.findAll();
    }

    public Activity get(Integer id) throws ActivityNotFoundExceotion{
        Optional<Activity> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }throw new ActivityNotFoundExceotion("Could not find any activity" + id);
    }

    public void save(Activity activity){
        repo.save(activity);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}

package com.asd.demo.pointSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointSystemService {
    @Autowired
    private PointSystemRepository repo;
    public List<PointSystem> listAll(){
        return (List<PointSystem>) repo.findAll();
    }

    public PointSystem get(Integer id) throws PointSystemNotFoundException {
        Optional<PointSystem> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }throw new PointSystemNotFoundException("Could Not Find Any Point System " + id);
    }

    public void save(PointSystem pointSystem){
        repo.save(pointSystem);
    }

    public void minusPoint(PointSystem pointSystem){

        Integer currentPointSystem = pointSystem.getPointNumber() - 500;
        pointSystem.setPointNumber(500);
    }
}

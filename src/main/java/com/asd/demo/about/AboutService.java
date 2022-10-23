package com.asd.demo.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AboutService {
    @Autowired private AboutRepository repo;
    public List<About> listAll(){
        return (List<About>) repo.findAll();
    }
}

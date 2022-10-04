package com.asd.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository repo;
    public List<Portfolio> listAll(){
        return (List<Portfolio>) repo.findAll();
    }
}

package com.asd.demo.portfolio;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {
    @Query("SELECT p FROM Portfolio p WHERE p.verificationCode = ?1")
    public Portfolio findByVerificationCode(String code);
}

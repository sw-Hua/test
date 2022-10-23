package com.asd.demo.vip;

import org.springframework.data.repository.CrudRepository;

public interface VipUserRepository extends CrudRepository<VipUser, Integer> {
    // public Long countById(Integer id); //delete才加的
}

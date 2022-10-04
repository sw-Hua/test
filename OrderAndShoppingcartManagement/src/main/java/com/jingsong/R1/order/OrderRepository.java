package com.jingsong.R1.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    //public Long countByID(Integer id);
}

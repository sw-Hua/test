package com.jingsong.R1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired private OrderRepository repository;

    public List<Order>listAll(){
        return (List<Order>) repository.findAll();
    }

    public void save(Order order) {
        repository.save(order);
    }

    public Order get(Integer id) throws OrderNotFoundException {
        Optional<Order> result = repository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new OrderNotFoundException("Can not find this order");
    }

    public void delete(Integer id) throws OrderNotFoundException {
//        Long count = repository.selectById(id);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(id);
        Iterable<Order> order = repository.findAllById(ids);
        boolean b = order.iterator().hasNext();
        if (!b) {
            throw new OrderNotFoundException("Can not find this order");
        }
        repository.deleteById(id);
    }
}

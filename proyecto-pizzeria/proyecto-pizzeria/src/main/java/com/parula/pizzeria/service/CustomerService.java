package com.parula.pizzeria.service;

import com.parula.pizzeria.persistence.entity.CustomerEntity;
import com.parula.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity finByPhone(String phone){
        return this.customerRepository.findByPhone(phone);

    }
}

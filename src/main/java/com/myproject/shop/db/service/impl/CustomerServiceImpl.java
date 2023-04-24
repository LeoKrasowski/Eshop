package com.myproject.shop.db.service.impl;

import com.myproject.shop.db.service.API.CustomerService;
import com.myproject.shop.db.service.repository.CustomerRepository;
import com.myproject.shop.domain.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomer() {
        return null;
    }

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public Integer add(Customer customer) {
        return null;
    }
}

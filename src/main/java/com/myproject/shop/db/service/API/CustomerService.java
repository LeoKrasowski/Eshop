package com.myproject.shop.db.service.API;

import com.myproject.shop.domain.Customer;

import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    @Nullable
    Customer get(int id);

    @Nullable
    Integer add(Customer customer); // returns generated id
}
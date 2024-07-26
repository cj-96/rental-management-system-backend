package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
    Customer persist(Customer customer);

    Customer retrieve(Long id);

    List<Customer> retrieveAll();

    void remove(Long id);

    Customer update(Customer customer);
}

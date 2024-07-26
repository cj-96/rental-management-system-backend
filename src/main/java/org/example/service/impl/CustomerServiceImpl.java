package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ObjectMapper mapper;
    @Override
    public Customer persist(Customer customer) {
        CustomerEntity save = repository.save(mapper.convertValue(customer, CustomerEntity.class));
        return mapper.convertValue(save, Customer.class);
    }

    @Override
    public Customer retrieve(Long id) {
        return mapper.convertValue(repository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> retrieveAll() {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerEntity customerEntity : repository.findAll()) {
            customerList.add(mapper.convertValue(customerEntity, Customer.class));
        }

        return customerList;
    }

    @Override
    public void remove(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity save = repository.save(mapper.convertValue(customer, CustomerEntity.class));
        return mapper.convertValue(save, Customer.class);
    }
}

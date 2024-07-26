package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/persist")
    public Customer persist(@RequestBody Customer customer){
        return service.persist(customer);
    }

    @GetMapping("/retrieve{id}")
    public Customer retrieve(@PathVariable Long id){
        return service.retrieve(id);
    }

    @GetMapping("/retrieveAll")
    public List<Customer> retrieveAll(){
        return service.retrieveAll();
    }

    @DeleteMapping("/remove{id}")
    public String remove(@PathVariable Long id){
        service.remove(id);
        return "DELETED";
    }
    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }

}

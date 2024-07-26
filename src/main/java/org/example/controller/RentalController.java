package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.Rental;
import org.example.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@CrossOrigin
@RequiredArgsConstructor
public class RentalController {

    private final RentalService service;

    @PostMapping("/persist")
    public Rental persist(@RequestBody Rental rental){
        return service.persist(rental);
    }

    @GetMapping("/retrieve{id}")
    public Rental retrieve(@PathVariable Long id){
        return service.retrieve(id);
    }

    @GetMapping("/retrieveAll")
    public List<Rental> retrieveAll(){
        return service.retrieveAll();
    }

    @DeleteMapping("/remove{id}")
    public String remove(@PathVariable Long id){
        service.remove(id);
        return "DELETED";
    }
    @PutMapping("/update")
    public Rental update(@RequestBody Rental rental){
        return service.update(rental);
    }
}

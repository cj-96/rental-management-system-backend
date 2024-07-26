package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.dto.RentalDetail;
import org.example.service.HardwareItemService;
import org.example.service.RentalDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalDetail")
@CrossOrigin
@RequiredArgsConstructor
public class RentalDetailController {

    private final RentalDetailService service;

    @PostMapping("/persist")
    public RentalDetail persist(@RequestBody RentalDetail rentalDetail){
        return service.persist(rentalDetail);
    }

    @GetMapping("/retrieve{id}")
    public RentalDetail retrieve(@PathVariable Long id){
        return service.retrieve(id);
    }

    @GetMapping("/retrieveAll")
    public List<RentalDetail> retrieveAll(){
        return service.retrieveAll();
    }

    @DeleteMapping("/remove{id}")
    public String remove(@PathVariable Long id){
        service.remove(id);
        return "DELETED";
    }
    @PutMapping("/update")
    public RentalDetail update(@RequestBody RentalDetail rentalDetail){
        return service.update(rentalDetail);
    }
}

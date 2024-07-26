package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.dto.Rental;
import org.example.service.HardwareItemService;
import org.example.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardwareItem")
@CrossOrigin
@RequiredArgsConstructor
public class HardwareItemController {

    private final HardwareItemService service;

    @PostMapping("/persist")
    public HardwareItem persist(@RequestBody HardwareItem hardwareItem){
        return service.persist(hardwareItem);
    }

    @GetMapping("/retrieve{id}")
    public HardwareItem retrieve(@PathVariable Long id){
        return service.retrieve(id);
    }

    @GetMapping("/retrieveAll")
    public List<HardwareItem> retrieveAll(){
        return service.retrieveAll();
    }

    @DeleteMapping("/remove{id}")
    public String remove(@PathVariable Long id){
        service.remove(id);
        return "DELETED";
    }
    @PutMapping("/update")
    public HardwareItem update(@RequestBody HardwareItem hardwareItem){
        return service.update(hardwareItem);
    }
}

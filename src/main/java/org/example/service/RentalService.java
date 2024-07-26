package org.example.service;

import org.example.dto.Rental;

import java.util.List;

public interface RentalService {
    Rental persist(Rental rental);

    Rental retrieve(Long id);

    List<Rental> retrieveAll();

    void remove(Long id);

    Rental update(Rental rental);
}

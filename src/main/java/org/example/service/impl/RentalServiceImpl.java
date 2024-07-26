package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Rental;
import org.example.entity.RentalEntity;
import org.example.repository.RentalRepository;
import org.example.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Rental persist(Rental rental) {
        RentalEntity save = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(save, Rental.class);
    }

    @Override
    public Rental retrieve(Long id) {
        return mapper.convertValue(repository.findById(id), Rental.class);
    }

    @Override
    public List<Rental> retrieveAll() {
        List<Rental> rentalList = new ArrayList<>();
        for (RentalEntity rentalEntity : repository.findAll()) {
            rentalList.add(mapper.convertValue(rentalEntity, Rental.class));
        }

        return rentalList;
    }

    @Override
    public void remove(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Rental update(Rental rental) {
        RentalEntity save = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(save, Rental.class);
    }
}

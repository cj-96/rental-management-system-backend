package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.RentalDetail;
import org.example.entity.RentalDetailEntity;
import org.example.repository.RentalDetailRepository;

import org.example.service.RentalDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RentalDetailServiceImpl implements RentalDetailService {

    private final RentalDetailRepository repository;
    private final ObjectMapper mapper;

    @Override
    public RentalDetail persist(RentalDetail rentalDetail) {
        RentalDetailEntity save = repository.save(mapper.convertValue(rentalDetail, RentalDetailEntity.class));
        return mapper.convertValue(save, RentalDetail.class);
    }

    @Override
    public RentalDetail retrieve(Long id) {
        return mapper.convertValue(repository.findById(id), RentalDetail.class);
    }

    @Override
    public List<RentalDetail> retrieveAll() {
        List<RentalDetail> rentalDetailList = new ArrayList<>();
        for (RentalDetailEntity rentalDetailEntity : repository.findAll()) {
            rentalDetailList.add(mapper.convertValue(rentalDetailEntity, RentalDetail.class));
        }

        return rentalDetailList;
    }

    @Override
    public void remove(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public RentalDetail update(RentalDetail rentalDetail) {
        RentalDetailEntity save = repository.save(mapper.convertValue(rentalDetail, RentalDetailEntity.class));
        return mapper.convertValue(save, RentalDetail.class);
    }
}

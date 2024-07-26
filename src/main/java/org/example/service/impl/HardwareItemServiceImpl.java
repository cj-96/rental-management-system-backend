package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.entity.HardwareItemEntity;
import org.example.repository.HardwareItemRepository;
import org.example.service.HardwareItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HardwareItemServiceImpl implements HardwareItemService {

    private final HardwareItemRepository repository;
    private final ObjectMapper mapper;
    
    @Override
    public HardwareItem persist(HardwareItem hardwareItem) {
        HardwareItemEntity save = repository.save(mapper.convertValue(hardwareItem, HardwareItemEntity.class));
        return mapper.convertValue(save, HardwareItem.class);
    }

    @Override
    public HardwareItem retrieve(Long id) {
        return mapper.convertValue(repository.findById(id), HardwareItem.class);
    }

    @Override
    public List<HardwareItem> retrieveAll() {
        List<HardwareItem> rentalList = new ArrayList<>();
        for (HardwareItemEntity hardwareItemEntity : repository.findAll()) {
            rentalList.add(mapper.convertValue(hardwareItemEntity, HardwareItem.class));
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
    public HardwareItem update(HardwareItem hardwareItem) {
        HardwareItemEntity save = repository.save(mapper.convertValue(hardwareItem, HardwareItemEntity.class));
        return mapper.convertValue(save, HardwareItem.class);
    }
}

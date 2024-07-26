package org.example.service;

import org.example.dto.HardwareItem;
import org.example.dto.RentalDetail;

import java.util.List;

public interface RentalDetailService {
    RentalDetail persist(RentalDetail rentalDetail);

    RentalDetail retrieve(Long id);

    List<RentalDetail> retrieveAll();

    void remove(Long id);

    RentalDetail update(RentalDetail rentalDetail);
}

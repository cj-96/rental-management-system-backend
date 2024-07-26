package org.example.service;

import org.example.dto.HardwareItem;

import java.util.List;

public interface HardwareItemService {
    HardwareItem persist(HardwareItem hardwareItem);

    HardwareItem retrieve(Long id);

    List<HardwareItem> retrieveAll();

    void remove(Long id);

    HardwareItem update(HardwareItem hardwareItem);
}

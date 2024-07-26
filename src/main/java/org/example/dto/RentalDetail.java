package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetail {

    private Long id;
    private Long rentalId;
    private Long hardwareId;
    private int qty;
    private Double totalCost;
}

package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HardwareItem {
    private Long id;
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
    private String availability;
}

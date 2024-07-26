package org.example.repository;

import org.example.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity,Long> {
}

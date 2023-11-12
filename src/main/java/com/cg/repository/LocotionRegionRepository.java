package com.cg.repository;

import com.cg.model.Customer;
import com.cg.model.LocationRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocotionRegionRepository extends JpaRepository<LocationRegion, Long> {
}

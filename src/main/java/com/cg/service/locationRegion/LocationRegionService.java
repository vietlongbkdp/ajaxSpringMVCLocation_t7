package com.cg.service.locationRegion;

import com.cg.model.LocationRegion;
import com.cg.repository.LocotionRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class LocationRegionService implements ILocationRegionService{
    @Autowired
    private LocotionRegionRepository locationRegionRepository;
    @Override
    public List<LocationRegion> findAll() {
        return locationRegionRepository.findAll();
    }

    @Override
    public Optional<LocationRegion> findById(Long id) {
        return locationRegionRepository.findById(id);
    }

    @Override
    public void save(LocationRegion locationRegion) {
        locationRegionRepository.save(locationRegion);
    }

    @Override
    public void deleted(Long id) {
        locationRegionRepository.deleteById(id);
    }
}

package com.sagepay.hackathon.service.impl;

import com.sagepay.hackathon.model.Location;
import com.sagepay.hackathon.repository.LocationRepository;
import com.sagepay.hackathon.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}

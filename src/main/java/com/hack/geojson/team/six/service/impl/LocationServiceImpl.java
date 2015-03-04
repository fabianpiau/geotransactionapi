package com.hack.geojson.team.six.service.impl;

import com.hack.geojson.team.six.model.Location;
import com.hack.geojson.team.six.repository.LocationRepository;
import com.hack.geojson.team.six.service.LocationService;
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

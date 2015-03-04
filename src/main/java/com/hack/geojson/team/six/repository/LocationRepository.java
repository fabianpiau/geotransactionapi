package com.hack.geojson.team.six.repository;

import com.hack.geojson.team.six.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
    public Location findByRegion(String region);
}

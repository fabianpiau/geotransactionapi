package com.sagepay.hackathon.repository;

import com.sagepay.hackathon.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}

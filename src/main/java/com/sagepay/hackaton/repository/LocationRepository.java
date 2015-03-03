package com.sagepay.hackaton.repository;

import com.sagepay.hackaton.model.Location;
import com.sagepay.hackaton.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}

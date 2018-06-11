package com.mongodb.app.springbootmongodb.repository;

import com.mongodb.app.springbootmongodb.entity.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhoneRepository extends MongoRepository<Phone, String> {
}

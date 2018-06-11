package com.mongodb.app.springbootmongodb.repository;

import com.mongodb.app.springbootmongodb.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String>{
}

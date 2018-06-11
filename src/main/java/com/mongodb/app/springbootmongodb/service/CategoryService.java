package com.mongodb.app.springbootmongodb.service;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.request.CreateCategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> listCategory();
    Category createCategory(CreateCategoryRequest requestCategory);
}

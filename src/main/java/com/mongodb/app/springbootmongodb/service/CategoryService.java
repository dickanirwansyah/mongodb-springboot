package com.mongodb.app.springbootmongodb.service;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.request.CreateCategoryRequest;
import com.mongodb.app.springbootmongodb.request.GetCategoryRequest;
import com.mongodb.app.springbootmongodb.request.UpdateCategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> listCategory();
    Category createCategory(CreateCategoryRequest requestCategory);
    Category updateCategory(UpdateCategoryRequest requestCategory);
    Optional<Category> getDetailCategory(GetCategoryRequest requestCategory);
}

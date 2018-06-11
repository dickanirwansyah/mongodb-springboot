package com.mongodb.app.springbootmongodb.service;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.repository.CategoryRepository;
import com.mongodb.app.springbootmongodb.request.CreateCategoryRequest;
import com.mongodb.app.springbootmongodb.request.GetCategoryRequest;
import com.mongodb.app.springbootmongodb.request.UpdateCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategory() {
        List<Category> list = new ArrayList<>();
        for (Category category : categoryRepository.findAll()){
            list.add(category);
        }
        return list;
    }

    @Override
    public Category createCategory(CreateCategoryRequest requestCategory) {
        Category category = newCategory(requestCategory.getNameOfCategory(),
                requestCategory.getDescriptionOfCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UpdateCategoryRequest requestCategory) {
        Category category = setCategory(
                requestCategory.getCategoryId(),
                requestCategory.getNameOfCategory(),
                requestCategory.getDescriptionOfCategory()
        );
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getDetailCategory(GetCategoryRequest requestCategory) {
        return categoryRepository.findById(requestCategory.getCategoryId());
    }

    private Category newCategory(String categoryName, String categoryDescription){
        return Category.builder()
                .name(categoryName)
                .description(categoryDescription)
                .build();
    }

    private Category setCategory(String categoryId, String categoryName, String categoryDescription){
        return Category.builder()
                .idcategory(categoryId)
                .name(categoryName)
                .description(categoryDescription)
                .build();
    }
}

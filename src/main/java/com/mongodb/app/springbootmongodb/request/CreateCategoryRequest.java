package com.mongodb.app.springbootmongodb.request;

import com.mongodb.app.springbootmongodb.validation.CreateCategoryValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateCategoryValidation
public class CreateCategoryRequest {

    private String nameOfCategory;
    private String descriptionOfCategory;
}

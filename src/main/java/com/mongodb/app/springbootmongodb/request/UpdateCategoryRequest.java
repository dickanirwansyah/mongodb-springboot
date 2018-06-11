package com.mongodb.app.springbootmongodb.request;

import com.mongodb.app.springbootmongodb.validation.UpdateCategoryValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UpdateCategoryValidation
public class UpdateCategoryRequest {

    private String categoryId;
    private String nameOfCategory;
    private String descriptionOfCategory;
}

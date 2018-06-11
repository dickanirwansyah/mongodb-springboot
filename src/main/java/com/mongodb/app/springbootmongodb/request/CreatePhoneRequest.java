package com.mongodb.app.springbootmongodb.request;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.validation.CreatePhoneValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreatePhoneValidation
public class CreatePhoneRequest {

    private String nameOfPhone;
    private Category categoryOfPhone;
    private int priceOfPhone;
    private int stockOfPhone;
}

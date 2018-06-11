package com.mongodb.app.springbootmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "phone")
public class Phone {

    @Id
    private String idphone;
    private String name;
    private Category category;
    private int price;
    private int stock;
}

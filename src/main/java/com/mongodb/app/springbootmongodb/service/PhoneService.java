package com.mongodb.app.springbootmongodb.service;

import com.mongodb.app.springbootmongodb.entity.Phone;
import com.mongodb.app.springbootmongodb.request.CreatePhoneRequest;

import java.util.List;

public interface PhoneService {

    List<Phone> listPhone();
    Phone createPhone(CreatePhoneRequest requestPhone);
}

package com.mongodb.app.springbootmongodb.service;

import com.mongodb.app.springbootmongodb.entity.Category;
import com.mongodb.app.springbootmongodb.entity.Phone;
import com.mongodb.app.springbootmongodb.repository.PhoneRepository;
import com.mongodb.app.springbootmongodb.request.CreatePhoneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> listPhone() {
        List<Phone> list = new ArrayList<>();
        for (Phone phone : phoneRepository.findAll()){
            list.add(phone);
        }
        return list;
    }

    @Override
    public Phone createPhone(CreatePhoneRequest requestPhone) {
        Phone phone = newPhone(
                requestPhone.getNameOfPhone(),
                requestPhone.getCategoryOfPhone(),
                requestPhone.getStockOfPhone(),
                requestPhone.getPriceOfPhone());
        return phoneRepository.save(phone);
    }

    private Phone newPhone(String phoneName, Category phoneCategory, int phoneStock, int phonePrice){
        return Phone.builder()
                .name(phoneName)
                .category(phoneCategory)
                .stock(phoneStock)
                .price(phonePrice)
                .build();
    }
}

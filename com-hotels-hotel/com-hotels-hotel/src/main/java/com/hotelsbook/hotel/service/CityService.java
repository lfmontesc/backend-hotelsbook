package com.hotelsbook.hotel.service;

import com.hotelsbook.hotel.entity.City;
import com.hotelsbook.hotel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Integer getCityIdByName(String name){
        Optional<City> city = cityRepository.findByName(name);
        Integer id = 0;
        if(city.isPresent()){
            id = city.get().getId();
        }
        return id;
    }
}

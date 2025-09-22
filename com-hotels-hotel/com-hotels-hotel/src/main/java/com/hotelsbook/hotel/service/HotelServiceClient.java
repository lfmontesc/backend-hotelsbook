package com.hotelsbook.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelsbook.hotel.dto.HotelServiceDTO;

@Service
public class HotelServiceClient {

    private final RestTemplate restTemplate;

    @Value("${microservice.services.url}")
    private String servicesUrl;

    @Autowired
    public HotelServiceClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<HotelServiceDTO> getHotelServices(List<Long> hotelIds) {
        String hotelIdsParam = hotelIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        String url = servicesUrl + "/" + hotelIdsParam;

        ResponseEntity<List<HotelServiceDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HotelServiceDTO>>() {}
        );

        return response.getBody();
    }

}


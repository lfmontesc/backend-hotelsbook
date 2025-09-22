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

import com.hotelsbook.hotel.dto.HotelReviewDTO;

@Service
public class HotelReviewClient {

    private final RestTemplate restTemplate;

    @Value("${microservice.reviews.url}")
    private String reviewsUrl;

    @Autowired
    public HotelReviewClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<HotelReviewDTO> getHotelReviews(List<Long> hotelIds) {
        String hotelIdsParam = hotelIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        String url = reviewsUrl + "/" + hotelIdsParam;

        ResponseEntity<List<HotelReviewDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HotelReviewDTO>>() {}
        );

        return response.getBody();
    }
}

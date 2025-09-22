package com.hotelsbook.reviews.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsbook.reviews.dto.ReviewDTO;
import com.hotelsbook.reviews.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDTO> getAverageCalifications(String hotelIds) {

        List<Object[]> results = reviewRepository.findAverageCalificationsByHotel(hotelIds);

        return results.stream().map(result -> new ReviewDTO(
                ((Number) result[1]).longValue(),  // hotelId
                ((Number) result[2]).doubleValue() // averageCalification
        )).collect(Collectors.toList());
    }
}

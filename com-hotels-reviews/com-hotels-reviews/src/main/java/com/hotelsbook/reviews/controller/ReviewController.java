package com.hotelsbook.reviews.controller;

import com.hotelsbook.reviews.dto.ReviewDTO;
import com.hotelsbook.reviews.response.ErrorResponse;
import com.hotelsbook.reviews.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/hotels")
public class ReviewController {

        private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

        @Autowired
        private ReviewService reviewService;

        @GetMapping("/reviews/{hotelIds}")
        public ResponseEntity<?> getAverageCalifications(@PathVariable("hotelIds") String hotelIds){
            try {
                logger.info(hotelIds);

                List<ReviewDTO> response = reviewService.getAverageCalifications(hotelIds);

                if(response.isEmpty()){
                    return new ResponseEntity<>(new ErrorResponse(404, "No se encontraron registros"), HttpStatus.NOT_FOUND);
                }

                   return new ResponseEntity<>(response, HttpStatus.OK);
            }catch ( Exception e ) {
                logger.error("error in getAverageCalifications", e);
                ErrorResponse error = new ErrorResponse(500, "Error interno del servidor");
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


}

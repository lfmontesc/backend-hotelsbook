package com.hotelsbook.services.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotelsbook.services.dto.HotelServicesDTO;
import com.hotelsbook.services.response.ErrorResponse;
import com.hotelsbook.services.service.HotelService;

@CrossOrigin(origins = "http://localhost:4200/") //configurando los cors
@RestController
@RequestMapping("/api/hotels")
public class HotelServiceController {

    private static Logger logger = LoggerFactory.getLogger(HotelServiceController.class);

    @Autowired
    private HotelService hotelService;

    @GetMapping("/services/{hotelIds}")
    public ResponseEntity<?> getHotelServices(@PathVariable("hotelIds") String hotelIds) {

        try {

            logger.info(hotelIds);

            List<HotelServicesDTO> response = hotelService.getServicesByHotels(hotelIds);

            if (response.isEmpty()) {
                return new ResponseEntity<>(new ErrorResponse(404, "No se encontraron registros"), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch ( Exception e ) {
            logger.error("error in getHotelService", e);
            ErrorResponse error = new ErrorResponse(500, "Error interno del servidor");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

package com.hotelsbook.hotel.dto;

import java.util.List;

public class HotelServiceDTO {

    private Long hotelId;
    private String hotelName;
    private List<ServiceDTO> services;

    public Long getHotelId() {
        return hotelId;
    }
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public List<ServiceDTO> getServices() {
        return services;
    }
    public void setServices(List<ServiceDTO> services) {
        this.services = services;
    }

}

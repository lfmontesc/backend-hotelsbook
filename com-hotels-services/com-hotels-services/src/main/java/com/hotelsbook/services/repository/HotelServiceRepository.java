package com.hotelsbook.services.repository;

import com.hotelsbook.services.entity.HotelServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelServiceRepository extends JpaRepository<HotelServiceEntity, Long> {
    @Query(value = "CALL GetServicesByHotels(:hotelIds)", nativeQuery = true)
    List<Object[]> getServicesByHotels(@Param("hotelIds") String hotelIds);
}

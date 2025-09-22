package com.hotelsbook.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hotelsbook.reviews.entity.ReviewEntity;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query(value = "CALL GetAverageCalificationByHotel(:hotelIds)", nativeQuery = true)
    List<Object[]> findAverageCalificationsByHotel(@Param("hotelIds") String hotelIds);
}

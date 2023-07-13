package com.mahindrafin.advisornetwork.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafin.advisornetwork.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	 List<Booking> findByUserId(Long userId);
}
package com.mahindrafin.advisornetwork.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrafin.advisornetwork.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
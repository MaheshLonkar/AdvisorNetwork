package com.mahindrafin.advisornetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrafin.advisornetwork.dto.BookingDTO;

import com.mahindrafin.advisornetwork.model.Booking;

import com.mahindrafin.advisornetwork.repository.AdvisorRepository;
import com.mahindrafin.advisornetwork.repository.BookingRepository;
import com.mahindrafin.advisornetwork.repository.UserRepository;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookingService {
	
	@Autowired
    private final BookingRepository bookingRepository;
    private final AdvisorRepository advisorRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserBookingService(
            BookingRepository bookingRepository,
            AdvisorRepository advisorRepository,
            UserRepository userRepository,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.bookingRepository = bookingRepository;
        this.advisorRepository = advisorRepository;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public void bookCall(Long userId, Long advisorId, BookingDTO bookingDTO) {
    	if (bookingDTO.getBookingTime() == null ) {
            throw new IllegalArgumentException("Booking time is required");
        }
        // Create a new booking
    	Booking booking = new Booking();
        booking.setId(userId);
        booking.setId(advisorId);
        booking.setBookingTime(bookingDTO.getBookingTime());
        bookingRepository.save(booking);
    }

    public List<BookingDTO> getAllBookedCalls(Long userId) {
        // Retrieve all booked calls for the given user from the database
        List<Booking> bookings = bookingRepository.findByUserId(userId);

        // Map the entities to DTOs
        List<BookingDTO> bookingDTOs = bookings.stream()
                .map(booking -> new BookingDTO(booking.getBookingTime()))
                .collect(Collectors.toList());

        return bookingDTOs;
    
    }
}
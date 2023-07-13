package com.mahindrafin.advisornetwork.service;

i
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrafin.advisornetwork.model.Advisor;
import com.mahindrafin.advisornetwork.model.Booking;
import com.mahindrafin.advisornetwork.model.User;
import com.mahindrafin.advisornetwork.repository.AdvisorRepository;
import com.mahindrafin.advisornetwork.repository.BookingRepository;
import com.mahindrafin.advisornetwork.repository.UserRepository;
import com.mahindrafin.advisornetwork.security.JwtTokenProvider;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserBookingService {
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

    public void bookCall(Long userId, Long advisorId, LocalDateTime bookingTime) {
        // Retrieve user and advisor entities
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor not found"));

        // Create a new booking
        Booking booking = new Booking(bookingTime, advisor, user);
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }
}
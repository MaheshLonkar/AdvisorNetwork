package com.mahindrafin.advisornetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mahindrafin.advisornetwork.dto.BookingDTO;

import com.mahindrafin.advisornetwork.service.UserBookingService;


import java.util.List;

@RestController
@RequestMapping("/user/{userId}/advisor")
public class UserBookingController {
    private final UserBookingService userBookingService;

    @Autowired
    public UserBookingController(UserBookingService userBookingService) {
        this.userBookingService = userBookingService;
    }

    @PostMapping("/{advisorId}")
    @ResponseStatus(HttpStatus.OK)
    public void bookCall(
            @PathVariable Long userId,
            @PathVariable Long advisorId,
            @RequestBody BookingDTO bookingDto
    ) {
        userBookingService.bookCall(userId, advisorId, bookingDto);
    }

    @GetMapping("/booking")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> getAllBookings(@PathVariable Long userId) {
        return userBookingService.getAllBookedCalls(userId);
    }
}

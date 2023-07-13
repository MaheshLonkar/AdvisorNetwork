package com.mahindrafin.advisornetwork.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private Long id;
    private String advisorName;
    private String advisorPhotoUrl;
    private LocalDateTime bookingTime;

    // Constructors, getters, and setters

    public BookingDTO(LocalDateTime localDateTime) {
    }

    public BookingDTO(Long id, String advisorName, String advisorPhotoUrl, LocalDateTime bookingTime) {
        this.id = id;
        this.advisorName = advisorName;
        this.advisorPhotoUrl = advisorPhotoUrl;
        this.bookingTime = bookingTime;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorPhotoUrl() {
        return advisorPhotoUrl;
    }

    public void setAdvisorPhotoUrl(String advisorPhotoUrl) {
        this.advisorPhotoUrl = advisorPhotoUrl;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
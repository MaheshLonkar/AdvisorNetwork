package com.mahindrafin.advisornetwork.dto;

public class AdvisorDTO {
    private Long id;
    private String name;
    private String photoUrl;

    // Constructors, getters, and setters

    public AdvisorDTO() {
    }

    public AdvisorDTO(Long id, String name, String photoUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
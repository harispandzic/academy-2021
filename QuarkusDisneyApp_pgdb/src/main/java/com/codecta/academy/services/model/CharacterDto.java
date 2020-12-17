package com.codecta.academy.services.model;

import com.codecta.academy.RepositoryPattern.entity.ThemePark;

public class CharacterDto {
    private Integer ID;
    private String name;
    private String greeting;
    private Integer themeParkID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Integer getThemeParkID() {
        return themeParkID;
    }

    public void setThemeParkID(Integer themeParkID) {
        this.themeParkID = themeParkID;
    }
}

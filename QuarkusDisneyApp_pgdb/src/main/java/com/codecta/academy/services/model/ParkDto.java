package com.codecta.academy.services.model;

import com.codecta.academy.RepositoryPattern.entity.DisneyCharacter;
import java.util.ArrayList;
import java.util.List;

public class ParkDto {
    private Integer ID;
    private String location;
    private String attraction;
    private List<CharacterDto> disneyCharacters = new ArrayList<>();

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public List<CharacterDto> getDisneyCharacters() {
        return disneyCharacters;
    }

    public void setDisneyCharacters(List<CharacterDto> disneyCharacters) {
        this.disneyCharacters = disneyCharacters;
    }
}

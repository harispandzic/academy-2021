package com.codecta.academy.RepositoryPattern.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "codecta", name = "THEME_PARK")
public class ThemePark extends ModelObject{
    @SequenceGenerator(
            name = "themeParkSeq",
            sequenceName = "THEME_PARK_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "themeParkSeq")
    @Id
    @Column(name = "ID",nullable = false)
    private Integer ID;
    private String location;
    private String attraction;

    @OneToMany(mappedBy = "themePark", fetch = FetchType.LAZY)
    private List<DisneyCharacter> disneyCharacters = new ArrayList<>();

    public List<DisneyCharacter> getDisneyCharacters() {
        return disneyCharacters;
    }

    public void setDisneyCharacters(List<DisneyCharacter> disneyCharacters) {
        this.disneyCharacters = disneyCharacters;
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

    @Override
    public Integer getID() {
        return this.ID;
    }
}

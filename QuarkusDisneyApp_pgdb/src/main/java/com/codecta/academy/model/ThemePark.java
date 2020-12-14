package com.codecta.academy.model;

import javax.persistence.*;

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

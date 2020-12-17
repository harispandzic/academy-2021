package com.codecta.academy.services;

import com.codecta.academy.RepositoryPattern.entity.DisneyCharacter;
import com.codecta.academy.RepositoryPattern.entity.WelcomeMessage;
import com.codecta.academy.services.model.CharacterDto;
import com.codecta.academy.services.model.ParkDto;

import java.util.List;

public interface DisneyCharacterServices {
    WelcomeMessage welcomeMessage();
    CharacterDto add(CharacterDto character);
    List<CharacterDto> getAll();
    CharacterDto getByID(Integer ID);
    CharacterDto updateCharacter(Integer ID, CharacterDto newObject);
    boolean deleteByID(Integer ID);

    List<ParkDto> findAllThemeParks();
    ParkDto findThemeParkByID(Integer ID);
    ParkDto addThemePark(ParkDto themePark);
    ParkDto updateThemePark(Integer ID, ParkDto themePark);
    List<CharacterDto> findCharactersByParkID(Integer ID);
    List<ParkDto> findParksByCharacterName(String name);
}

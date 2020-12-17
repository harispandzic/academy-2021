package com.codecta.academy.services.impl;

import com.codecta.academy.RepositoryPattern.DisneyCharacterRepository;
import com.codecta.academy.RepositoryPattern.ThemeParkRepository;
import com.codecta.academy.RepositoryPattern.entity.DisneyCharacter;
import com.codecta.academy.RepositoryPattern.entity.ThemePark;
import com.codecta.academy.RepositoryPattern.entity.WelcomeMessage;
import com.codecta.academy.services.DisneyCharacterServices;
import com.codecta.academy.services.model.CharacterDto;

import javax.enterprise.context.ApplicationScoped;

import com.codecta.academy.services.model.ParkDto;
import org.modelmapper.ModelMapper;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class DisneyCharacterImpl implements DisneyCharacterServices {
    @Inject
    DisneyCharacterRepository repository;

    @Inject
    ThemeParkRepository themeParkRepository;

    @Override
    public WelcomeMessage welcomeMessage() {
        return new WelcomeMessage("Welcome Lands of Disneyland!","Here you can find...","Every day from 8 to 16 pm");
    }

    @Override
    public CharacterDto add(CharacterDto character) {
        if(character.getThemeParkID() == null){
            return null;
        }
        ThemePark themePark = themeParkRepository.getByID(character.getThemeParkID());
        if(themePark == null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        DisneyCharacter disneyCharacter = modelMapper.map(character,DisneyCharacter.class);
        disneyCharacter.setThemePark(themePark);
        disneyCharacter = repository.add(disneyCharacter);
        modelMapper.map(disneyCharacter,CharacterDto.class);
        return modelMapper.map(disneyCharacter,CharacterDto.class);
    }

    @Override
    public List<CharacterDto> getAll()
    {
        List<DisneyCharacter> disneyCharacterList = repository.getAll();
        if(disneyCharacterList == null || disneyCharacterList.isEmpty()){
            return null;
        }
        List<CharacterDto> characterDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(DisneyCharacter character : disneyCharacterList){
            characterDtoList.add(modelMapper.map(character, CharacterDto.class));
        }
        return characterDtoList;
    }

    @Override
    public CharacterDto getByID(Integer ID) {
        DisneyCharacter disneyCharacter = repository.getByID(ID);
        if(disneyCharacter == null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(disneyCharacter,CharacterDto.class);
    }


    @Override
    public CharacterDto updateCharacter(Integer ID, CharacterDto newObject) {
        DisneyCharacter disneyCharacter = repository.getByID(ID);
        ThemePark themePark = themeParkRepository.getByID(newObject.getThemeParkID());
        if(disneyCharacter != null && themePark!=null){
            disneyCharacter.setName(newObject.getName());
            disneyCharacter.setGreeting(newObject.getGreeting());
            disneyCharacter.setThemePark(themePark);
            disneyCharacter = repository.save(disneyCharacter);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(disneyCharacter,CharacterDto.class);
        }
        return null;
    }
    public boolean deleteByID(Integer ID){
        return repository.deleteByID(ID);
    }

    @Override
    public List<ParkDto> findAllThemeParks() {
        List<ThemePark> themeParks = themeParkRepository.getAll();
        if(themeParks == null || themeParks.isEmpty()){
            return null;
        }
        List<ParkDto> parkDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(ThemePark park : themeParks){
            parkDtoList.add(modelMapper.map(park, ParkDto.class));
        }
        return parkDtoList;
    }

    @Override
    public ParkDto findThemeParkByID(Integer ID) {
        ThemePark themePark = themeParkRepository.getByID(ID);
        if(themePark == null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(themePark,ParkDto.class);
    }

    @Override
    public ParkDto addThemePark(ParkDto themePark) {
        ModelMapper modelMapper = new ModelMapper();
        ThemePark park = modelMapper.map(themePark,ThemePark.class);
        park = themeParkRepository.add(park);
        return modelMapper.map(park,ParkDto.class);
    }

    @Override
    public ParkDto updateThemePark(Integer ID, ParkDto themePark) {
        ThemePark park = themeParkRepository.getByID(ID);
        if(park != null){
            park.setAttraction(themePark.getAttraction());
            park.setLocation(themePark.getLocation());
            park = themeParkRepository.save(park);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(park,ParkDto.class);
        }
        return null;
    }

    @Override
    public List<CharacterDto> findCharactersByParkID(Integer ID) {
        List<DisneyCharacter> characters = repository.findAllByID(ID);
        if(characters == null || characters.isEmpty()){
            return null;
        }
        List<CharacterDto> characterDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(DisneyCharacter character: characters){
            characterDtoList.add(modelMapper.map(character,CharacterDto.class));
        }
        return characterDtoList;
    }

    @Override
    public List<ParkDto> findParksByCharacterName(String name) {
        List<ThemePark> themeParks = themeParkRepository.findByCharacterName(name);
        if(themeParks == null || themeParks.isEmpty()){
            return null;
        }
        List<ParkDto> parkDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(ThemePark themePark: themeParks){
            parkDtoList.add(modelMapper.map(themePark,ParkDto.class));
        }
        return parkDtoList;
    }
}

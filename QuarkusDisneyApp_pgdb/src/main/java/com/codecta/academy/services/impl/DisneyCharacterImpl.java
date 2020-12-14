package com.codecta.academy.services.impl;

import com.codecta.academy.RepositoryPattern.DisneyCharacterRepository;
import com.codecta.academy.model.DisneyCharacter;
import com.codecta.academy.model.WelcomeMessage;
import com.codecta.academy.services.DisneyCharacterServices;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DisneyCharacterImpl implements DisneyCharacterServices {
    @Inject
    DisneyCharacterRepository repository;
    @Override
    public WelcomeMessage welcomeMessage() {
        return new WelcomeMessage("Welcome Lands of Disneyland!","Here you can find...","Every day from 8 to 16 pm");
    }

    @Override
    public DisneyCharacter add(DisneyCharacter character) {

        return repository.add(character);
    }

    @Override
    public List<DisneyCharacter> getAll() {
        return repository.getAll();
    }

    @Override
    public DisneyCharacter getByID(Integer ID) {
        return repository.getByID(ID);
    }


    @Override
    public DisneyCharacter updateCharacter(Integer ID, DisneyCharacter newObject) {
        DisneyCharacter disneyCharacter = repository.getByID(ID);
        if(disneyCharacter != null){
            disneyCharacter.setName(newObject.getName());
            disneyCharacter.setGreeting(newObject.getGreeting());
            return repository.save(disneyCharacter);
        }
        return null;
    }
    public boolean deleteByID(Integer ID){
        return repository.deleteByID(ID);
    }
}

package org.acme.services.impl;

import org.acme.model.DisneyCharacter;
import org.acme.model.WelcomeMessage;
import org.acme.repos.DisneyCharacterRepos;
import org.acme.services.DisneyServices;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DisneyServicesIml implements DisneyServices {
    @Inject
    DisneyCharacterRepos repo;
    @Override
    public WelcomeMessage welcome() {
        return new WelcomeMessage("Welcome Lands of Disneyland;","Here you can find...","Every dan from 8 to 16 pm");
    }

    @Override
    public List<DisneyCharacter> findAllCharacters() {
        return repo.findAll();
    }

    @Override
    public DisneyCharacter findByID(Integer ID) {
        return repo.findByID(ID);
    }

    @Override
    public DisneyCharacter addCharacter(DisneyCharacter character) {
        return repo.add(character);
    }

    @Override
    public DisneyCharacter update(Integer id, DisneyCharacter character) {
        return repo.update(id,character);
    }

    @Override
    public void delete(Integer id, DisneyCharacter character) {
        repo.delete(id,character);
    }

}

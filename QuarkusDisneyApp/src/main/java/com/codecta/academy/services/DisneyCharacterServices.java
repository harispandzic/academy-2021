package com.codecta.academy.services;

import com.codecta.academy.model.DisneyCharacter;
import com.codecta.academy.model.WelcomeMessage;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

public interface DisneyCharacterServices {
    WelcomeMessage welcomeMessage();
    DisneyCharacter add(DisneyCharacter character);
    List<DisneyCharacter> getAll();
    DisneyCharacter getByID(Integer ID);
    DisneyCharacter updateByID(Integer ID, DisneyCharacter newObject);
    boolean deleteByID(Integer ID);
}

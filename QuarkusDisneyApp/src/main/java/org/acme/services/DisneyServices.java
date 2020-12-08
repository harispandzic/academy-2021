package org.acme.services;

import org.acme.model.DisneyCharacter;
import org.acme.model.WelcomeMessage;

import java.util.List;

public interface DisneyServices {
    WelcomeMessage welcome();
    List<DisneyCharacter> findAllCharacters();
    DisneyCharacter findByID(Integer ID);
    DisneyCharacter addCharacter(DisneyCharacter character);
    DisneyCharacter update(Integer id,DisneyCharacter character);
    void delete(Integer id,DisneyCharacter character);
}

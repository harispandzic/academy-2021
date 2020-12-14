package com.codecta.academy.RepositoryPattern;

import com.codecta.academy.RepositoryPattern.Repository;
import com.codecta.academy.model.DisneyCharacter;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DisneyCharacterRepository extends Repository<DisneyCharacter, Integer> {
    public DisneyCharacterRepository() {
        super(DisneyCharacter.class);
    }
}

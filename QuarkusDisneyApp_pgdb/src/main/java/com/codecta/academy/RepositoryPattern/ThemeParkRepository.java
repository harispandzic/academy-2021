package com.codecta.academy.RepositoryPattern;

import com.codecta.academy.RepositoryPattern.Repository;
import com.codecta.academy.model.ThemePark;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class ThemeParkRepository extends Repository<ThemePark, Integer> {
    public ThemeParkRepository() {
        super(ThemePark.class);
    }
}

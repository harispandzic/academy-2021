package com.codecta.academy.RepositoryPattern;

import com.codecta.academy.RepositoryPattern.entity.DisneyCharacter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DisneyCharacterRepository extends Repository<DisneyCharacter, Integer> {
    public DisneyCharacterRepository() { super(DisneyCharacter.class); }

    public List<DisneyCharacter> findAllByID(Integer ID){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DisneyCharacter> cq = cb.createQuery(DisneyCharacter.class);
        Root<DisneyCharacter> root = cq.from(DisneyCharacter.class);
        root.fetch("themePark", JoinType.INNER);
        CriteriaQuery<DisneyCharacter> all = cq.select(root);
        all.where(cb.equal(root.get("themePark"),ID));
        TypedQuery<DisneyCharacter> allQuery = entityManager.createQuery(all);
        return  allQuery.getResultList();
    }
}

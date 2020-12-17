package com.codecta.academy.RepositoryPattern;

import com.codecta.academy.RepositoryPattern.entity.ModelObject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Repository<T extends ModelObject, PK extends Serializable> {
    private Class<T> entityClass;
    protected Repository(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @Inject
    EntityManager entityManager;

    public T add(T object){
        object.setCreatedOn(LocalDateTime.now());
        object.setModifiedOn(LocalDateTime.now());
        entityManager.persist(object);
        return object;
    }

    public List<T> getAll(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
        Root<T> root = cq.from(this.entityClass);
        CriteriaQuery<T> all = cq.select(root);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return  allQuery.getResultList();
    }

    public T getByID(PK ID){
        T result = entityManager.find(this.entityClass,ID);
        if(result != null){
            return result;
        }
        return null;
    }

    public T save(T object){
        T result = null;
        PK id = (PK)object.getID();
        if(id != null){
            result = getByID(id);
        }
        if(id == null || result != null){
            entityManager.persist(object);
            object.setModifiedOn(LocalDateTime.now());
            return object;
        }
        return null;
    }
    public boolean deleteByID(PK id){
        if(id != null){
            entityManager.remove(getByID(id));
            return true;
        }
        return false;
    }
}

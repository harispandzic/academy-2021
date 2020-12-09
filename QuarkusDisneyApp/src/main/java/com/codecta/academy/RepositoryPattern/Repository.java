package com.codecta.academy.RepositoryPattern;

import com.codecta.academy.model.ModelObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Repository<T extends ModelObject> {
    private Map<Integer,T> objectMap = new HashMap<>();

    //dodavanje elementa u "bazu"
    public T add(T object){
        Integer key = 1;
        if(!objectMap.isEmpty()){
            key = objectMap.keySet().stream().max(Integer::compare).get()+1;
        }
        object.setID(key);
        objectMap.put(key,object);
        return object;
    }
    //vraćanje svih elemenata iz "baze"
    public List<T> getAll(){
        return objectMap.values().stream().collect(Collectors.toList());
    }
    //vracanje elementa na osnovu ID
    public T getByID(Integer ID){
        if(objectMap.containsKey(ID)){
            return objectMap.get(ID);
        }
        return null;
    }
    //update zapisa na osnovu ID i objekta
    public T updateByID(Integer ID, T object){
        if(objectMap.containsKey(ID) && object!=null){
            objectMap.put(ID,object);
            return object;
        }
        return null;
    }
    public boolean deleteByID(Integer ID){
        if(objectMap.containsKey(ID)){
            Integer trenutniID = ID;
            T object = objectMap.get(ID);
            objectMap.remove(ID, object);
            return true;
        }
        return false;
    }
}

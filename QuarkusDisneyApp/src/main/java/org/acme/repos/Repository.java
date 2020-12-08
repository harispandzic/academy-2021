package org.acme.repos;

import org.acme.model.ModelObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Repository<T extends ModelObject> {
    private Map<Integer, T> objectMap = new HashMap<>();
    public T add(T modelObject)
    {
        Integer key = 1;
        if(!objectMap.isEmpty()){
            key = objectMap.keySet().stream().max(Integer::compare).get() + 1;
        }
        modelObject.setID(key);
        objectMap.put(key,modelObject);
        return modelObject;
    }
    public List<T> findAll(){
        return objectMap.values().stream().collect(Collectors.toList());
    }
    public T findByID(Integer ID){
        if(objectMap.containsKey(ID)){
            return objectMap.get(ID);
        }
        return null;
    }
    public T update(Integer ID,T newObject){
        if(objectMap.containsKey(ID)){
            objectMap.put(ID,newObject);
            return newObject;
        }
        return null;
    }
    public void delete(Integer ID, T object){
        if(objectMap.containsKey(ID) && object != null){
            objectMap.remove(ID,object);
            objectMap.get(ID+1).setID(ID);
        }
    }
}

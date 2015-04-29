package com.sim.star.bitworxx.starcity.meta;

import android.os.DropBoxManager;

import com.sim.star.bitworxx.starcity.constants.DB;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by WEIS on 20.04.2015.
 */
public class MetaObjectContainer<T extends MetaObject> {

    public HashMap<Integer,T> Objects;
    public String Name;
    public MetaObjectContainer(String name)
    {
        Objects=new HashMap<>();
        Name=name;
    }

    public MetaObjectContainer split(String field,String value)
    {
        MetaObjectContainer container =new MetaObjectContainer(value);
        for (Map.Entry<Integer,T> e : Objects.entrySet())
        {
            if(e.getValue().hasField(field,value))
                container.Objects.put(e.getKey(),e.getValue());
        }
        return  container;
    }

    public <TA extends MetaObjectContainer<T>> TA splitEx(String field,String value)
    {
        TA container =(TA)createThis(value);
        for (Map.Entry<Integer,T> e : Objects.entrySet())
        {
            if(e.getValue().hasField(field,value))
                container.Objects.put(e.getKey(),e.getValue());
        }
        return  container;
    }

    public MetaObjectContainer<T> createThis(String name)
    {

        return new MetaObjectContainer<>(name);
    }

    public MetaObject createItem(String name)
    {
        return  new MetaObject(name);
    }

    public T getItem(Integer key)
    {
        return (T) Objects.get(key);
    }

    public T getFirst(){
       for(Map.Entry<Integer,T> e : Objects.entrySet())
           return e.getValue();
        return null;
    }

    public T getLast(){

        T result=null;
        for(Map.Entry<Integer,T> e : Objects.entrySet())
            result= e.getValue();

       return result;
    }

    public void register(Integer id,T item)
    {
        if (!Objects.containsKey(id))
            Objects.put(id,item);
    }


    public void save()
    {
        for(Map.Entry<Integer,T> e : Objects.entrySet())
        {
            DB.saveFields(e.getKey(),e.getValue());
        }
    }
}

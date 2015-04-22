package com.sim.star.bitworxx.starcity.meta;

import android.os.DropBoxManager;

import com.sim.star.bitworxx.starcity.constants.DB;

import java.lang.reflect.Field;
import java.util.HashMap;
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

    public T getItem(Integer key)
    {
        return (T) Objects.get(key);
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

package com.sim.star.bitworxx.starcity.meta;

import android.os.DropBoxManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 20.04.2015.
 */
public class MetaObjectContainer {

    public HashMap<Integer,MetaObject> Objects;
    public String Name;
    public MetaObjectContainer(String name)
    {
        Objects=new HashMap<>();
        Name=name;
    }

    public MetaObjectContainer split(String field,String value)
    {
        MetaObjectContainer container =new MetaObjectContainer(value);
        for (Map.Entry<Integer,MetaObject> e : Objects.entrySet())
        {
            if(e.getValue().hasField(field,value))
                container.Objects.put(e.getKey(),e.getValue());
        }
        return  container;
    }
}

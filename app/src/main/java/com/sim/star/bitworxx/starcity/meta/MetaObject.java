package com.sim.star.bitworxx.starcity.meta;

import com.sim.star.bitworxx.starcity.meta.game.interfaces.IMetaObject;
import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by WEIS on 20.04.2015.
 */
public class MetaObject implements IMetaObject
{

    public MetaFieldContainer Fields;
    public String Name;

    public MetaObject(String name)
    {
        Fields=new MetaFieldContainer();

        Name=name;
    }

    public boolean hasField(String name,String value)
    {
        return Fields.hasField(name,value);
    }

    public boolean hasField(String name,float value)
    {
        return Fields.hasField(name,value);
    }

    protected HashMap<String,MetaField> generate()
    {
        return new HashMap<>();
    }

    public void create()
    {
        HashMap<String,MetaField> map = generate();
        map.put("name",new MetaField());
        map.put("id",new MetaField(UUID.randomUUID().toString()));
        create(map);
    }

    public String getName()
    {
        return Fields.getValue("name");
    }

    public String getId()
    {
        return Fields.getValue("id");
    }

    public String getValue(String field)
    {
        return Fields.getValue(field);
    }

    public float getInternalValue(String field)
    {
        return Fields.getInternalValue(field);
    }

    public void create(HashMap<String,MetaField> parameters)
    {
       for(Map.Entry<String,MetaField> p : parameters.entrySet())
           Fields.register(p.getKey(),p.getValue());

    }
}

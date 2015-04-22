package com.sim.star.bitworxx.starcity.meta;

import java.util.HashMap;

/**
 * Created by WEIS on 20.04.2015.
 */
public class MetaFieldContainer {

    public HashMap<String, MetaField> Fields;

    public MetaFieldContainer() {
        Fields = new HashMap<>();
    }


    public void register(String name, MetaField field) {
        if (Fields.containsKey(name))
            Fields.remove(name);
        Fields.put(name, field);


    }

    public String getValue(String name)
    {
        return Fields.containsKey(name)?Fields.get(name).Value:null;
    }

    public float getInternalValue(String name)
    {
        return Fields.containsKey(name)?Fields.get(name).InternalValue:null;
    }

    public MetaField getField(String field)
    {
        return Fields.get(field);
    }

    public boolean hasField(String name,String value)
    {
        if(Fields.containsKey(name))
            if(Fields.get(name).Value.equals(value))
                return true;

        return false;
    }

    public boolean hasField(String name,float value)
    {
        if(Fields.containsKey(name))
            if(Fields.get(name).InternalValue==value)
                return true;

        return false;
    }
}

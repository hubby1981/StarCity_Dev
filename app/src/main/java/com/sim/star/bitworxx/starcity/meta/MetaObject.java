package com.sim.star.bitworxx.starcity.meta;

import com.sim.star.bitworxx.starcity.views.pattern.PatternBase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 20.04.2015.
 */
public class MetaObject
{

    public MetaFieldContainer Fields;
    public String Name;

    public MetaObject()
    {
        this("");
    }


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


}

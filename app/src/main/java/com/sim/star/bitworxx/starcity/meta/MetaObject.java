package com.sim.star.bitworxx.starcity.meta;

import android.graphics.drawable.BitmapDrawable;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.game.interfaces.IMetaObject;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;
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
    public boolean WasNew=false;
    public Integer RealDB=0;
    public String ParentId="";
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
        WasNew=true;
        HashMap<String,MetaField> map = generate();
        map.put("name",new MetaField());
        map.put("id",new MetaField(UUID.randomUUID().toString()));
        create(map);
    }

    public void save()
    {
        DB.saveFields(RealDB,this);
        MenuBitmaps.BitmapDrawables.clear();
    }

    public String getName()
    {
        return Fields.getValue(F.FIELD_NAME);
    }

    public String getId()
    {
        return Fields.getValue(F.FIELD_ID);
    }

    public void setName(String name){setFieldValue(F.FIELD_NAME,name);}
    public void setId(String id){setFieldValue(F.FIELD_ID,id);}

    public void setFieldValue(String field,String value)
    {
        MetaField fieldItem = Fields.getField(field);
        if(fieldItem!=null)
            fieldItem.Value=value;
        else
            Fields.register(field,new MetaField(value));
    }

    public void setFieldInternalValue(String field,float value)
    {
        MetaField fieldItem = Fields.getField(field);
        if(fieldItem!=null)
            fieldItem.InternalValue=value;
        else
            Fields.register(field,new MetaField("",value));
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

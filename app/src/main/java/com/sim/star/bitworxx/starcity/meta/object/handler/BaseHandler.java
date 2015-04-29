package com.sim.star.bitworxx.starcity.meta.object.handler;

import android.view.LayoutInflater;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.db.Meta;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyMetaObject;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 22.04.2015.
 */
public abstract class BaseHandler<T extends MetaObject,TC extends MetaObjectContainer<T>> {
    protected ArrayList<String> _names= new ArrayList<>();


    public TC Container;
    public String ParentId;
    public BaseHandler(String name)
    {
        init(name);
        load();
    }

    public BaseHandler(String name,String parentId)
    {

        ParentId=parentId;
        init(name);
        load();
        split();
        if(Container.Objects.size()==0)
            create();
    }

    private void initNames()
    {
        _names.add("A");
        _names.add("B");
        _names.add("C");
        _names.add("D");
        _names.add("E");
        _names.add("F");
        _names.add("G");
        _names.add("H");
        _names.add("I");
        _names.add("J");
        _names.add("K");
        _names.add("L");
        _names.add("M");
        _names.add("N");
        _names.add("P");
        _names.add("Q");
        _names.add("R");
        _names.add("S");
        _names.add("T");
        _names.add("U");
        _names.add("V");
        _names.add("W");
        _names.add("X");
        _names.add("Y");
        _names.add("Z");




    }

    public void init(String name)
    {

        try {
           Container = (TC)Class.forName(className()).getDeclaredConstructor(String.class).newInstance(name);
        }catch(Exception e){
            String ex=e.getMessage();
        };
    }

    protected abstract String className();

    public void split()
    {
        if(ParentId!=null)
            Container = (TC)Container.split(F.FIELD_PARENT_ID,ParentId);
    }

    public void load()
    {
        DB.fillContainer(Container);
        if(Container.Objects.size()==0)
            create();
        else
            reloadParent();
    }

    public void reloadParent()
    {
      for(Map.Entry<Integer,T> e : Container.Objects.entrySet())
      {
          e.getValue().ParentId=ParentId;
      }
    }

    public void save()
    {
        Container.save();
    }

    protected abstract void create();


    public Integer add(T item)
    {
        int result= DB.addMetaObject(item);
        if(result>-1)
            Container.register(result,item);
        return result;
    }


    protected String getNameFromList(int id)
    {
        if(_names.size()==0)initNames();
        return _names.get(id);

    }

}

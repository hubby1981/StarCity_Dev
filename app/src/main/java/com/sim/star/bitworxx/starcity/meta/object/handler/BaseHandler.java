package com.sim.star.bitworxx.starcity.meta.object.handler;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.db.Meta;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyMetaObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 22.04.2015.
 */
public abstract class BaseHandler<T extends MetaObject> {

    public MetaObjectContainer<T> Container;
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

    public void init(String name)
    {
        Container=new MetaObjectContainer(name);

    }

    public void split()
    {
        if(ParentId!=null)
            Container = Container.split("parent-id",ParentId);
    }

    public void load()
    {
        DB.fillContainer(Container);
        if(Container.Objects.size()==0)
            create();
    }

    public void save()
    {
        Container.save();
    }

    protected abstract void create();


    public Integer add(T item)
    {
      return DB.addMetaObject(item);
    }


}

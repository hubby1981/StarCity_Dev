package com.sim.star.bitworxx.starcity.db;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.views.pages.Content;

import java.util.HashMap;

/**
 * Created by WEIS on 09.04.2015.
 */
public class Meta {

    public String get_from_gm() {
        return GM.Started;
    }

    public static HashMap<String,MetaObjectContainer> Container=null;


    public static MetaObjectContainer getContainer(String key,String field,String value)
    {
        String metaKey = key+value;
        MetaObjectContainer container=null;


        if(Container==null) Container=new HashMap<>();

        if(!Container.containsKey(metaKey)) {
            if (Container.containsKey(key))
            { container= Container.get(key).split(field, value);}
            Container.put(metaKey, container);

        }
        else
        {
            container=Container.get(metaKey);
        }


        return container;
    }




    public static MetaObjectContainer getContainer(String value)
    {
        MetaObjectContainer container=null;

        if(Container==null) Container=new HashMap<>();
        if(Container.containsKey(value))
            return Container.get(value);
        else{
            container= new MetaObjectContainer(value);
            DB.fillContainer(container);
            Container.put(value,container);
        }
        return container;

    }
}

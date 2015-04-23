package com.sim.star.bitworxx.starcity.meta.object.handler;

import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemMetaObject;

import java.util.HashMap;

/**
 * Created by WEIS on 22.04.2015.
 */
public class GalaxySystemHandler extends BaseHandler<GalaxySystemMetaObject> {
    public GalaxySystemHandler(String parent) {
        super("galaxy-system",parent);
        SystemObjects=new HashMap<>();
        fill();
    }

    public void fill()
    {
        SystemObjects=new HashMap<>();
        for(Integer k : Container.Objects.keySet())
        {
            try{
                MetaObject m = Container.getItem(k);
                if(m!=null)
                {
                    fillSystem(m);
                }}catch(Exception e){
                String mm = e.getMessage();
            }
        }
    }

    public void fillSystem(MetaObject system)
    {
        GalaxySystemObjectHandler object = new GalaxySystemObjectHandler(system.getId());
        SystemObjects.put(system.getId(),object);
    }

    public HashMap<String,GalaxySystemObjectHandler> SystemObjects;
    @Override
    protected void create() {
        GalaxySystemMetaObject galaxySystem = new GalaxySystemMetaObject();
        galaxySystem.create();
        galaxySystem.Fields.register("parent-id", new MetaField(ParentId));

        add(galaxySystem);
    }
}

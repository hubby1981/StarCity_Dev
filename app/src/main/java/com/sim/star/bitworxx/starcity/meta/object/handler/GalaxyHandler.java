package com.sim.star.bitworxx.starcity.meta.object.handler;

import android.os.DropBoxManager;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyAreaMetaObject;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyMetaObject;

import com.sim.star.bitworxx.starcity.meta.game.interfaces.IMetaObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by WEIS on 22.04.2015.
 */
public  class GalaxyHandler extends BaseHandler<GalaxyMetaObject> {



    private HashMap<String,GalaxyAreaHandler> Areas;

    public GalaxyHandler()
    {
       super("galaxy");
        fill();
    }


    public void fill()
    {
        Areas=new HashMap<>();
        for(Integer k : Container.Objects.keySet())
        {
            try{
            MetaObject m = Container.getItem(k);
            if(m!=null)
            {
                fillGalaxy(m);
            }}catch(Exception e){
                String mm = e.getMessage();
            }
        }
    }

    public void fillGalaxy(MetaObject galaxy)
    {
        GalaxyAreaHandler area = new GalaxyAreaHandler(galaxy.getId());
        Areas.put(galaxy.getId(),area);
    }


    @Override
    protected void create() {
       GalaxyMetaObject galaxy = new GalaxyMetaObject();
       galaxy.create();
       add(galaxy);
    }
}

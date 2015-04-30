package com.sim.star.bitworxx.starcity.helper;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.MetaObject;

/**
 * Created by WEIS on 30.04.2015.
 * This object helps to interact with the metaobjects base like saving or handling
 */
public abstract class BaseMetaObject {

    public boolean HasMeta=false;
    public MetaObject DATA=null;

    public BaseMetaObject(MetaObject data)
    {
        if(data==null)
        {
            DATA=new MetaObject("");
            HasMeta = false;

        }
        else
        {
            DATA=data;
            HasMeta = true;
        }
    }

    public void save()
    {
        if(DATA!=null&&HasMeta)
        {
            DB.saveFields(DATA.RealDB,DATA);
        }
    }
}

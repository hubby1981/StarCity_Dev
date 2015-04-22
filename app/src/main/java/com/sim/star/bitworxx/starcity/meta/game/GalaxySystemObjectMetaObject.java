package com.sim.star.bitworxx.starcity.meta.game;

import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaObject;

/**
 * Created by WEIS on 22.04.2015.
 */

public class GalaxySystemObjectMetaObject extends MetaObject {
    public GalaxySystemObjectMetaObject() {
        super("galaxy-system-object");
    }

    @Override
    public void create()
    {
        super.create();
        Fields.register("galaxy-system",new MetaField());

    }
}
package com.sim.star.bitworxx.starcity.meta.object.handler;

import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyAreaMetaObject;
import com.sim.star.bitworxx.starcity.meta.game.GalaxyMetaObject;

/**
 * Created by WEIS on 22.04.2015.
 */
public class GalaxyAreaHandler extends BaseHandler<GalaxyAreaMetaObject> {

    public GalaxyAreaHandler(String galaxy) {
        super("galaxy-area",galaxy);
    }

    @Override
    protected void create() {


        for(int i=0;i<16;i++)
        {
            GalaxyAreaMetaObject area = new GalaxyAreaMetaObject();
            area.create();
            area.Fields.register("parent-id",new MetaField(ParentId));
            add(area);
        }
    }
}

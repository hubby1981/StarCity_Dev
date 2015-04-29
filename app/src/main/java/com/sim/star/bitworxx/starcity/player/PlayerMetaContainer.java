package com.sim.star.bitworxx.starcity.player;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;

/**
 * Created by WEIS on 29.04.2015.
 */
public class PlayerMetaContainer extends MetaObjectContainer<PlayerMetaObject> {
    public PlayerMetaContainer(String name) {
        super(name);
    }

    @Override
    public MetaObject createItem(String name)
    {
        return new PlayerMetaObject(name);
    }
}

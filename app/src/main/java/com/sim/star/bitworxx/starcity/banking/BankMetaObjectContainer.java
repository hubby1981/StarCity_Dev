package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.player.PlayerMetaObject;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankMetaObjectContainer extends MetaObjectContainer<BankMetaObject> {
    public BankMetaObjectContainer(String name) {
        super(name);
    }


    @Override
    public MetaObject createItem(String name)
    {
        return new BankMetaObject(name);
    }
    @Override
    public BankMetaObjectContainer createThis(String name)
    {
        return new BankMetaObjectContainer(name);
    }
}

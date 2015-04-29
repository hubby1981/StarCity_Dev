package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankSlotMetaObjectContainer extends MetaObjectContainer<BankSlotMetaObject> {
    public BankSlotMetaObjectContainer(String name) {
        super(name);
    }

    @Override
    public BankSlotMetaObject createItem(String name)
    {
        return new BankSlotMetaObject(name);
    }
    @Override
    public BankSlotMetaObjectContainer createThis(String name)
    {
        return new BankSlotMetaObjectContainer(name);
    }
}

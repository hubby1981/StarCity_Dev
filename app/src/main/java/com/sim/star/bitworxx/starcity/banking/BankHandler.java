package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.object.handler.BaseHandler;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankHandler extends BaseHandler<BankMetaObject,BankMetaObjectContainer> {
    public BankHandler(String name, String parentId) {
        super(name, parentId);
    }

    @Override
    protected void create() {

        BankMetaObject playerBank=new BankMetaObject(ParentId);
        playerBank.create();
        playerBank.setFieldValue(F.FIELD_PARENT_ID,ParentId);
        add(playerBank);
    }
}

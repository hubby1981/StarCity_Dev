package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.object.handler.BaseHandler;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankSlotHandler extends BaseHandler<BankSlotMetaObject,BankSlotMetaObjectContainer> {
    public BankSlotHandler(String name) {
        super(name);
    }

    public BankSlotHandler(String name, String parentId) {
        super(name, parentId);
    }

    @Override
    protected String className() {
        return "com.sim.star.bitworxx.starcity.banking.BankSlotMetaObjectContainer";
    }

    @Override
    protected void create() {

        add(BankingHelper.createBaseSlot(ParentId));

    }


    private BankSlotMetaObject getSlot(String type)
    {
       MetaObjectContainer<BankSlotMetaObject> result= Container.split(F.FIELD_BANK_SLOT_TYPE,type);
        if(result!=null)
            return result.getFirst();
        return null;
    }

    public BankSlotMetaObject getMainSlot()
    {
        return getSlot("main");
    }

    public BankSlotMetaObject getSlotById(String id)
    {
        MetaObjectContainer<BankSlotMetaObject> result= Container.split(F.FIELD_ID,id);
        if(result!=null)
            return result.getFirst();
        return null;
    }

    private String getMoney(BankSlotMetaObject slot)
    {

        if(slot!=null)
            return BankingHelper.formatMoney(slot.getInternalValue(F.FIELD_BANK_SLOT_CREDITS));
        return "0";
    }

    public String getMainMoney()
    {
        return getMoney(getMainSlot());
    }
}

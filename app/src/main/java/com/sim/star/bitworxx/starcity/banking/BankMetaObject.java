package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;

/**
 * Created by WEIS on 29.04.2015.
 */

public class BankMetaObject extends MetaObject {

    private String ParentId="";
    public BankSlotHandler Handler;

    public BankMetaObject(String parentId)
    {
        super("bank");
        ParentId=parentId;
        Handler=new BankSlotHandler("bank_slot",ParentId);
        if(WasNew)
            setFieldValue(F.FIELD_PARENT_ID,ParentId);
    }



    @Override
    public void create()
    {
        super.create();

        setFieldValue(F.FIELD_BANK_SLOT0,"active");
        setFieldValue(F.FIELD_BANK_SLOT1,"inactive");
        setFieldValue(F.FIELD_BANK_SLOT2,"inactive");
        setFieldValue(F.FIELD_BANK_SLOT3,"inactive");
        setFieldValue(F.FIELD_BANK_SLOT4,"inactive");
        setFieldValue(F.FIELD_BANK_SLOT5,"inactive");

    }

    public String getMainMoney()
    {
       return Handler.getMainMoney();
    }

    public void addMoney(float money)
    {
        Handler.getMainSlot().addMoney(money);
    }

    public String receiveMoney()
    {
        BankSlotMetaObject slot =          Handler.getMainSlot();

        return slot!=null?slot.getId():"";
    }

    public BankSlotMetaObject getSlotById(String id)
    {
        return Handler.getSlotById(id);
    }
}
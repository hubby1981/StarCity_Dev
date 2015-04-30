package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.helper.BaseMetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankSlotBaseMetaObject extends BaseMetaObject {

    public BankSlotBaseMetaObject(MetaObject data)
    {
       super(data);

    }


    public String getSlotType()
    {
        return DATA.getValue(F.FIELD_BANK_SLOT_TYPE);
    }


    public void addMoney(float money)
    {
        DATA.setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS, DATA.getInternalValue(F.FIELD_BANK_SLOT_CREDITS) + money);
    }

    public CreditTransaction receiveMoney(float money,String slotIdTo)
    {
       if(DATA.getInternalValue(F.FIELD_BANK_SLOT_CREDITS)-prepareSend()>=money)
       {
           CreditTransaction transaction = new CreditTransaction(money,slotIdTo,DATA.getId());

           return transaction;
       }
        return null;
    }


    private float prepareSend()
    {
        return DATA.getInternalValue(F.FIELD_BANK_SLOT_CREDITS_SEND);
    }

    public boolean transactId(String id,float money)
    {
        if(prepareSend()>=money)
        {
            DATA.setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS, DATA.getInternalValue(F.FIELD_BANK_SLOT_CREDITS) - money);
            DATA.setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS_SEND,prepareSend()-money);

            return true;
        }
        return false;
    }
}

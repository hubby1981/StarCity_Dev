package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankSlotMetaObject extends MetaObject {

    private HashMap<String,Float> SendMoney=new HashMap<>();


    public BankSlotMetaObject(String parentId) {
        super("bank_slot");
        if(WasNew)
            setFieldValue(F.FIELD_PARENT_ID,parentId);
    }

    @Override
    public void create()
    {
        super.create();


    }



    public String getSlotType()
    {
        return getValue(F.FIELD_BANK_SLOT_TYPE);
    }


    public void addMoney(float money)
    {
        setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS,getInternalValue(F.FIELD_BANK_SLOT_CREDITS)+money);
    }

    public CreditTransaction receiveMoney(float money,String slotIdTo)
    {
       if(getInternalValue(F.FIELD_BANK_SLOT_CREDITS)-prepareSend()>=money)
       {
           CreditTransaction transaction = new CreditTransaction(money,slotIdTo,getId());

           return transaction;
       }
        return null;
    }

    private float prepareSend()
    {
        float result=0;
        for(Map.Entry<String,Float> e : SendMoney.entrySet())
            result+=e.getValue();
        return result;
    }

    public boolean transactId(String id)
    {
        if(SendMoney.containsKey(id))
        {
            setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS,getInternalValue(F.FIELD_BANK_SLOT_CREDITS)-SendMoney.get(id));
            SendMoney.remove(id);

            return true;
        }
        return false;
    }
}

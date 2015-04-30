package com.sim.star.bitworxx.starcity.banking;

import java.util.UUID;

/**
 * Created by WEIS on 29.04.2015.
 */
public class CreditTransaction {

    public String ID = UUID.randomUUID().toString();
    public float MONEY=0;
    public String FROM="0";
    public String TO="0";
    public String REFERENCE="TRANSACTION";



    public CreditTransaction(float money,String toSlotId)
    {
        MONEY=money;
        TO =toSlotId;
    }
    public CreditTransaction(float money,String toSlotId,String fromSlotId)
    {
        this(money,toSlotId);
        FROM=fromSlotId;
    }

    public String transact()
    {
        BankSlotBaseMetaObject slotTo =new BankSlotBaseMetaObject( BankingHelper.getSlot(TO));
        BankSlotBaseMetaObject slotFrom = new BankSlotBaseMetaObject(BankingHelper.getSlot(FROM));



        if(slotFrom.HasMeta)
        {
            if(slotFrom.transactId(ID,MONEY)) {
                if (slotTo.HasMeta) {
                    slotTo.addMoney(MONEY);
                    slotTo.save();
                    slotFrom.save();

                }
            }
        }
        else
        {
            if(slotTo.HasMeta)
            {
                slotTo.addMoney(MONEY);
                slotTo.save();
            }
        }
        MONEY=0;
        return ID;
    }
}

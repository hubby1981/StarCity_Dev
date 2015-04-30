package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.helper.BaseMetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 */
public class BankBaseMetaObject extends BaseMetaObject {

    public BankBaseMetaObject(MetaObject data)
    {
        super(data);

    }

    public BankSlotBaseMetaObject getMainSlot()
    {
        ArrayList<MetaObject> slots =BankingHelper.getBankSlots(DATA.getId());

        for (MetaObject m :slots)
        {
            if(m.getValue(F.FIELD_BANK_SLOT_TYPE).equals("main"))
                return new BankSlotBaseMetaObject(m);
        }
        return null;
    }

    public String getMainMoney()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return BankingHelper.formatMoney( slot!=null?slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_CREDITS):0);
    }

    public String receiveMoney()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return slot!=null?slot.DATA.getId():"";
    }
}

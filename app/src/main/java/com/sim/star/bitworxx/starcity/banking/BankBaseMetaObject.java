package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.helper.BaseMetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 * Helps to handle base bank activities
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

    public String getMainSkill()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_SKILL_POINTS)).toString();
    }

    public String getMainTech()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_TECH_POINTS)).toString();
    }
    public String getMainLoop()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_LOOP_POINTS)).toString();
    }

    public String getMainCrystalBlue()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_BLUE_CRISTAL)).toString();
    }

    public String getMainCrystalGreen()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_GREEN_CRISTAL)).toString();
    }

    public String getMainCrystalYellow()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_YELLOW_CRISTAL)).toString();
    }

    public String getMainCrystalRed()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_RED_CRISTAL)).toString();
    }

    public String getMainCrystalViolet()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return ((Integer)(int)slot.DATA.getInternalValue(F.FIELD_BANK_SLOT_VIOLET_CRISTAL)).toString();
    }


    public String receiveMoney()
    {
        BankSlotBaseMetaObject slot = getMainSlot();
        return slot!=null?slot.DATA.getId():"";
    }
}

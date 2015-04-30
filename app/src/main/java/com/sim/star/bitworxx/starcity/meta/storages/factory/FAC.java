package com.sim.star.bitworxx.starcity.meta.storages.factory;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.db.Meta;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.fields.MF;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.04.2015.
 */
public class FAC {

    public static ArrayList<MetaObject> create(String parentId,String name)
    {
            ArrayList<MetaObject> items = new ArrayList<>();
            if(name.equals(MF.META_NAME_BANK))
                createBank(parentId,items);
            if(name.equals(MF.META_NAME_BANK_SLOT))
                createBankSlots(parentId,items);

            for(MetaObject m : items)
                m.RealDB=DB.addMetaObject(m);
            return  items;
    }

    private static void createBank(String parentId,ArrayList<MetaObject> banks)
    {


        MetaObject bank = new MetaObject(MF.META_NAME_BANK);
        bank.create();
        bank.setFieldValue(F.FIELD_PARENT_ID, parentId);
        bank.setFieldValue(F.FIELD_BANK_SLOT0,"active");
        bank.setFieldValue(F.FIELD_BANK_SLOT1, "inactive");
        bank.setFieldValue(F.FIELD_BANK_SLOT2, "inactive");
        bank.setFieldValue(F.FIELD_BANK_SLOT3, "inactive");
        bank.setFieldValue(F.FIELD_BANK_SLOT4, "inactive");
        bank.setFieldValue(F.FIELD_BANK_SLOT5, "inactive");

        banks.add(bank);

    }


    private static void createBankSlots(String parentId,ArrayList<MetaObject> bankSlots)
    {

        MetaObject slot = new MetaObject(MF.META_NAME_BANK_SLOT);
        slot.create();
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_CREDITS,(float)1000000);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_TECH_POINTS,(float)10);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_SKILL_POINTS,(float)10);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_LOOP_POINTS,(float)10);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_BLUE_CRISTAL,(float)1000);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_GREEN_CRISTAL,(float)500);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_YELLOW_CRISTAL,(float)100);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_RED_CRISTAL,(float)10);
        slot.setFieldInternalValue(F.FIELD_BANK_SLOT_VIOLET_CRISTAL,(float)1);
        slot.setFieldValue(F.FIELD_BANK_SLOT_TYPE,"main");
        slot.setFieldValue(F.FIELD_PARENT_ID,parentId);
        bankSlots.add(slot);
    }
}

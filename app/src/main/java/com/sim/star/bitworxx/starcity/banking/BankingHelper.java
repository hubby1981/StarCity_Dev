package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.player.PlayerStore;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankingHelper {



public static HashMap<String,BankHandler> Bank;

    static{

        init();
    }

    public static void init()
    {
        Bank = new HashMap<>();



    }

    public static BankMetaObject getBank(String playerId)
    {
       if(!Bank.containsKey(playerId))
           Bank.put(playerId,new BankHandler("bank",playerId));
       if(Bank.containsKey(playerId))
           return Bank.get(playerId).Container.getFirst();
       return null;
    }

    public static BankSlotMetaObject getSlot(String slotId)
    {
       for(Map.Entry<String,BankHandler> b : Bank.entrySet())
       {
           for(Map.Entry<Integer,BankMetaObject> e:b.getValue().Container.Objects.entrySet())
           {
               BankSlotMetaObject result = e.getValue().getSlotById(slotId);
               if(result!=null)
                   return result;

           }
       }

        return null;
    }




    public static String formatMoney(float value)
    {
        DecimalFormat formatter = (DecimalFormat)NumberFormat.getCurrencyInstance();
        formatter.getDecimalFormatSymbols().setCurrencySymbol("");
        String money= formatter.format((long) value);

        return money;
    }

    public static BankSlotMetaObject createBaseSlot()
    {
        BankSlotMetaObject slot = new BankSlotMetaObject(PlayerStore.LAST_PLAYER.getId());
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

        return slot;
    }
}

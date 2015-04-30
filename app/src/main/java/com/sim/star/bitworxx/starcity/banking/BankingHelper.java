package com.sim.star.bitworxx.starcity.banking;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.fields.MF;
import com.sim.star.bitworxx.starcity.meta.storages.BankStorageLoader;
import com.sim.star.bitworxx.starcity.player.PlayerStore;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankingHelper {


   private static BankStorageLoader BL;


    static{

        init();
    }

    public static void init()
    {
        BL =   new BankStorageLoader(PlayerStore.LAST_PLAYER.getId());
        BL.load();
    }

    public static MetaObject getBank(String playerId)
    {
      ArrayList<MetaObject> result=new ArrayList<>();
      BL.getByNameAndParentId(playerId,MF.META_NAME_BANK,result);
      if(result.size()>0)return result.get(0);
      return null;
    }

    public static ArrayList<MetaObject> getBankSlots(String playerId)
    {
        ArrayList<MetaObject> result=new ArrayList<>();
        BL.getByNameAndParentId(playerId, MF.META_NAME_BANK_SLOT,result);
        if(result.size()>0)return result;
        return null;
    }



    public static MetaObject getSlot(String slotId)
    {
        ArrayList<MetaObject> result=new ArrayList<>();
        BL.getByNameAndId(slotId,MF.META_NAME_BANK_SLOT,result);
        if(result.size()>0)return result.get(0);

        return null;
    }




    public static String formatMoney(float value)
    {
        DecimalFormat formatter = (DecimalFormat)NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setCurrencySymbol("");
        formatter.setDecimalFormatSymbols(symbols);
        String money= formatter.format((long) value);

        return money;
    }


}

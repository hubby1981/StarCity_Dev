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
                BankFAC.createBank(parentId,items);
            if(name.equals(MF.META_NAME_BANK_SLOT))
                BankFAC.createBankSlots(parentId,items);

            for(MetaObject m : items)
                m.RealDB=DB.addMetaObject(m);
            return  items;
    }


}

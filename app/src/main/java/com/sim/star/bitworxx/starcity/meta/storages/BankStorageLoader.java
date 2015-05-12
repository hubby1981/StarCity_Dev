package com.sim.star.bitworxx.starcity.meta.storages;

import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.MF;

import java.util.ArrayList;

/**
 * Created by WEIS on 29.04.2015.
 */
public class BankStorageLoader extends StorageLoader {
    public BankStorageLoader(String parent) {
        super(parent);
    }

    @Override
    protected void loadNames() {
        LoadPipe.add(MF.META_NAME_BANK);
        LoadPipe.add(MF.META_NAME_BANK_SLOT);
    }

}

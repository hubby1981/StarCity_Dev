package com.sim.star.bitworxx.starcity.meta.storages;

import com.sim.star.bitworxx.starcity.meta.MetaObject;

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
        LoadPipe.add("bank");
        LoadPipe.add("bank_slot");
    }

}

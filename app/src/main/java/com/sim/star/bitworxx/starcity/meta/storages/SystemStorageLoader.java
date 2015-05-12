package com.sim.star.bitworxx.starcity.meta.storages;

import com.sim.star.bitworxx.starcity.meta.fields.MF;

/**
 * Created by WEIS on 12.05.2015.
 */
public class SystemStorageLoader extends StorageLoader {
    @Override
    protected void loadNames() {
        LoadPipe.add(MF.META_NAME_GALACTIC_SYSTEM);
        LoadPipe.add(MF.META_NAME_GALACTIC_SYSTEM_Object);

    }
}

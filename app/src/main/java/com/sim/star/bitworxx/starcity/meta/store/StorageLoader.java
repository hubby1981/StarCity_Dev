package com.sim.star.bitworxx.starcity.meta.store;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.fields.F;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by WEIS on 29.04.2015.
 */
public abstract class StorageLoader {

    public ArrayList<String> LoadPipe=new ArrayList<>();
    public ArrayList<Storage> Items = new ArrayList<>();
    public String ParentId;
    public StorageLoader(String parent)
    {
        ParentId = parent;
        loadNames();
    }

    public StorageLoader()
    {
        this("");
    }

    protected abstract void loadNames();


    public void load()
    {
        Items=new ArrayList<>();
        if(LoadPipe.size()>0)
        {
            String name = LoadPipe.get(0);
            LoadPipe.remove(0);
            MetaObjectContainer<MetaObject> container = new MetaObjectContainer<>(name);
            DB.fillContainer(container);
            if(ParentId!="")
                container.split(F.FIELD_PARENT_ID,ParentId);
            if(container.Objects.size()>0)
            {
                for(Map.Entry<Integer,MetaObject> m : container.Objects.entrySet())
                {
                    m.getValue().RealDB=m.getKey();

                    Items.add(new Storage(m.getValue(),LoadPipe));
                }
            }
        }
    }
}

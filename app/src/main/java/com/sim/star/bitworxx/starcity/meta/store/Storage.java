package com.sim.star.bitworxx.starcity.meta.store;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.fields.F;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by WEIS on 29.04.2015.
 */
public class Storage {

    public MetaObject Data;
    public ArrayList<Storage> Items=new ArrayList<>();
    public ArrayList<String> Next;

    public Storage(MetaObject data,ArrayList<String> next)
    {
        Data=data;
        if(next.size()>0 &&Data!=null)
        {
            Next=next;
            load(Next.get(0));
        }
    }



    private void load(String name)
    {
        MetaObjectContainer<MetaObject> container = new MetaObjectContainer<>(name);
        DB.fillContainer(container);
        Next.remove(0);
        container.split(F.FIELD_PARENT_ID,Data.getValue(F.FIELD_PARENT_ID));
        if(container.Objects.size()>0)
        {
            for(Map.Entry<Integer,MetaObject> m : container.Objects.entrySet())
            {
                m.getValue().RealDB=m.getKey();

                Items.add(new Storage(m.getValue(),Next));
            }
        }
    }
}

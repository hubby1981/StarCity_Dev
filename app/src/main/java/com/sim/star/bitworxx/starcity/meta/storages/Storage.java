package com.sim.star.bitworxx.starcity.meta.storages;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.storages.factory.FAC;

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

    public void getByNameAndParentId(String parentId,String name,ArrayList<MetaObject> result)
    {
      if(Data.Name.equals(name))
      {
          if(Data.getValue(F.FIELD_PARENT_ID).equals(parentId))
            result.add(Data);
      }
      else if(Data.getId().equals(parentId))
      {
          for( Storage s : Items)
          {
              s.getByNameAndParentId(Data.getId(),name,result);
          }
      }
    }

    public void getByNameAndId(String id,String name,ArrayList<MetaObject> result)
    {
        if(Data.Name.equals(name))
        {
            if(Data.getId().equals(id))
                result.add(Data);
        }
        else
        {
            for( Storage s : Items)
            {
                s.getByNameAndId(id,name,result);
            }
        }
    }


    private void load(String name)
    {
        MetaObjectContainer<MetaObject> container = new MetaObjectContainer<>(name);
        DB.fillContainer(container);
        Next.remove(0);
        String parentId =Data.getId();
        container=container.split(F.FIELD_PARENT_ID,parentId);
        if(container.Objects.size()>0)
        {
            for(Map.Entry<Integer,MetaObject> m : container.Objects.entrySet())
            {
                m.getValue().RealDB=m.getKey();

                Items.add(new Storage(m.getValue(),Next));
            }
        }
        else
        {
            ArrayList<MetaObject> created = FAC.create(parentId, name);

            for(MetaObject m :created)
            {
                if(m!=null)
                {
                    Items.add(new Storage(m,Next));
                }
            }
        }
    }
}

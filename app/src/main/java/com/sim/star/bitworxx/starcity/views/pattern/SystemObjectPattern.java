package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemObjectMetaObject;
import com.sim.star.bitworxx.starcity.meta.object.handler.GalaxySystemHandler;
import com.sim.star.bitworxx.starcity.meta.object.handler.GalaxySystemObjectHandler;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;
import com.sim.star.bitworxx.starcity.views.pages.SystemObjectContent;

import java.util.Map;

/**
 * Created by WEIS on 27.04.2015.
 */
public class SystemObjectPattern extends PatternBase {
    public SystemObjectPattern(String systemName)
    {
        super();

        try{createSystem(systemName);}catch(Exception e){}
    }

    private void createSystem(String systemName)
    {
        GalaxySystemHandler system =  STAR.getSystem(systemName);
        if(system!=null)
        {
            for(Map.Entry<String,GalaxySystemObjectHandler> systems:system.SystemObjects.entrySet())
            {
                GalaxySystemObjectHandler handler = systems.getValue();
                if(handler!=null)
                {
                    for(Map.Entry<Integer,GalaxySystemObjectMetaObject> objects:handler.Container.Objects.entrySet())
                    {
                        MetaObject object= objects.getValue();
                        if(object!=null) {
                            Contents.add(new ContentDescription(new CoPo((int) object.getInternalValue("left"), (int) object.getInternalValue("top"), (int) object.getInternalValue("right"), (int) object.getInternalValue("bottom")),
                                    object.getValue("id"), ContentType.SYSTEM_OBJECT));
                            STAR.addKey(object.getValue("id"),object.getInternalValue("size"),(int)object.getInternalValue("shader"),object.getValue("type"));
                        }
                    }
                }
            }
        }
    }

}

package com.sim.star.bitworxx.starcity.views.pattern;

import android.os.DropBoxManager;

import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemObjectMetaObject;
import com.sim.star.bitworxx.starcity.meta.object.handler.GalaxySystemHandler;
import com.sim.star.bitworxx.starcity.meta.object.handler.GalaxySystemObjectHandler;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

import java.util.Map;

/**
 * Created by WEIS on 22.04.2015.
 */
public class SystemViewPattern extends PatternBase {
    public SystemViewPattern(String pageCount) {

        String name = GM.SYSTEM_NAME;

        Contents.add(new ContentDescription(new CoPo(0, 0), "header-system", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(5, 0), name, ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(28, 0), "page", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(30, 0), "3", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(31, 0), pageCount, ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(0, 2, 23, 14), "", ContentType.TABLE));

        Contents.add(new ContentDescription(new CoPo(25, 2, 31, 14), "", ContentType.TABLE));


        Contents.add(new ContentDescription(new CoPo(0, 5, 23, 5), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 7, 23, 7), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 9, 23, 9), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 11, 23, 11), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(0, 13, 23, 13), "", ContentType.LINE));

        Contents.add(new ContentDescription(new CoPo(2, 3, 2, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(4, 3, 4, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(6, 3, 6, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(8, 3, 8, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(10, 3, 10, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(12, 3, 12, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(14, 3, 14, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(16, 3, 16, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(18, 3, 18, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(20, 3, 20, 14), "", ContentType.LINE));
        Contents.add(new ContentDescription(new CoPo(22, 3, 22, 14), "", ContentType.LINE));

        Contents.add(new ContentDescription(new CoPo(1, 2), "Solar System Objects", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(26, 2), "ACTIONS", ContentType.TEXT));

        StackingPattern st = new StackingPattern(4,0,2,2,new CoPo(26,4,30,15));
        Patterns.add(st);
        st.register(new ContentDescription("OPEN",ContentType.BUTTON));
        st.register(new ContentDescription("btn-system-generate",ContentType.BUTTON));
        st.register(new ContentDescription("FLEET",ContentType.BUTTON));
        st.register(new ContentDescription("DEFENCE",ContentType.BUTTON));
        st.register(new ContentDescription("MINING",ContentType.BUTTON));


        Contents.add(new ContentDescription(new CoPo(1, 15), "HOT", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(7, 15), "NORMAL", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(17, 15), "COLD", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(1, 4), "A", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(3, 4), "B", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(5, 4), "C", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(7, 4), "D", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(9, 4), "E", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 4), "F", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(13, 4), "G", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(15, 4), "H", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(17, 4), "I", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19, 4), "J", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(21, 4), "K", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 4), "1", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(1, 3), "+", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(3, 3), "2", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(5, 3), "4", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(7, 3), "6", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(9, 3), "8", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(11, 3), "10", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(13, 3), "12", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(15, 3), "14", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(17, 3), "16", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(19, 3), "18", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(21, 3), "20", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 3), "LM", ContentType.TEXT));

        Contents.add(new ContentDescription(new CoPo(23, 5), "2", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 6), "3", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 7), "4", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 8), "5", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 9), "6", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 10), "7", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 11), "8", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 12), "9", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 13), "10", ContentType.TEXT));
        Contents.add(new ContentDescription(new CoPo(23, 14), "11", ContentType.TEXT));


        GalaxySystemHandler system =  STAR.getSystem(name);
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

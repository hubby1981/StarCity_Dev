package com.sim.star.bitworxx.starcity.meta.object.handler;

import android.graphics.Point;

import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemObjectMetaObject;

import java.util.HashMap;

/**
 * Created by WEIS on 23.04.2015.
 */

public class GalaxySystemObjectHandler extends BaseHandler<GalaxySystemObjectMetaObject> {

    private static int MIN_SUN = 1;
    private static  int MAX_SUN = 1;
    private static  float MAX_SUN_SIZE = (float)9.9;
    private static  float MIN_SUN_SIZE=(float)5.1;
    private static CoPo LAST_SUN = new CoPo(1,8,2,10);
    private static CoPo LAST_PLANET = new CoPo(4,5,5,6);
    private static  float MAX_PLANET_SIZE = (float)4.9;
    private static  float MIN_PLANET_SIZE=(float)1.1;

    private static int MIN_PLANET = 1;
    private static  int MAX_PLANET = 14;
    public int LastSunSize=0;

    public GalaxySystemObjectHandler(String parent) {
        super("galaxy-system-object",parent);
    }

    @Override
    protected void create() {

       createSun();
        int old=0;
       old=createPlanetRow(6,5,old);
       old=createPlanetRow(8,5,old);
       old=createPlanetRow(10,5,old);
       old=createPlanetRow(12,5,old);
       old=createPlanetRow(14,5,old);
       old=createPlanetRow(16,5,old);
       old=createPlanetRow(18,5,old);
       old=createPlanetRow(20,5,old);
    }


    private void createSun()
    {
        int suns = RandomRange.getRandom(MIN_SUN,MAX_SUN);
        float mss=MAX_SUN_SIZE;
        float mnn  =MIN_SUN_SIZE;
        int lastL = LAST_SUN.L;
        for(int i =0;i<suns;i++)
        {
            float size = getSize((float)5.1,(float)9.9);

            int shader =RandomRange.getRandom(1,2);

            GalaxySystemObjectMetaObject sun = new GalaxySystemObjectMetaObject();
            sun.create();
            sun.Fields.register("parent-id",new MetaField(ParentId));
            sun.Fields.register("type",new MetaField("sun"));
            sun.Fields.register("size",new MetaField("",size));
            sun.Fields.register("shader",new MetaField("",shader));
            sun.Fields.register("left",new MetaField("",lastL));
            sun.Fields.register("top",new MetaField("",LAST_SUN.T));
            sun.Fields.register("right",new MetaField("",lastL+1));
            sun.Fields.register("bottom",new MetaField("",LAST_SUN.T+1));
            sun.setFieldValue("name","sun"+i);

            add(sun);
            LastSunSize=(int)size;

        }

    }

    private int createPlanetRow(int l,int t,int old)
    {
        int done = RandomRange.getRandom(0,1);

        if(done==1)
        {
            int planets = RandomRange.getRandom(0,1);
            int shader = l<10?RandomRange.getRandom(1, 2):RandomRange.getRandom(2, 4);
            for(int i =0;i<planets;i++) {
                float size = l<10?getSize((float)0.5,(float)2.0):getSize((float)1.5,(float)3.0);
                GalaxySystemObjectMetaObject planet = new GalaxySystemObjectMetaObject();
                planet.create();
                planet.Fields.register("parent-id",new MetaField(ParentId));
                planet.Fields.register("type",new MetaField("planet"));
                planet.Fields.register("size",new MetaField("",size));
                planet.Fields.register("shader",new MetaField("",shader));
                planet.Fields.register("left",new MetaField("",l));
                planet.Fields.register("top",new MetaField("",t));
                planet.Fields.register("right",new MetaField("",l+1));
                planet.Fields.register("bottom",new MetaField("",t+1));
                planet.setFieldValue("name", "planet" + i);

                add(planet);

                t+=2;
            }
            return planets;
        }
        return 0;
    }




    private float getSize(float min, float max)
    {
        return RandomRange.getFloat(min,max);
    }
}
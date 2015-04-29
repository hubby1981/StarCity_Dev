package com.sim.star.bitworxx.starcity.meta.object.handler;

import android.graphics.Point;

import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemObjectMetaObject;
import com.sim.star.bitworxx.starcity.stellar.planet.GasPlanet;

import java.util.HashMap;

/**
 * Created by WEIS on 23.04.2015.
 */

public class GalaxySystemObjectHandler extends BaseHandler<MetaObject,MetaObjectContainer<MetaObject>> {

    private static int MIN_SUN = 1;
    private static  int MAX_SUN = 1;
    private static  float MAX_SUN_SIZE = (float)9.9;
    private static  float MIN_SUN_SIZE=(float)5.1;
    private static CoPo LAST_SUN = new CoPo(1,8,2,1);
    private static CoPo LAST_PLANET = new CoPo(4,5,5,6);
    private static  float MAX_PLANET_SIZE = (float)4.9;
    private static  float MIN_PLANET_SIZE=(float)1.1;

    private static int MIN_PLANET = 1;
    private static  int MAX_PLANET = 14;
    public int LastSunSize=0;

    public HashMap<Point,Integer> Planets;

    int P=0;

    public GalaxySystemObjectHandler(String parent) {
        super("galaxy-system-object",parent);
    }

    @Override
    protected String className() {
        return "com.sim.star.bitworxx.starcity.meta.MetaObjectContainer";
    }

    @Override
    protected void create() {

       createSun();

        Planets=new HashMap<>();

        int old=0;

       old=createPlanetRow(6,9,old);
       old=createPlanetRow(8,9,old);
        old=createPlanetRow(10,9,old);

        old=createPlanetRow(12,9,old);
       old=createPlanetRow(14,9,old);
       old=createPlanetRow(16,9,old);
       old=createPlanetRow(18,9,old);
       old=createPlanetRow(20,9,old);

        if(P<5) {
            if (RandomRange.getRandom(10, 20) > 15) {
                old = createPlanetRow(7, 7, old);
                old = createPlanetRow(9, 7, old);
                old = createPlanetRow(11, 7, old);
            }
            if (RandomRange.getRandom(10, 20) > 15) {
                old = createPlanetRow(13, 7, old);
            }
            old = createPlanetRow(15, 7, old);
            old = createPlanetRow(17, 7, old);

        }


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
            sun.Fields.register("parent-id", new MetaField(ParentId));
            sun.Fields.register("type", new MetaField("sun"));
            sun.Fields.register("size",new MetaField("",size));
            sun.Fields.register("shader",new MetaField("",shader));
            sun.Fields.register("left",new MetaField("",lastL));
            sun.Fields.register("top",new MetaField("",LAST_SUN.T));
            sun.Fields.register("right",new MetaField("",lastL+1));
            sun.Fields.register("bottom",new MetaField("",LAST_SUN.T+1));
            sun.setFieldValue("name", "sun" + i);

            add(sun);
            LastSunSize=(int)size;

        }

    }

    private int createPlanetRow(int l,int t,int old)
    {
        int done = RandomRange.getRandom(0,1);
        if(P<2 && l>10)
            done=1;
        if(done==1)
        {
            int planets = RandomRange.getRandom(0,1);

            for(int i =0;i<planets;i++) {

                GasPlanet planet = new GasPlanet();

                planet.Data.Fields.register("parent-id",new MetaField(ParentId));

                planet.Data.Fields.register("left",new MetaField("",l));
                planet.Data.Fields.register("top",new MetaField("",t));
                planet.Data.Fields.register("right",new MetaField("",l+1));
                planet.Data.Fields.register("bottom",new MetaField("",t+1));
                planet.Data.setFieldValue("name", "planet" + i);
                Point p = new Point(l,t);
                    if(!Planets.containsKey(p)) {
                        add(planet.Data);
                        Planets.put(p,1);
                        P++;

                    }

                t+=2;
            }
            return planets;
        }
        return 0;
    }
    /*
    private int createPlanetRow2(int l,int t,int old)
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
                Point p = new Point(l,t);

                if(!Planets.containsKey(p)) {
                    P++;

                    add(planet);
                    Planets.put(p,1);
                }

                t+=2;
            }
            return planets;


    }*/



    private float getSize(float min, float max)
    {
        return RandomRange.getFloat(min,max);
    }
}
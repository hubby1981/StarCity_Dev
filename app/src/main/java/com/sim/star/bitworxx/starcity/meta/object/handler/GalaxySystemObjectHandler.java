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
    private static CoPo LAST_SUN = new CoPo(1,5,2,6);
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
        createPlanet();
    }


    private void createSun()
    {
        int suns = RandomRange.getRandom(MIN_SUN,MAX_SUN);
        float mss=MAX_SUN_SIZE;
        float mnn  =MIN_SUN_SIZE;
        int lastL = LAST_SUN.L;
        for(int i =0;i<suns;i++)
        {
            float size = getSize(mnn, mss);
            int sizeI = (int)size/3;
            sizeI = sizeI>0?1:sizeI;
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
            sun.Fields.register("bottom",new MetaField("",LAST_SUN.T+2));
            sun.setFieldValue("name","sun"+i);

            if(size>7)
                mss-=3;
            if(size<7)
                mnn+=2;
            add(sun);
            LastSunSize=(int)size;

        }

    }

    private void createPlanet()
    {
        int planets = RandomRange.getRandom(MIN_PLANET,MAX_PLANET);

        HashMap<Point,Integer> map=new HashMap<>();
        int minL = 5;
        int maxL = 22;
        int minT=LAST_PLANET.T;
        int maxT=13;
        for(int i=minL;i<maxL;i++)
        {
            for(int ii=minT;ii<maxT;ii++)
            {
                map.put(new Point(i,ii),0);


            }


        }

        for(int i =0;i<planets;i++)
        {
            float size = getSize((float)0.5,(float) 4.1);

            int ll = RandomRange.getRandom(minL,maxL-1);
            int tt = LAST_PLANET.T;
            Point pp = new Point(ll,tt);
            while(map.get(pp)==1)
            {
                ll = RandomRange.getRandom(minL,maxL);
                tt = RandomRange.getRandom(minT,maxT);
                pp = new Point(ll,tt);
            }

            map.remove(pp);
            map.put(pp,1);
            Point pp1 =new Point(ll-1,tt);
            Point pp2 =new Point(ll-2,tt);
            Point pp3 =new Point(ll+1,tt);
            Point pp4 =new Point(ll+2,tt);
            Point pp5 =new Point(ll-1,tt+1);
            Point pp6 =new Point(ll-2,tt+2);
            Point pp7 =new Point(ll+1,tt+1);
            Point pp8 =new Point(ll+2,tt+2);
            map.remove(pp1);
            map.remove(pp2);
            map.remove(pp3);
            map.remove(pp4);
            map.remove(pp5);
            map.remove(pp6);
            map.remove(pp7);
            map.remove(pp8);
            map.put(pp1,1);
            map.put(pp2,1);
            map.put(pp3,1);
            map.put(pp4,1);
            map.put(pp5,1);
            map.put(pp6,1);
            map.put(pp7,1);
            map.put(pp8,1);




            int shader =RandomRange.getRandom(1,4);

            GalaxySystemObjectMetaObject planet = new GalaxySystemObjectMetaObject();
            planet.create();
            planet.Fields.register("parent-id",new MetaField(ParentId));
            planet.Fields.register("type",new MetaField("planet"));
            planet.Fields.register("size",new MetaField("",size));
            planet.Fields.register("shader",new MetaField("",shader));
            planet.Fields.register("left",new MetaField("",ll));
            planet.Fields.register("top",new MetaField("",tt));
            planet.Fields.register("right",new MetaField("",ll+1));
            planet.Fields.register("bottom",new MetaField("",tt+2));
            planet.setFieldValue("name", "planet" + i);

            add(planet);


        }
    }


    private float getSize(float min, float max)
    {
        return RandomRange.getFloat(min,max);
    }
}
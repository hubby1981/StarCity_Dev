package com.sim.star.bitworxx.starcity.constants;

import android.graphics.BitmapShader;
import android.graphics.Shader;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.meta.object.handler.GalaxySystemHandler;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;

import com.sim.star.bitworxx.starcity.views.pages.SystemObjectDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.HashMap;

/**
 * Created by WEIS on 22.04.2015.
 */

public class STAR {
    public static HashMap<String,SystemObjectDescription> ALL_STARS;
    public static HashMap<String,Boolean> ALL_CHECKED;

    public static HashMap<String,GalaxySystemHandler> ALL_SYSTEMS;

    static{
        ALL_STARS =new HashMap<String,SystemObjectDescription>(){

        };
        ALL_SYSTEMS=new HashMap<>();
        ALL_CHECKED = new HashMap<>();



        ALL_STARS.put("en-sun1",new SystemObjectDescription(getActionForKey("sun1"),(float)5.1,MenuConst.BACK_SHADER_SUN01));
        ALL_STARS.put("en-sun2",new SystemObjectDescription(getActionForKey("sun2"),(float)7.4,MenuConst.BACK_SHADER_SUN02));
        ALL_STARS.put("en-planet1",new SystemObjectDescription(getActionForKey("planet1"),(float)1.9,MenuConst.BACK_SHADER_PLANET01));
        ALL_STARS.put("en-planet2",new SystemObjectDescription(getActionForKey("planet2"),(float)4.5,MenuConst.BACK_SHADER_PLANET02));
        ALL_STARS.put("en-planet3",new SystemObjectDescription(getActionForKey("planet3"),(float)1.4,MenuConst.BACK_SHADER_PLANET03));
        ALL_STARS.put("en-planet4",new SystemObjectDescription(getActionForKey("planet4"),(float)3.6,MenuConst.BACK_SHADER_PLANET04));
        ALL_STARS.put("en-planet5",new SystemObjectDescription(getActionForKey("planet5"),(float)2.4,MenuConst.BACK_SHADER_PLANET03));

        ALL_STARS.put("en-moon1",new SystemObjectDescription(getActionForKey("moon1"),(float)0.4,MenuConst.BACK_SHADER_MOON01));
        ALL_STARS.put("en-moon2",new SystemObjectDescription(getActionForKey("moon2"),(float)0.8,MenuConst.BACK_SHADER_MOON01));

    }

    public static GalaxySystemHandler getSystem(String parent)
    {
        if(!ALL_SYSTEMS.containsKey(parent))

        {
            ALL_SYSTEMS.put(parent,new GalaxySystemHandler(parent));

        }
        return ALL_SYSTEMS.get(parent);
    }

    public static BitmapShader getShaderSun(int shader)
    {
        return shader==1?MenuConst.BACK_SHADER_SUN01:MenuConst.BACK_SHADER_SUN02;
    }

    public static BitmapShader getShaderPlanet(int shader)
    {

        return shader==1?MenuConst.BACK_SHADER_PLANET01:
                shader==2?MenuConst.BACK_SHADER_PLANET02:
                        shader==3?MenuConst.BACK_SHADER_PLANET03:MenuConst.BACK_SHADER_PLANET04;
    }
    public static BitmapShader getShaderMoon(int shader)
    {
        return MenuConst.BACK_SHADER_MOON01;
    }

    public static void addKey(String key,float size,int shader,String type)
    {
        BitmapShader back = type.equals("sun")?getShaderSun(shader):type.equals("moon")?getShaderMoon(shader):getShaderPlanet(shader);
        if(!ALL_STARS.containsKey(key))
            ALL_STARS.put("en-"+key,new SystemObjectDescription(getActionForKey(key),size,back));

    }

    public static Runnable getActionForKey(String key)
    {
        if(!ALL_CHECKED.containsKey(key))
            ALL_CHECKED.remove(key);
        final String k2=key;
        return new Runnable() {
            @Override
            public void run() {
                Boolean val = true;

                ALL_CHECKED.clear();
                ALL_CHECKED.put(k2,val);
                RunnablesMainMenu.R_S_FLUSH_CONTENT.run();
            }
        };
    }


    public static SystemObjectDescription getInternal(String key)
    {
        String k1 = GM.LOCALE_A +key;
        String k2 = GM.LOCALE + key;

        return ALL_STARS.containsKey(k1)? ALL_STARS.get(k1): ALL_STARS.containsKey(k2)? ALL_STARS.get(k2):new SystemObjectDescription(new TextDescription(key, TextSize.TEXT),getActionForKey(key));
    }

    public static SystemObjectDescription get(String key)
    {
        SystemObjectDescription cd = getInternal(key);

        if(cd.SearchText)
            cd.Text = TXT.get(key);
        return cd;
    }
}
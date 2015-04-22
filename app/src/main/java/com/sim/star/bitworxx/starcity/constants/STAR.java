package com.sim.star.bitworxx.starcity.constants;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
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

    static{
        ALL_STARS =new HashMap<String,SystemObjectDescription>(){

        };
        ALL_CHECKED = new HashMap<>();
        ALL_STARS.put("en-sun1",new SystemObjectDescription(getActionForKey("sun1"),(float)4.6,MenuConst.BACK_SHADER_SUN01));
        ALL_STARS.put("en-planet1",new SystemObjectDescription(getActionForKey("planet1"),3,MenuConst.BACK_SHADER_PLANET01));
        ALL_STARS.put("en-planet2",new SystemObjectDescription(getActionForKey("planet2"),(float)8.1,MenuConst.BACK_SHADER_PLANET02));
        ALL_STARS.put("en-moon1",new SystemObjectDescription(getActionForKey("moon1"),1,MenuConst.BACK_SHADER_MOON01));
        ALL_STARS.put("en-moon2",new SystemObjectDescription(getActionForKey("moon2"),2,MenuConst.BACK_SHADER_MOON01));

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
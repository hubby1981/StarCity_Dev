package com.sim.star.bitworxx.starcity.constants;

import android.widget.Toast;

import com.sim.star.bitworxx.starcity.app.StarCityApp;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.views.pages.ButtonContent;
import com.sim.star.bitworxx.starcity.views.pages.ButtonDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.HashMap;

/**
 * Created by WEIS on 17.04.2015.
 */
public class BTN {
    public static HashMap<String,ButtonDescription> ALL_BUTTON;

    static{
        ALL_BUTTON=new HashMap<String,ButtonDescription>(){

        };

        ALL_BUTTON.put("en-btn-system-add", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
               android.widget.Toast.makeText(StarCityApp.getAppContext(), "Add clicked", Toast.LENGTH_SHORT).show();
            }
        }));
        ALL_BUTTON.put("de-btn-system-add", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                android.widget.Toast.makeText(StarCityApp.getAppContext(), "Add geklickt", Toast.LENGTH_SHORT).show();
            }
        }));

    }


    public static ButtonDescription getInternal(String key)
    {
        String k1 = GM.LOCALE_A +key;
        String k2 = GM.LOCALE + key;

        return ALL_BUTTON.containsKey(k1)?ALL_BUTTON.get(k1):ALL_BUTTON.containsKey(k2)?ALL_BUTTON.get(k2):new ButtonDescription(new TextDescription(key,TextSize.TEXT),null);
    }

    public static ButtonDescription get(String key)
    {
        ButtonDescription bd = getInternal(key);
        if(bd.SearchText)
            bd.Text = TXT.get(key);
        return bd;
    }
}

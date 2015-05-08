package com.sim.star.bitworxx.starcity.constants;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.pages.CheckboxDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.HashMap;

/**
 * Created by WEIS on 21.04.2015.
 */
public class CHK {
    public static HashMap<String,CheckboxDescription> ALL_CHECKBOX;
    public static HashMap<String,Boolean> ALL_CHECKED;

    static{
        ALL_CHECKBOX=new HashMap<String,CheckboxDescription>(){

        };
        ALL_CHECKED = new HashMap<>();

    }

    public static Runnable getActionForKey(String key,Boolean init)
    {
        if(!ALL_CHECKED.containsKey(key))
            ALL_CHECKED.put(key,init);
        final String k2=key;
        return new Runnable() {
            @Override
            public void run() {
                Boolean val = ALL_CHECKED.get(k2);
                val=!val;
                ALL_CHECKED.remove(k2);
                ALL_CHECKED.put(k2,val);
                RunnablesMainMenu.R_S_FLUSH_CONTENT.run();
            }
        };
    }


    public static CheckboxDescription getInternal(String key)
    {
        String k1 = GM.LOCALE_A +"-"+key;
        String k2 = GM.LOCALE +"-"+ key;

        return ALL_CHECKBOX.containsKey(k1)?ALL_CHECKBOX.get(k1):ALL_CHECKBOX.containsKey(k2)?ALL_CHECKBOX.get(k2):new CheckboxDescription(new TextDescription(key, TextSize.TEXT),getActionForKey(key,false));
    }

    public static CheckboxDescription get(String key)
    {
        CheckboxDescription cd = getInternal(key);
        if(cd.SearchText)
            cd.Text = TXT.get(key);
        return cd;
    }
}
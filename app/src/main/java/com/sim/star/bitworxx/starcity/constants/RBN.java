package com.sim.star.bitworxx.starcity.constants;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.pages.CheckboxDescription;
import com.sim.star.bitworxx.starcity.views.pages.RadioboxDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 21.04.2015.
 */
public class RBN {
    public static HashMap<String,RadioboxDescription> ALL_CHECKBOX;
    public static HashMap<String,Boolean> ALL_CHECKED;
    public static HashMap<String,ArrayList<String>> ALL_GROUPS;

    static{
        ALL_CHECKBOX=new HashMap<String,RadioboxDescription>(){

        };
        ALL_CHECKED = new HashMap<>();

        ALL_GROUPS=new HashMap<>();
        ALL_CHECKBOX.put("en-rbn-use-action-1",new RadioboxDescription(getActionForKey("rbn-use-action-1",true,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-2",new RadioboxDescription(getActionForKey("rbn-use-action-2",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-3",new RadioboxDescription(getActionForKey("rbn-use-action-3",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-4",new RadioboxDescription(getActionForKey("rbn-use-action-4",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-5",new RadioboxDescription(getActionForKey("rbn-use-action-5",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-6",new RadioboxDescription(getActionForKey("rbn-use-action-6",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-7",new RadioboxDescription(getActionForKey("rbn-use-action-7",false,"g1")));
        ALL_CHECKBOX.put("en-rbn-use-action-8",new RadioboxDescription(getActionForKey("rbn-use-action-8",false,"g1")));

    }

    public static Runnable getActionForKey(String key,Boolean init,String group)
    {
        if(!ALL_CHECKED.containsKey(key))
            ALL_CHECKED.put(key,init);
        if(!ALL_GROUPS.containsKey(group))
            ALL_GROUPS.put(group,new ArrayList<String>());
        if(!ALL_GROUPS.get(group).contains(key))
            ALL_GROUPS.get(group).add(key);
        final String k2=key;
        final String k3=group;
        return new Runnable() {
            @Override
            public void run() {
                setFalse(k3);
                Boolean val = ALL_CHECKED.get(k2);
                val=!val;
                ALL_CHECKED.remove(k2);
                ALL_CHECKED.put(k2,val);
                RunnablesMainMenu.R_S_FLUSH_CONTENT.run();
            }
        };
    }

    public static void setFalse(String group)
    {
        if(ALL_GROUPS.containsKey(group))
        {
            for(String k : ALL_GROUPS.get(group))
                if(ALL_CHECKED.containsKey(k))
                {

                    ALL_CHECKED.remove(k);
                    ALL_CHECKED.put(k,false);
                }
        }
    }


    public static RadioboxDescription getInternal(String key)
    {
        String k1 = GM.LOCALE_A +"-"+key;
        String k2 = GM.LOCALE +"-"+ key;

        return ALL_CHECKBOX.containsKey(k1)?
                ALL_CHECKBOX.get(k1):
                ALL_CHECKBOX.containsKey(k2)?
                        ALL_CHECKBOX.get(k2):
                        new RadioboxDescription(new TextDescription(key, TextSize.TEXT),getActionForKey(key,false,""));
    }

    public static RadioboxDescription get(String key)
    {
        RadioboxDescription cd = getInternal(key);
        if(cd.SearchText)
            cd.Text = TXT.get(key);
        return cd;
    }
}
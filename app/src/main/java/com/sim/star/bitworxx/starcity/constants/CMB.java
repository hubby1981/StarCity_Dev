package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.pages.ComboDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 20.05.2015.
 */
public class CMB {
    public static HashMap<String,ComboDescription> ALL_COMBO;
    public static HashMap<String,Boolean> ALL_OPENED;
    public static HashMap<String,Runnable> ALL_COMBO_CLICKS;

public static Runnable CloseAll=new Runnable() {
    @Override
    public void run() {
        ALL_OPENED.remove("cmb-colors");
        if(MenuBitmaps.ActualWindow!=null)
        {
            MenuBitmaps.ActualWindow.setupPages();
            }
        ActionContainer.clearHidden();
    }
};
    static{
        ALL_COMBO =new HashMap<String,ComboDescription>(){

        };
        ALL_COMBO_CLICKS = new HashMap<>();
        ALL_OPENED = new HashMap<>();

        ALL_COMBO.put("cmb-colors",new ComboDescription(getActionForKey("cmb-colors",false)));


        ALL_COMBO_CLICKS.put("cmb-colors-1", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToYellow();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-2", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToGreen();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-3", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToBlue();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-4", new Runnable() {
            @Override
            public void run() {
                ALL_OPENED.remove("cmb-colors");
                if(MenuBitmaps.ActualWindow!=null)
                    MenuBitmaps.ActualWindow.setupPages();
                ColorSetter.changeToRed();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-5", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToOrange();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-6", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToViolet();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-7", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToAqua();
            }
        });

        ALL_COMBO_CLICKS.put("cmb-colors-8", new Runnable() {
            @Override
            public void run() {
                CloseAll.run();
                ColorSetter.changeToPurple();
            }
        });
    }

    public static Runnable getActionForKey(String key,Boolean init)
    {
        if(!ALL_OPENED.containsKey(key))
            ALL_OPENED.put(key,init);
        final String k2=key;
        return new Runnable() {
            @Override
            public void run() {
                if(ALL_OPENED.containsKey(k2)){
                Boolean val = ALL_OPENED.get(k2);
                val=!val;

                ALL_OPENED.remove(k2);
                ALL_OPENED.put(k2, val);}
                else
                {
                    ALL_OPENED.put(k2,true);
                }
                if(MenuBitmaps.ActualWindow!=null)
                    MenuBitmaps.ActualWindow.setupPages();
                RunnablesMainMenu.R_S_FLUSH_CONTENT.run();
            }
        };
    }

    public static boolean getCombo(String key)
    {
        return ALL_OPENED.containsKey(key)?ALL_OPENED.get(key):false;
    }

    public static void setSize(String key,int size)
    {
        if(ALL_COMBO.containsKey(key))
            ALL_COMBO.get(key).Size=size;
    }

    public static int getSize(String key)
    {
        return ALL_COMBO.containsKey(key)?ALL_COMBO.get(key).Size:1;
    }


    public static ComboDescription getInternal(String key)
    {
        String k1 = key;
        String k2 = key;

        return ALL_COMBO.containsKey(k1)? ALL_COMBO.get(k1): ALL_COMBO.containsKey(k2)? ALL_COMBO.get(k2):new ComboDescription(new TextDescription(key, TextSize.TEXT),getActionForKey(key,false));
    }

    public static ComboDescription get(String key)
    {
        ComboDescription cd = getInternal(key);
        if(cd.SearchText)
            cd.Text = TXT.get(key);
        return cd;
    }

    public static Runnable getAction(String key)
    {
        return ALL_COMBO_CLICKS.containsKey(key)?ALL_COMBO_CLICKS.get(key):null;
    }
}

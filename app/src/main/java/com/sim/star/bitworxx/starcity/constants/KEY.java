package com.sim.star.bitworxx.starcity.constants;

import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.pages.ButtonDescription;
import com.sim.star.bitworxx.starcity.views.pages.ComboDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextBoxDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.HashMap;

/**
 * Created by WEIS on 21.05.2015.
 */
public class KEY {
    public static HashMap<String,Boolean> ALL_KEY;
    public static HashMap<String,TextBoxDescription> ALL_KEYS;
    public static  String Active="NONE";
    static{
        ALL_KEY=new HashMap<>();
        ALL_KEYS=new HashMap<>();

        ALL_KEYS.put("index-name",new TextBoxDescription(getActionForKey("index-name",false)));
    }


    public static boolean getKey(String key)
    {
        return ALL_KEY.containsKey(key)?ALL_KEY.get(key):false;
    }

    public static void setKey(String key,boolean value)
    {
        if(ALL_KEY.containsKey(key))
            ALL_KEY.remove(key);
        ALL_KEY.put(key,value);

    }

    public static void setSize(String key,int size)
    {
        if(ALL_KEYS.containsKey(key))
            ALL_KEYS.get(key).Size=size;
    }

    public static int getSize(String key)
    {
        return ALL_KEYS.containsKey(key)?ALL_KEYS.get(key).Size:1;
    }

    public static void setText(String key,String text)
    {
        if(ALL_KEYS.containsKey(key))
            ALL_KEYS.get(key).Text=text;
    }

    public static String getText(String key)
    {
        return ALL_KEYS.containsKey(key)?ALL_KEYS.get(key).Text:"";
    }

    public static Runnable getActionForKey(final String key,Boolean init)
    {
        if(!ALL_KEY.containsKey(key))
            ALL_KEY.put(key,init);
        final String k2=key;
        return new Runnable() {
            @Override
            public void run() {
                if(ALL_KEY.containsKey(k2)){
                    Boolean val = ALL_KEY.get(k2);
                    val=!val;

                    ALL_KEY.remove(k2);
                    ALL_KEY.put(k2, val);}
                else
                {
                    ALL_KEY.put(k2,true);
                }

                Active=key;
                if(ALL_KEY.containsKey(Active)) {
                    if (ALL_KEY.get(Active) == true)
                    {RunnablesMainMenu.R_S_MAIN_MENU_FALSE.run();}
                    else
                    { RunnablesMainMenu.R_S_MAIN_MENU_TRUE.run();KEY.Active="NONE";}
                }
                if(MenuBitmaps.ActualWindow!=null)
                    MenuBitmaps.ActualWindow.setupPages();
                RunnablesMainMenu.R_S_FLUSH_CONTENT.run();
            }
        };
    }

    public static void addText(String text)
    {
        if(ALL_KEYS.containsKey(Active))
        {
            if(text.equals("delete"))
            {
                if(ALL_KEYS.get(Active).Text.length()>0)
                    ALL_KEYS.get(Active).Text=ALL_KEYS.get(Active).Text.substring(0,ALL_KEYS.get(Active).Text.length()-1);

            }
            else if(text.equals("enter"))
            {
                if(ALL_KEY.containsKey(Active))
                    ALL_KEY.remove(Active);
                Active="NONE";
                RunnablesMainMenu.R_S_MAIN_MENU_TRUE.run();

            }
            else{
            ALL_KEYS.get(Active).Text+=text;}
            if(MenuBitmaps.ActualWindow!=null)
                MenuBitmaps.ActualWindow.setupPages();
            RunnablesMainMenu.R_S_FLUSH_CONTENT.run();

        }

    }

    public static TextBoxDescription getInternal(String key)
    {
        String k1 = key;
        String k2 = key;

        return ALL_KEYS.containsKey(k1)? ALL_KEYS.get(k1): ALL_KEYS.containsKey(k2)? ALL_KEYS.get(k2):new TextBoxDescription(new TextDescription(getText(key), TextSize.TEXT),getActionForKey(key,false));
    }

    public static TextBoxDescription get(String key)
    {
        TextBoxDescription cd = getInternal(key);

        return cd;
    }



}

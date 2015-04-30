package com.sim.star.bitworxx.starcity.constants;

import android.widget.Toast;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.app.StarCityApp;
import com.sim.star.bitworxx.starcity.banking.BankingHelper;
import com.sim.star.bitworxx.starcity.banking.CreditTransaction;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.player.PlayerStore;
import com.sim.star.bitworxx.starcity.views.pages.ButtonContent;
import com.sim.star.bitworxx.starcity.views.pages.ButtonDescription;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

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

        ALL_BUTTON.put("en-btn-system-buy", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                CreditTransaction transaction = new CreditTransaction(1245148, PlayerStore.getPlayerBank().receiveMoney());
                transaction.transact();
                MenuBitmaps.BitmapDrawables.clear();
                MainScreen.Init.run();
            }
        }));

        ALL_BUTTON.put("en-btn-system-generate", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
              DB.Connection.execSQL("delete from meta_object");
              if(STAR.ALL_SYSTEMS.containsKey(GM.SYSTEM_NAME))STAR.ALL_SYSTEMS.remove(GM.SYSTEM_NAME);
              STAR.getSystem(GM.SYSTEM_NAME);
              STAR.ALL_STARS.clear();
              ActionContainer.flushPage();
              MenuBitmaps.ActualWindow.flush();
                MenuBitmaps.ActualWindow.setupPages();
              MainScreen.Init.run();
            }
        }));

        ALL_BUTTON.put("en-45.10.99.200", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                GM.SYSTEM_NAME = "Pytico";
                STAR.getSystem(GM.SYSTEM_NAME);
                STAR.ALL_STARS.clear();
                ActionContainer.flushPage();
                MenuBitmaps.ActualWindow.flush();
                MenuBitmaps.ActualWindow.setupPages();
                MenuBitmaps.ActualWindow.setPage(2);
                MainScreen.Init.run();
            }
        }));

        ALL_BUTTON.put("en-45.10.0.200", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                GM.SYSTEM_NAME = "Pytico II";
                STAR.getSystem(GM.SYSTEM_NAME);
                STAR.ALL_STARS.clear();
                ActionContainer.flushPage();
                MenuBitmaps.ActualWindow.flush();
                MenuBitmaps.ActualWindow.setupPages();
                MenuBitmaps.ActualWindow.setPage(2);
                MainScreen.Init.run();
            }
        }));

        ALL_BUTTON.put("en-45.123.99.200", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                GM.SYSTEM_NAME = "Sambut";
                STAR.getSystem(GM.SYSTEM_NAME);
                STAR.ALL_STARS.clear();
                ActionContainer.flushPage();
                MenuBitmaps.ActualWindow.flush();
                MenuBitmaps.ActualWindow.setupPages();
                MenuBitmaps.ActualWindow.setPage(2);
                MainScreen.Init.run();
            }
        }));

        ALL_BUTTON.put("en-45.1.99.200", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                GM.SYSTEM_NAME = "Taba";
                STAR.getSystem(GM.SYSTEM_NAME);
                STAR.ALL_STARS.clear();
                ActionContainer.flushPage();
                MenuBitmaps.ActualWindow.flush();
                MenuBitmaps.ActualWindow.setupPages();
                MenuBitmaps.ActualWindow.setPage(2);
                MainScreen.Init.run();
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

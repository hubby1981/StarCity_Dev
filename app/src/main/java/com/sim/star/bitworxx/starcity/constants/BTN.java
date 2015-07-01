package com.sim.star.bitworxx.starcity.constants;

import android.widget.Toast;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.app.StarCityApp;
import com.sim.star.bitworxx.starcity.banking.BankingHelper;
import com.sim.star.bitworxx.starcity.banking.CreditTransaction;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.display.Show;
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

        ALL_BUTTON.put("en-btn-main-play", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                MenuBitmaps.ActualWindow=null;
                Show.ShowOverlay=false;
                MenuBitmaps.BitmapDrawables.clear();
                MainScreen.Init.run();
                android.widget.Toast.makeText(StarCityApp.getAppContext(), "Add clicked", Toast.LENGTH_SHORT).show();

            }
        }));


        ALL_BUTTON.put("en-btn-main-new", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                MenuBitmaps.ActualWindow=null;
                Show.ShowOverlay=false;
                MenuBitmaps.BitmapDrawables.clear();
                MainScreen.Init.run();

            }
        }));

        ALL_BUTTON.put("en-btn-main-options", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                MenuBitmaps.ActualWindow=null;
                Show.ShowOverlay=false;
                MenuBitmaps.BitmapDrawables.clear();
                MainScreen.Init.run();

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
                CreditTransaction transaction = new CreditTransaction((float)121245148.56, PlayerStore.getPlayerBank().receiveMoney());
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


        ALL_BUTTON.put("en-key-0", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
               KEY.addText("0");
            }
        }));
        ALL_BUTTON.put("en-key-1", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("1");
            }
        }));
        ALL_BUTTON.put("en-key-2", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("2");
            }
        }));
        ALL_BUTTON.put("en-key-3", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("3");
            }
        }));
        ALL_BUTTON.put("en-key-4", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("4");
            }
        }));
        ALL_BUTTON.put("en-key-5", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("5");
            }
        }));
        ALL_BUTTON.put("en-key-6", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("6");
            }
        }));
        ALL_BUTTON.put("en-key-7", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("7");
            }
        }));
        ALL_BUTTON.put("en-key-8", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("8");
            }
        }));
        ALL_BUTTON.put("en-key-9", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("9");
            }
        }));


        ALL_BUTTON.put("en-key-Q", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("Q");
            }
        }));
        ALL_BUTTON.put("en-key-W", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("W");
            }
        }));
        ALL_BUTTON.put("en-key-E", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("E");
            }
        }));
        ALL_BUTTON.put("en-key-R", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("R");
            }
        }));
        ALL_BUTTON.put("en-key-T", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("T");
            }
        }));
        ALL_BUTTON.put("en-key-Z", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("Z");
            }
        }));
        ALL_BUTTON.put("en-key-U", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("U");
            }
        }));
        ALL_BUTTON.put("en-key-I", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("I");
            }
        }));
        ALL_BUTTON.put("en-key-O", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("O");
            }
        }));
        ALL_BUTTON.put("en-key-P", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("P");
            }
        }));

        ALL_BUTTON.put("en-key-A", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("A");
            }
        }));
        ALL_BUTTON.put("en-key-S", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("S");
            }
        }));
        ALL_BUTTON.put("en-key-D", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("D");
            }
        }));
        ALL_BUTTON.put("en-key-F", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("F");
            }
        }));
        ALL_BUTTON.put("en-key-G", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("G");
            }
        }));
        ALL_BUTTON.put("en-key-H", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("H");
            }
        }));
        ALL_BUTTON.put("en-key-J", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("J");
            }
        }));
        ALL_BUTTON.put("en-key-K", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("K");
            }
        }));
        ALL_BUTTON.put("en-key-L", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("L");
            }
        }));
        ALL_BUTTON.put("en-key-empty", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText(" ");
            }
        }));

        ALL_BUTTON.put("en-key-_", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("_");
            }
        }));
        ALL_BUTTON.put("en-key-Y", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("Y");
            }
        }));
        ALL_BUTTON.put("en-key-X", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("X");
            }
        }));
        ALL_BUTTON.put("en-key-C", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("C");
            }
        }));
        ALL_BUTTON.put("en-key-V", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("V");
            }
        }));
        ALL_BUTTON.put("en-key-B", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("B");
            }
        }));
        ALL_BUTTON.put("en-key-N", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("N");
            }
        }));
        ALL_BUTTON.put("en-key-M", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("M");
            }
        }));
        ALL_BUTTON.put("en-key-<", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("delete");
            }
        }));
        ALL_BUTTON.put("en-key->", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("enter");
            }
        }));
        ALL_BUTTON.put("en-key-@", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("@");
            }
        }));
        ALL_BUTTON.put("en-key-.", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText(".");
            }
        }));
        ALL_BUTTON.put("en-key--", new ButtonDescription(new Runnable() {
            @Override
            public void run() {
                KEY.addText("-");
            }
        }));
    }


    public static ButtonDescription getInternal(String key)
    {
        String k1 = GM.LOCALE_A +"-"+key;
        String k2 = GM.LOCALE +"-"+ key;

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

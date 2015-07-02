package com.sim.star.bitworxx.starcity.runnable;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.views.content.FightContent;
import com.sim.star.bitworxx.starcity.views.content.MainContent;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

/**
 * Created by WEIS on 02.07.2015.
 */
public class RunnableWindow {


public static  Rect InnerRectWindow;


    public static Runnable R_A_SHOW_FIGHT=
         new Runnable() {
            @Override
            public void run() {
                MenuBitmaps.ActualWindow=new FightContent(InnerRectWindow);
                ActionContainer.flush();
                MainScreen.Init.run();
            }
        };

    public static Runnable R_A_SHOW_MAIN=
            new Runnable() {
                @Override
                public void run() {
                    MenuBitmaps.ActualWindow=new MainContent(InnerRectWindow);
                    ActionContainer.flush();
                    MainScreen.Init.run();
                }
            };
}

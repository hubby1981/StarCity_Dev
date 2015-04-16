package com.sim.star.bitworxx.starcity.runnable;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.highlight.BlinkCode;
import com.sim.star.bitworxx.starcity.highlight.HightlightMenu;

/**
 * Created by WEIS on 14.04.2015.
 */
public class RunnablesMainMenu {


    public static Runnable S_UPDATE = new Runnable() {
        @Override
        public void run() {
            MainScreen.Init.run();
        }
    };
    public static Runnable R_S_SUB_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowSubMenu = !Show.ShowSubMenu;
            S_UPDATE.run();
        }
    };

    public static Runnable R_S_MAIN_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowMainMenu = !Show.ShowMainMenu;
            Show.ShowSubMenu = Show.ShowMainMenu;
            Show.ShowTimer = Show.ShowMainMenu;
            Show.ShowTopMenu =Show.ShowMainMenu;

            S_UPDATE.run();}
    };

    public static Runnable R_S_TIME_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowTimer = !Show.ShowTimer;
        }
    };

    public static Runnable R_A_SUB_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowSubMenuSecondLevel = !Show.ShowSubMenuSecondLevel;
            HightlightMenu.HIGH_SUB_MENU = !HightlightMenu.HIGH_SUB_MENU;
            S_UPDATE.run();
        }
    };

    public static Runnable R_A_MAIN_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowSubMenu = !Show.ShowSubMenu;
            HightlightMenu.HIGH_MAIN_MENU = !HightlightMenu.HIGH_MAIN_MENU;


            S_UPDATE.run();
        }
    };

    public static Runnable R_A_PREV_PAGE = new Runnable() {
        @Override
        public void run() {

            if(MenuBitmaps.ActualWindow!=null)
                MenuBitmaps.ActualWindow.prevPage();

            BlinkCode.LEFT_ALT=1;
            BlinkCode.BLINK_LEFT_PAGE=BlinkCode.BLINK;
        }
    };

    public static Runnable R_A_NEXT_PAGE = new Runnable() {
        @Override
        public void run() {

            if(MenuBitmaps.ActualWindow!=null)
                MenuBitmaps.ActualWindow.nextPage();
            BlinkCode.RIGHT_ALT=1;
            BlinkCode.BLINK_RIGHT_PAGE=BlinkCode.BLINK;
        }
    };
}

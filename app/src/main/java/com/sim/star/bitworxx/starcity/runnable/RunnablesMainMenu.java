package com.sim.star.bitworxx.starcity.runnable;

import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.highlight.HightlightMenu;

/**
 * Created by WEIS on 14.04.2015.
 */
public class RunnablesMainMenu {

    public static Runnable R_S_SUB_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowSubMenu = !Show.ShowSubMenu;
        }
    };

    public static Runnable R_S_MAIN_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowMainMenu = !Show.ShowMainMenu;
            Show.ShowSubMenu = Show.ShowMainMenu;
            Show.ShowTimer = Show.ShowMainMenu;
        }
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

        }
    };

    public static Runnable R_A_MAIN_MENU = new Runnable() {
        @Override
        public void run() {
            Show.ShowSubMenu = !Show.ShowSubMenu;
            HightlightMenu.HIGH_MAIN_MENU = !HightlightMenu.HIGH_MAIN_MENU;
        }
    };
}

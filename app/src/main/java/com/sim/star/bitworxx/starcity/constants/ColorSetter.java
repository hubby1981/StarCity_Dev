package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Color;

/**
 * Created by WEIS on 10.04.2015.
 */
public class ColorSetter {

    public static int FILL_BACK_COLOR = ColorMenu.FILL_YELLOW;
    public static int FILL_FORE_COLOR = ColorMenu.FILL_YELLOW_FORE;
    public static int FILL_BACK_COLOR_PLATE = ColorMenu.FILL_YELLOW_PLATE;
    public static int FILL_STROKE_FORE = ColorMenu.FILL_YELLOW_FORE;
    public static int FILL_FORE_ICON = ColorMenu.FILL_YELLOW_FORE_ICON;
    public static int FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_YELLOW_PLATE_HALF;


    public static int FILL_STROKE_BACK = Color.argb(ColorMenu.ALPHA_ONE, 0, 0, 0);
    public static int FILL_STROKE_BACK_FORE = Color.argb(ColorMenu.ALPHA_ONE,255, 255, 255);
    public static int FILL_STROKE_BACK_HALF = Color.argb(ColorMenu.ALPHA_TWO, 0, 0, 0);

    public static int FILL_STROKE_BACK_HALF2 = Color.argb(ColorMenu.ALPHA_ONE/4, 0, 0, 0);
    public static int FILL_CONTENT_BACK_HALF = Color.argb(ColorMenu.ALPHA_TWO/2, 220,220,220);
    public static int FILL_CONTENT_BACK_HALF2 = Color.argb(ColorMenu.ALPHA_TWO/3, 150,150,150);
    public static int FILL_SHADER_BACK = Color.argb(255, 0, 0, 0);
    public static int FILL_SHADER_BACK_LIGHT = Color.argb(255, 255,255, 255);
    public static int FILL_BACK_CONTENT_LIGHT = Color.argb(85, 50,50, 50);
    public static int FILL_BACK_CONTENT_LIGHT_MAX = Color.argb(200, 100,100,100);

    public static int FILL_SHADER_BACK_HALF = Color.argb(ColorMenu.ALPHA_TWO/2, 200,200,200);

    public static int YELLOW=1;
    public static int GREEN =0;
    public static int BLUE =0;
    public static int RED =0;
    public static int ORANGE =0;
    public static int VIOLET =0;
    public static int AQUA =0;
    public static int PURPLE =0;

    public static void flush()
    {
        YELLOW=0;
        GREEN=0;
        BLUE=0;
        AQUA=0;
        VIOLET=0;
        ORANGE=0;
        RED=0;
        PURPLE=0;
        //MenuBitmaps.BitmapDrawables.clear();

    }

    private static void flushColor()
    {
        MenuBitmaps.BitmapDrawables.clear();
        MenuConst.init();
    }
    public static void changeToYellow()
    {
        if(YELLOW==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_YELLOW;
            FILL_FORE_COLOR = ColorMenu.FILL_YELLOW_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_YELLOW_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_YELLOW_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_YELLOW_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_YELLOW_PLATE_HALF;
            YELLOW=1;
            flushColor();
        }
    }

    public static void changeToGreen()
    {
        if(GREEN==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_GREEN;
            FILL_FORE_COLOR = ColorMenu.FILL_GREEN_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_GREEN_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_GREEN_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_GREEN_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_GREEN_PLATE_HALF;
            GREEN=1;
            flushColor();
        }

    }

    public static void changeToBlue()
    {
        if(BLUE==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_BLUE;
            FILL_FORE_COLOR = ColorMenu.FILL_BLUE_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_BLUE_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_BLUE_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_BLUE_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_BLUE_PLATE_HALF;
            BLUE=1;
            flushColor();
        }

    }

    public static void changeToRed()
    {
        if(RED==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_RED;
            FILL_FORE_COLOR = ColorMenu.FILL_RED_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_RED_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_RED_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_RED_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_RED_PLATE_HALF;
            RED=1;
            flushColor();
        }

    }


    public static void changeToOrange()
    {
        if(ORANGE==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_ORANGE;
            FILL_FORE_COLOR = ColorMenu.FILL_ORANGE_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_ORANGE_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_ORANGE_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_ORANGE_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_ORANGE_PLATE_HALF;
            ORANGE=1;
            flushColor();
        }

    }

    public static void changeToViolet()
    {
        if(VIOLET==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_VIOLET;
            FILL_FORE_COLOR = ColorMenu.FILL_VIOLET_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_VIOLET_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_VIOLET_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_VIOLET_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_VIOLET_PLATE_HALF;
            VIOLET=1;
            flushColor();
        }

    }

    public static void changeToAqua()
    {
        if(AQUA==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_AQUA;
            FILL_FORE_COLOR = ColorMenu.FILL_AQUA_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_AQUA_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_AQUA_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_AQUA_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_AQUA_PLATE_HALF;
            AQUA=1;
            flushColor();
        }

    }

    public static void changeToPurple()
    {
        if(PURPLE==0) {
            flush();
            FILL_BACK_COLOR = ColorMenu.FILL_PURPLE;
            FILL_FORE_COLOR = ColorMenu.FILL_PURPLE_FORE;
            FILL_BACK_COLOR_PLATE = ColorMenu.FILL_PURPLE_PLATE;
            FILL_STROKE_FORE = ColorMenu.FILL_PURPLE_FORE;
            FILL_FORE_ICON = ColorMenu.FILL_PURPLE_FORE_ICON;
            FILL_BACK_COLOR_PLATE_HALF = ColorMenu.FILL_PURPLE_PLATE_HALF;
            PURPLE=1;
            flushColor();
        }

    }
}

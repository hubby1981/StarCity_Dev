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

    public static int FILL_SHADER_BACK_HALF = Color.argb(ColorMenu.ALPHA_TWO/2, 200,200,200);

    public static int YELLOW=1;
    public static int GREEN =0;

    public static void flush()
    {
        YELLOW=0;
        GREEN=0;
        //MenuBitmaps.BitmapDrawables.clear();

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
        }

    }
}

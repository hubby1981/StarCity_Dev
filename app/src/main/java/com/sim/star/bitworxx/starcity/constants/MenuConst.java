package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by WEIS on 09.04.2015.
 */
public class MenuConst {


    public static int FILL_BACK = ColorSetter.FILL_BACK_COLOR;
    public static Paint BACK_PAINTER = createBackPainter(FILL_BACK);
    public static int FILL_FORE = ColorSetter.FILL_FORE_COLOR;
    public static Paint FORE_PAINTER = createBackPainter(FILL_FORE);

    public static int FILL_BACK_PLATE = ColorSetter.FILL_BACK_COLOR_PLATE;
    public static Paint PLATE_BACK_PAINTER = createBackPainter(FILL_BACK_PLATE);


    public static Paint STROKE_BACK_PAINTER = createStrokeBackPainter(ColorSetter.FILL_STROKE_BACK);
    public static Paint STROKE_FORE_PAINTER = createStrokeBackPainter(ColorSetter.FILL_STROKE_FORE);
    public static int FILL_STROKE_BACK_PLATE = Color.argb(255, 0, 0, 0);
    public static Paint PLATE_STROKE_BACK_PAINTER = createStrokeBackPainter(FILL_STROKE_BACK_PLATE);
    public static int FILL_HALF_TRANSPARENT_BACK = Color.argb(128, 0, 0, 0);
    public static Paint HALF_TRANSPARENT_BACK_PAINTER = createBackPainter(FILL_HALF_TRANSPARENT_BACK);
    public static Paint BACK_TRANSPARENT = createTransparentBackPainter();
    public static int MARGIN_CLIP = 3;

    public static int MARGIN_CLIP_MINI = 10;

    public static int FACTOR_TRIANGLE_OUT = 2;
    public static int FACTOR_TRIANGLE_IN = 4;


    private static Paint createBackPainter(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(color);
        return p;
    }

    private static Paint createTransparentBackPainter() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        return p;
    }

    private static Paint createStrokeBackPainter(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        p.setColor(color);
        p.setStrokeWidth(2);
        return p;
    }
}

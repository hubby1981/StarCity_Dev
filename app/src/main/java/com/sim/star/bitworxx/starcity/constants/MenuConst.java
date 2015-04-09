package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by WEIS on 09.04.2015.
 */
public class MenuConst {

    public static int FILL_BACK = Color.argb(225, 213, 123, 36);
    public static int FILL_STROCKE_BACK = Color.argb(255, 0, 0, 0);


    public static Paint BACK_TRANSPARENT = createTransparentBackPainter();

    public static Paint BACK_PAINTER = createBackPainter();
    public static Paint STROKE_BACK_PAINTER = createBackPainter();

    public static int MARGIN_CLIP = 5;

    public static int FAKTOR_TRIANLGE_OUT = 2;
    public static int FAKTOR_TRIANLGE_IN = 4;


    private static Paint createBackPainter() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(FILL_BACK);
        return p;
    }

    private static Paint createTransparentBackPainter() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        return p;
    }

    private static Paint createStrokeBackPainter() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(FILL_STROCKE_BACK);
        p.setStrokeWidth(2);
        return p;
    }
}

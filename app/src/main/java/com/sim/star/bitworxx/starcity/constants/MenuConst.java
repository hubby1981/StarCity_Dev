package com.sim.star.bitworxx.starcity.constants;

import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

/**
 * Created by WEIS on 09.04.2015.
 */
public class MenuConst {


    public static Paint BACK_PAINTER;
    public static Paint BACK_PAINTER_WITH_SHADER = null;

    public static Paint FORE_PAINTER;
    public static Paint FORE_PAINTER_ICON;
    public static Paint FORE_PAINTER_STROKE_LIGHT;

    public static Paint PLATE_BACK_PAINTER;


    public static Paint STROKE_BACK_PAINTER;
    public static Paint STROKE_FORE_PAINTER;

    public static Paint PLATE_STROKE_BACK_PAINTER;
    public static Paint LINE_STROKE_BACK_PAINTER;
    public static Paint HALF_TRANSPARENT_BACK_PAINTER;
    public static Paint BACK_TRANSPARENT;

    public static int MARGIN_CLIP = 3;

    public static int MARGIN_CLIP_MINI = 10;

    public static int FACTOR_TRIANGLE_OUT = 2;
    public static int FACTOR_TRIANGLE_IN = 4;

    public static BitmapShader BACK_SHADER;
    public static BitmapShader BACK_SHADER2;


    public static Paint BACK_SHADER_PAINTER = null;

    public static BitmapShader BACK_SHADER_SUN01 = null;
    public static BitmapShader BACK_SHADER_SUN02 = null;

    public static BitmapShader BACK_SHADER_PLANET01 = null;
    public static BitmapShader BACK_SHADER_PLANET02 = null;
    public static BitmapShader BACK_SHADER_PLANET03 = null;
    public static BitmapShader BACK_SHADER_PLANET04 = null;
    public static BitmapShader BACK_SHADER_PLANET05 = null;
    public static BitmapShader BACK_SHADER_PLANET06 = null;
    public static BitmapShader BACK_SHADER_PLANET07 = null;
    public static BitmapShader BACK_SHADER_PLANET08 = null;
    public static BitmapShader BACK_SHADER_PLANET09 = null;
    public static BitmapShader BACK_SHADER_PLANET10 = null;
    public static BitmapShader BACK_SHADER_PLANET11 = null;
    public static BitmapShader BACK_SHADER_PLANET12 = null;
    public static BitmapShader BACK_SHADER_PLANET13 = null;
    public static BitmapShader BACK_SHADER_PLANET14 = null;
    public static BitmapShader BACK_SHADER_PLANET15 = null;
    public static BitmapShader BACK_SHADER_PLANET16 = null;
    public static BitmapShader BACK_SHADER_PLANET17 = null;
    public static BitmapShader BACK_SHADER_PLANET18 = null;
    public static BitmapShader BACK_SHADER_PLANET19 = null;
    public static BitmapShader BACK_SHADER_PLANET20 = null;
    public static BitmapShader BACK_SHADER_MOON01 = null;

    public static Paint BACK_PAINTER_CONTENT;
    public static Paint BACK_PAINTER_CONTENT_INNER;
    public static Paint BACK_PAINTER_CONTENT_INNER2;
    public static Paint BACK_PAINTER_BLACK;
    public static Paint BACK_PAINTER_CONTENT_LIGHT;


    static {
        init();
    }

    public static void init()
    {
        BACK_PAINTER = createBackPainter(ColorSetter.FILL_BACK_COLOR);
        BACK_PAINTER_BLACK = createBackPainter(ColorSetter.FILL_SHADER_BACK);
        FORE_PAINTER = createBackPainter(ColorSetter.FILL_FORE_COLOR);
        FORE_PAINTER_ICON = createBackPainter(ColorSetter.FILL_FORE_ICON);

        PLATE_BACK_PAINTER = createBackPainter(ColorSetter.FILL_BACK_COLOR_PLATE);

        BACK_PAINTER_CONTENT_LIGHT = createBackPainter(ColorSetter.FILL_BACK_CONTENT_LIGHT);
        STROKE_BACK_PAINTER = createStrokeBackPainter(ColorSetter.FILL_STROKE_BACK);
        STROKE_FORE_PAINTER = createStrokeBackPainter(ColorSetter.FILL_STROKE_FORE);
        FORE_PAINTER_STROKE_LIGHT = createStrokeBackPainterDash(ColorSetter.FILL_SHADER_BACK_LIGHT);
        PLATE_STROKE_BACK_PAINTER = createStrokeBackPainter(ColorSetter.FILL_STROKE_BACK);
        LINE_STROKE_BACK_PAINTER = createStrokeBackPainterDash1(ColorSetter.FILL_STROKE_BACK);

        HALF_TRANSPARENT_BACK_PAINTER = createBackPainter(ColorSetter.FILL_STROKE_BACK_HALF);
        BACK_TRANSPARENT = createTransparentBackPainter();

        BACK_PAINTER_CONTENT = createBackPainter(ColorSetter.FILL_STROKE_BACK_HALF);
        BACK_PAINTER_CONTENT_INNER = createBackPainter(ColorSetter.FILL_CONTENT_BACK_HALF);
        BACK_PAINTER_CONTENT_INNER = createBackPainter(ColorSetter.FILL_CONTENT_BACK_HALF2);
        BACK_PAINTER_CONTENT_INNER2 = createBackPainter(ColorSetter.FILL_STROKE_BACK_HALF2);
    }


    private static Paint createBackPainter(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(color);
        p.setAntiAlias(true);
        return p;
    }

    private static Paint createTransparentBackPainter() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.TRANSPARENT);
        p.setAntiAlias(true);
        return p;
    }

    private static Paint createStrokeBackPainter(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        p.setColor(color);
        p.setStrokeWidth(1);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        return p;
    }


    private static Paint createStrokeBackPainterDash(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        p.setColor(color);
        p.setStrokeWidth(1);
        p.setPathEffect(new DashPathEffect(new float[]{8, 4}, 0));
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        return p;
    }
    private static Paint createStrokeBackPainterDash1(int color) {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        p.setColor(color);
        p.setStrokeWidth(1);
        //p.setPathEffect(new DashPathEffect(new float[]{2, 4}, 0));
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);
        return p;
    }
}

package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.preference.PreferenceActivity;

import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;

/**
 * Created by WEIS on 15.04.2015.
 */
public abstract class ContentWindow extends ContentBase {

    protected  int LeftPos=0;
    protected  int TopPos=0;

    protected Paint HeaderFontPaint;
    protected Paint SubHeaderFontPaint;
    protected Paint FontPaint;
    public ContentWindow(Rect displayIn) {
        super(displayIn);
    }

    @Override
    public Bitmap draw() {
        Bitmap result = generateBitmap();

        if(IsNew) {

            Canvas canvas = new Canvas(result);
            int w = DisplayRect.width() / (MenuConst.MARGIN_CLIP_MINI * MenuConst.FACTOR_TRIANGLE_OUT * 2);
            int ww= w/MenuConst.FACTOR_TRIANGLE_OUT;
            int www= ww/MenuConst.FACTOR_TRIANGLE_OUT;
            Path outLine = GeometricHelp.generateTrianglePath(getOutboundRect(), ww, ww);
            Path inLine = GeometricHelp.generateTrianglePath(getInboundRect(ww), www,www);
            LeftPos=InboundRect.left+w;
            TopPos=InboundRect.top+w;

            HeaderFontPaint = new Paint();
            HeaderFontPaint.setStyle(Paint.Style.FILL);
            HeaderFontPaint.setStrokeWidth(1);
            HeaderFontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
            HeaderFontPaint.setTextSize((float) ContentFont.FontHeightHeader);

            SubHeaderFontPaint = new Paint();
            SubHeaderFontPaint.setStyle(Paint.Style.FILL);
            SubHeaderFontPaint.setStrokeWidth(1);
            SubHeaderFontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
            SubHeaderFontPaint.setTextSize((float) ContentFont.FontHeightSubHeader);

            FontPaint = new Paint();
            FontPaint.setStyle(Paint.Style.FILL);
            FontPaint.setStrokeWidth(1);
            FontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
            FontPaint.setTextSize((float) ContentFont.FontHeight);

            canvas.drawPath(outLine, MenuConst.BACK_PAINTER_CONTENT);
            canvas.drawPath(outLine, MenuConst.PLATE_STROKE_BACK_PAINTER);
            canvas.drawPath(inLine, MenuConst.BACK_PAINTER_CONTENT_INNER);
            canvas.drawPath(inLine, MenuConst.PLATE_STROKE_BACK_PAINTER);

            drawContents(canvas);

        }

        return result;
    }

    protected abstract void drawContents(Canvas canvas);

}

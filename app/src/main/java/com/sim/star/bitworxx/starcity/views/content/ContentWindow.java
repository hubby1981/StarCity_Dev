package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.preference.PreferenceActivity;

import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.MainBorder;
import com.sim.star.bitworxx.starcity.views.pages.Content;
import com.sim.star.bitworxx.starcity.views.pages.PageBase;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.ArrayList;

/**
 * Created by WEIS on 15.04.2015.
 */
public abstract class ContentWindow extends ContentBase {

    protected  int LeftPos=0;
    protected  int TopPos=0;

    public Paint HeaderFontPaint;
    public Paint SubHeaderFontPaint;
    public Paint FontPaint;
    public boolean PaintOnlyContent=false;

    protected ArrayList<PageBase> Pages;
    protected int ActualPage =0;
    public ContentWindow(Rect displayIn) {
        super(displayIn);
        Pages=new ArrayList<PageBase>();
        setupPages();
    }

    public Paint getFontPainter(TextSize size)
    {
        return size==TextSize.HEADER ? HeaderFontPaint : size==TextSize.SUB_HEADER ? SubHeaderFontPaint : FontPaint;
    }

    public int getPagesCount()
    {
        return Pages.size();
    }



    public void prevPage()
    {
        ActionContainer.flushPage();
        if(ActualPage==0)
            ActualPage=Pages.size()-1;
        else
            ActualPage--;

        flush();
    }

    public String getPageId()
    {
        return Pages.get(ActualPage).UId;
    }

    public void nextPage()
    {
        ActionContainer.flushPage();

        if (ActualPage==Pages.size()-1)
            ActualPage=0;
        else
            ActualPage++;
        flush();
    }

    public void setPage(int page)
    {
        ActionContainer.flushPage();
        if(Pages.size()>page)
            ActualPage=page;
        flush();
    }

    public abstract void setupPages();

    @Override
    public Bitmap draw() {
        Bitmap result = generateBitmap();

        if(IsNew) {
            Canvas canvas = new Canvas(result);


                int w = DisplayRect.width() / (MenuConst.MARGIN_CLIP_MINI * MenuConst.FACTOR_TRIANGLE_OUT * 2);
                int ww = w / MenuConst.FACTOR_TRIANGLE_OUT;
                int www = ww / MenuConst.FACTOR_TRIANGLE_OUT;
                Path outLine = GeometricHelp.generateTrianglePath(getOutboundRect(), ww, ww);
                Path inLine = GeometricHelp.generateTrianglePath(getInboundRect(ww), www, www);
                LeftPos = InboundRect.left + w;
                TopPos = InboundRect.top + w;

                HeaderFontPaint = new Paint();
                HeaderFontPaint.setStyle(Paint.Style.FILL);
                HeaderFontPaint.setTypeface(MainBorder.VenusFace);
                HeaderFontPaint.setFakeBoldText(true);
                HeaderFontPaint.setStrokeWidth(1);
                HeaderFontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
                HeaderFontPaint.setTextSize((float) ContentFont.FontHeightHeader);
                HeaderFontPaint.setAntiAlias(true);
                SubHeaderFontPaint = new Paint();
                SubHeaderFontPaint.setStyle(Paint.Style.FILL);
                SubHeaderFontPaint.setStrokeWidth(1);
                SubHeaderFontPaint.setTypeface(MainBorder.VenusFace);
                SubHeaderFontPaint.setFakeBoldText(true);
                SubHeaderFontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
                SubHeaderFontPaint.setTextSize((float) ContentFont.FontHeightSubHeader);
                SubHeaderFontPaint.setAntiAlias(true);

                FontPaint = new Paint();
                FontPaint.setStyle(Paint.Style.FILL);

                FontPaint.setTypeface(MainBorder.VenusFace);
                FontPaint.setAntiAlias(true);

                FontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
                FontPaint.setTextSize((float) ContentFont.FontHeight);

                if(!PaintOnlyContent) {
                    if (MenuConst.BACK_SHADER_PAINTER != null) {

                        canvas.drawRect(InboundRect, MenuConst.BACK_SHADER_PAINTER);
                    }
                    canvas.drawPath(outLine, MenuConst.BACK_PAINTER_CONTENT);
                    canvas.drawPath(outLine, MenuConst.PLATE_STROKE_BACK_PAINTER);
                    canvas.drawPath(inLine, MenuConst.BACK_PAINTER_CONTENT_INNER);
                    canvas.drawPath(inLine, MenuConst.PLATE_STROKE_BACK_PAINTER);
                }

                CliprRects.InnerRectContent = InboundRect;
                CliprRects.OuterRectContent = OutboundRect;



            if(Show.ShowGrid)
                drawGrid(canvas);
            drawContents(canvas);

        }

        return result;
    }

    protected void drawContents(Canvas canvas)
    {
           PageBase page = Pages.get(ActualPage);
            if(page!=null)
            {
                ActionContainer.flush();
                for(Content c : page.drawContents())
                {
                    c.onDraw(canvas,this,null);
                }
            }
    }

}

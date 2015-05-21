package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 16.04.2015.
 */
public class TextContent extends Content {

    private String Text;
    private TextSize Size;
    public TextContent(CoPo p,String text,TextSize size) {
        super(p);
        Text = text;
        Size=size;
    }


    protected void doContentSupply(Rect r)
    {

    }

    @Override
    protected void onDrawInternal(Canvas canvas, Rect rect, ContentWindow window) {
        Paint painter = window.getFontPainter(Size);
        if(Parent!=null)
        {
            if(Parent.UseParentBounds) {

                int w=(int)painter.measureText(Text);
                rect = new Rect(Parent.Bounds.centerX() - w / 2, Parent.Bounds.centerY(), Parent.Bounds.centerX() + w / 2, Parent.Bounds.centerY() + (int)painter.getTextSize());
                canvas.drawText(Text, rect.left, rect.centerY(), painter);
            }
            else
                canvas.drawText(Text, rect.left,rect.centerY()+painter.getTextSize()/4, painter);

        }
        else {
            canvas.drawText(Text, rect.left, rect.centerY()+painter.getTextSize()/4, painter);
        }
        doContentSupply(rect);
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {
        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));
            onDrawInternal(canvas,r,window);
        }else
        {
            onDrawInternal(canvas,rects.get(0),window);}
    }
}

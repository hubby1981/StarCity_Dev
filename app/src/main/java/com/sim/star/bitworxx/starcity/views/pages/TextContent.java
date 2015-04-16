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


    private int measureY(Rect bound)
    {
        return bound.bottom-bound.height()/4;

    }

    @Override
    protected void onDrawInternal(Canvas canvas, Rect rect, ContentWindow window) {
        canvas.drawText(Text,rect.left,measureY(rect),window.getFontPainter(Size));
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {

        onDrawInternal(canvas,rects.get(0),window);
    }
}

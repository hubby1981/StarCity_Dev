package com.sim.star.bitworxx.starcity.views.content;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.ContentPosition;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.GridHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by WEIS on 15.04.2015.
 */
public abstract class ContentBase {

    public Rect DisplayRect;
    public UUID Id;
    public Rect OutboundRect=null;
    public Rect InboundRect=null;
    public Rect InboundRectMargin=null;
    public boolean IsNew=true;
    private  HashMap<Point,Rect> Grid;

    public ContentBase(Rect displayIn)
    {
        Id= UUID.randomUUID();
        DisplayRect=displayIn;
    }

    public abstract Bitmap draw();

    protected Bitmap generateBitmap()
    {
        if(MenuBitmaps.BitmapDrawables.containsKey(Id))
        {
            IsNew=false;
            return MenuBitmaps.BitmapDrawables.get(Id);
        }else{IsNew=true;}
        MenuBitmaps.BitmapDrawables.put(Id, Bitmap.createBitmap(DisplayRect.width(), DisplayRect.height(), Bitmap.Config.ARGB_4444));
        return MenuBitmaps.BitmapDrawables.get(Id);
    }

    protected int measureWidth()
    {
        return DisplayRect.width()-(MenuConst.MARGIN_CLIP_MINI*MenuConst.FACTOR_TRIANGLE_OUT);
    }

    protected int measureHeight()
    {
        return DisplayRect.height()-(MenuConst.MARGIN_CLIP_MINI*MenuConst.FACTOR_TRIANGLE_OUT);
    }

    protected Rect getOutboundRect()
    {
        if(OutboundRect==null)
        {
            OutboundRect=new Rect(MenuConst.MARGIN_CLIP_MINI,MenuConst.MARGIN_CLIP_MINI,measureWidth(),measureHeight());

        }

        return OutboundRect;
    }

    protected Rect getInboundRect(int measure)
    {
        if(InboundRect==null)
        {

            InboundRect=new Rect(getOutboundRect().left+measure,getOutboundRect().top+measure,getOutboundRect().right-measure,getOutboundRect().bottom-measure);
            createGrid();
        }

        return InboundRect;
    }

    protected Rect getInboundRectMargin(int measure)
    {
        if(InboundRectMargin==null)
        {
            InboundRectMargin=new Rect(InboundRect.left+measure,InboundRect.top+measure,InboundRect.right-measure,InboundRect.bottom-measure);

        }

        return InboundRectMargin;
    }

    public void drawOnCanvas(Canvas canvas)
    {
        canvas.drawBitmap(MenuBitmaps.ActualWindow.draw(),(float)DisplayRect.left,(float)DisplayRect.top,null);
    }

    private void createGrid()
    {
        Grid=GridHelper.measureElements(getInboundRectMargin(MenuConst.MARGIN_CLIP_MINI), ContentPosition.MAX_GRID_X,ContentPosition.MAX_GRID_Y);;
    }

    protected void drawGrid(Canvas canvas)
    {


        for(int xi=0;xi<ContentPosition.MAX_GRID_Y;xi++)
        {
            for(int yi=0;yi<ContentPosition.MAX_GRID_X;yi++)
            {
                canvas.drawRect(Grid.get(new Point(xi,yi)),MenuConst.STROKE_FORE_PAINTER);
            }
        }
    }


    public Point getLayoutPosition(int x,int y)
    {
       Rect rc = getLayoutRect(x,y);
       return new Point(rc.left,rc.top);
    }
    public ArrayList<Point> getLayoutPosition(int x,int y,int xx,int yy)
    {
        Rect rc = getLayoutRect(x,y);
        Rect rc2 = getLayoutRect(xx,yy);
        ArrayList<Point> result = new ArrayList<Point>();

        result.add( new Point(rc.left,rc.top));
        result.add( new Point(rc2.right,rc2.bottom));
        return result;
    }
    private Rect getLayoutRect(int x,int y)
    {
        Point p = new Point(y,x);
        if(Grid.containsKey(p))
            return Grid.get(p);
        else
            return InboundRectMargin;
    }
}

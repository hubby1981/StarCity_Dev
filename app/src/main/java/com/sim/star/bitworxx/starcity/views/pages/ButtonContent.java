package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;

import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public class ButtonContent extends RectContent {

    protected Runnable Action;
    public ButtonContent(CoPo p,Runnable action) {
        super(p);
        Action=action;

    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {
        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));

            setClick(r);

             drawFilling(canvas,r);
        }
    }


    protected void setClick(Rect r)
    {
        if(Action!=null)
        {
            int w =CliprRects.InnerRectMain.left- CliprRects.OuterRectContent.left;
            int h=CliprRects.InnerRectMain.top- CliprRects.OuterRectContent.top;
            Rect r2 = new Rect(r.left+ w,r.top+h,r.right+ w,r.bottom+h);
            setHandler(r2, Action);
        }
    }

    protected void setHandler(Rect rect,Runnable action)
    {
        ActionContainer.addButton(rect, Action);
    }

    protected void drawFilling(Canvas canvas,Rect r)
    {
        int w=6;
        float fak = (float)1.8;
        Path p = GeometricHelp.generateTrianglePath(r, w, w);

        Paint pp = new Paint();

        pp.setColor(Color.BLACK);
        pp.setShader(new RadialGradient((float)r.centerX(),(float)r.centerY(),(float)((float)(r.width())/fak), ColorSetter.FILL_BACK_COLOR_PLATE,Color.BLACK, Shader.TileMode.MIRROR));
        pp.setAntiAlias(true);


        canvas.drawPath(p, pp);

        p = GeometricHelp.generateTrianglePath(r, w, w);
        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER);
        Rect r2 = makeInnerRectWithTitle(r,w/2,w/2);
        p = GeometricHelp.generateTrianglePath(r2, w, w);

        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER2);
        canvas.drawPath(p, MenuConst.BACK_PAINTER_CONTENT_INNER2);



        canvas.drawPath(p, MenuConst.PLATE_STROKE_BACK_PAINTER);
    }
}

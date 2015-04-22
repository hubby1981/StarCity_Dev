package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;

import java.util.ArrayList;

/**
 * Created by WEIS on 22.04.2015.
 */
public class SystemObjectContent extends ButtonContent {

    public String CheckedKey;
    public float Size=1;
    public BitmapShader Shader;

    public SystemObjectContent(CoPo p,String checkedKey,Runnable action) {
        super(p,action);
        CheckedKey=checkedKey;
    }

    @Override
    protected void onDrawInternal(Canvas canvas, ArrayList<Rect> rects, ContentWindow window) {
        if(rects.size()>=2) {
            Rect r = combineRects(rects.get(0), rects.get(1));
            int w=r.width()/10;

            w=(int)(w*Size);
            setClick(r);

            RectF rf = new RectF((float)r.centerX()-w,(float)r.centerY()-w,(float)r.centerX()+w,(float)r.centerY()+w);

            if(STAR.ALL_CHECKED.containsKey(CheckedKey))
            {
                Rect r2=new Rect(r.centerX()-(int)(w+Size*1),r.centerY()-(int)(w+Size*1),r.centerX()+(int)(w+Size*1),r.centerY()+(int)(w+Size*1));


                canvas.drawRect(r2,MenuConst.FORE_PAINTER_STROKE_LIGHT);




            }

            if(Shader!=null){
                Paint p1 = new Paint();
                p1.setAntiAlias(true);
                p1.setShader(Shader);
                p1.setShadowLayer(2,2,2, Color.BLACK);
                canvas.drawArc(rf,(float)0,(float)360,true,p1);
                p1=null;}
            canvas.drawArc(rf,(float)0,(float)360,true,MenuConst.BACK_PAINTER_CONTENT_INNER);



        }
    }
}

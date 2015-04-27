package com.sim.star.bitworxx.starcity.views.pages;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.ContentPosition;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.constants.STAR;
import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
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

                if(Size<2) {
                    canvas.drawRect(r, MenuConst.FORE_PAINTER_STROKE_LIGHT);

                }
                                else
                {
                    canvas.drawRect(r2, MenuConst.FORE_PAINTER_STROKE_LIGHT);

                }


            }

            if(Size<2)
            {
                //canvas.drawRect(r, MenuConst.BACK_PAINTER_CONTENT_LIGHT);
            }

            if(Shader!=null){
                Paint p1 = new Paint();
                p1.setAntiAlias(true);
                p1.setShader(Shader);

                int shadow=1;
                p1.setShadowLayer(shadow,shadow,shadow, Color.BLACK);
                canvas.drawArc(rf,(float)0,(float)360,true,p1);
                p1.setShadowLayer(shadow,-shadow,-shadow, Color.BLACK);

                canvas.drawArc(rf,(float)0,(float)360,true,p1);
                p1.setShadowLayer(shadow,shadow,-shadow, Color.BLACK);

                canvas.drawArc(rf,(float)0,(float)360,true,p1);
                p1.setShadowLayer(shadow,-shadow,shadow, Color.BLACK);

                canvas.drawArc(rf,(float)0,(float)360,true,p1);


                p1 = new Paint();
                p1.setAntiAlias(true);
                p1.setStyle(Paint.Style.FILL);
                if(Size>5) {

                    p1.setShader(new RadialGradient( rf.centerX(),rf.centerY(), rf.width()/2, Color.TRANSPARENT,Color.argb(80,255,255,255), android.graphics.Shader.TileMode.MIRROR));
                    canvas.drawArc(rf, (float) 0, (float) 360, true, p1);


                    RectF rf2 = new RectF(rf.left,rf.top-rf.height(),rf.left+(rf.width()*Size)/4,rf.bottom+rf.height());
                    p1.setShader(new RadialGradient( rf.left,rf.centerY(), rf2.width()/2,Color.argb(80,255,255,170), Color.TRANSPARENT, android.graphics.Shader.TileMode.MIRROR));
                    canvas.drawArc(rf2, (float)0    , (float) 360, true, p1);

                }
                else
                {


                    p1.setColor(Color.argb(50, 0, 0, 0));
                    canvas.drawArc(rf, (float) -90, (float) 180, true, p1);

                }

                p1=null;}
            canvas.drawArc(rf,(float)0,(float)360,true,MenuConst.BACK_PAINTER_CONTENT_INNER);





        }
    }
}

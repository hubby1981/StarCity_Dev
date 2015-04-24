package com.sim.star.bitworxx.starcity.views.icons;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by WEIS on 24.04.2015.
 */
public class TechIcon extends BaseIcon {
    @Override
    public Path getPath(Rect displayIn) {
        generatePoints(displayIn);
        Path result = new Path();

        int mh = Middle.y;
        int mw = Middle.x;
        int w = Size.Width;
        int h = SizeV.Height;



        RectF rMiddle = makeRectF(mw-w/3,mh-h/3,mw+w/3,mh+h/3);

        int maxW = 10;
        int maxH = 10;

        if(displayIn.width()<50) {

            maxH/=3;
        }

        if(displayIn.height()<50) {

            maxH/=3;
        }

        int w2=((int)rMiddle.width()-maxW)/4;
        int h2=((int)rMiddle.height()-maxH)/4;
        int w3=(w/4);
        int h3=h/4;

        if(w2==0)
            w2=1;
        if(h2==0)
            h2=1;
        if(w3==0)
            w3=2;
        if(h3==0)
            h3=2;

        int margin = 2;
        if(w2==1)
            margin = 1;

        RectF rTop1 = makeRectF((int)rMiddle.left+margin,(int)(rMiddle.top-margin)-h3,(int)(rMiddle.left+margin)+w2,(int)rMiddle.top-margin);
        RectF rTop2 = makeRectF((int)rTop1.right+margin,(int)(rMiddle.top-margin)-h3,(int)(rTop1.right+margin)+w2,(int)rMiddle.top-margin);
        RectF rTop3 = makeRectF((int)rTop2.right+margin,(int)(rMiddle.top-margin)-h3,(int)(rTop2.right+margin)+w2,(int)rMiddle.top-margin);
        RectF rTop4 = makeRectF((int)rTop3.right+margin,(int)(rMiddle.top-margin)-h3,(int)(rTop3.right+margin)+w2,(int)rMiddle.top-margin);


        RectF rBottom1 = makeRectF((int)rMiddle.left+margin,(int)(rMiddle.bottom+margin)+h3,(int)(rMiddle.left+margin)+w2,(int)rMiddle.bottom+margin);
        RectF rBottom2 = makeRectF((int)rTop1.right+margin,(int)(rMiddle.bottom +margin)+h3,(int)(rTop1.right +margin)+w2,(int)rMiddle.bottom+margin);
        RectF rBottom3 = makeRectF((int)rTop2.right+margin,(int)(rMiddle.bottom +margin)+h3,(int)(rTop2.right +margin)+w2,(int)rMiddle.bottom+margin);
        RectF rBottom4 = makeRectF((int)rTop3.right+margin,(int)(rMiddle.bottom +margin)+h3,(int)(rTop3.right +margin)+w2,(int)rMiddle.bottom+margin);

        RectF rRight1 = makeRectF((int)rMiddle.right+margin,(int)(rMiddle.top   +margin),(int)(rMiddle.right+margin)+w3,((int)rMiddle.top   +margin)+h2);
        RectF rRight2 = makeRectF((int)rMiddle.right+margin,(int)(rRight1.bottom+margin),(int)(rMiddle.right+margin)+w3,((int)rRight1.bottom+margin)+h2);
        RectF rRight3 = makeRectF((int)rMiddle.right+margin,(int)(rRight2.bottom+margin),(int)(rMiddle.right+margin)+w3,((int)rRight2.bottom+margin)+h2);
        RectF rRight4 = makeRectF((int)rMiddle.right+margin,(int)(rRight3.bottom+margin),(int)(rMiddle.right+margin)+w3,((int)rRight3.bottom+margin)+h2);

        RectF rLeft1 = makeRectF((int)rMiddle.left-margin,(int)(rMiddle.top  +margin),(int)(rMiddle.left-margin)-w3,((int)rMiddle.top  +margin)+h2);
        RectF rLeft2 = makeRectF((int)rMiddle.left-margin,(int)(rLeft1.bottom+margin),(int)(rMiddle.left-margin)-w3,((int)rLeft1.bottom+margin)+h2);
        RectF rLeft3 = makeRectF((int)rMiddle.left-margin,(int)(rLeft2.bottom+margin),(int)(rMiddle.left-margin)-w3,((int)rLeft2.bottom+margin)+h2);
        RectF rLeft4 = makeRectF((int)rMiddle.left-margin,(int)(rLeft3.bottom+margin),(int)(rMiddle.left-margin)-w3,((int)rLeft3.bottom+margin)+h2);

        result.addRect(rMiddle, Path.Direction.CW);

        result.addRect(rTop1, Path.Direction.CW);
        result.addRect(rTop2, Path.Direction.CW);
        result.addRect(rTop3, Path.Direction.CW);
        result.addRect(rTop4, Path.Direction.CW);

        result.addRect(rBottom1, Path.Direction.CW);
        result.addRect(rBottom2, Path.Direction.CW);
        result.addRect(rBottom3, Path.Direction.CW);
        result.addRect(rBottom4, Path.Direction.CW);

        result.addRect(rRight1, Path.Direction.CW);
        result.addRect(rRight2, Path.Direction.CW);
        result.addRect(rRight3, Path.Direction.CW);
        result.addRect(rRight4, Path.Direction.CW);

        result.addRect(rLeft1, Path.Direction.CW);
        result.addRect(rLeft2, Path.Direction.CW);
        result.addRect(rLeft3, Path.Direction.CW);
        result.addRect(rLeft4, Path.Direction.CW);
        return result;
    }
}

package com.sim.star.bitworxx.starcity.geometric;

import android.graphics.Path;
import android.graphics.Rect;

/**
 * Created by WEIS on 15.04.2015.
 */
public class GeometricHelp {

    public static  Path generateTrianglePath(Rect rc, int w, int h) {
        Path outerPath = new Path();

        outerPath.moveTo(rc.left, rc.top + h);
        outerPath.lineTo(rc.left + w, rc.top);
        outerPath.lineTo(rc.right - w, rc.top);
        outerPath.lineTo(rc.right, rc.top + h);
        outerPath.lineTo(rc.right, rc.bottom - h);
        outerPath.lineTo(rc.right - w, rc.bottom);
        outerPath.lineTo(rc.left + w, rc.bottom);
        outerPath.lineTo(rc.left, rc.bottom - h);
        outerPath.lineTo(rc.left, rc.top + h);

        return outerPath;
    }


    public static  Path generateTrianglePath(Rect rc, int w1, int h1,int w2,int h2,int w3,int h3,int w4,int h4) {
        Path outerPath = new Path();

        outerPath.moveTo(rc.left, rc.top + h1);
        outerPath.lineTo(rc.left + w1, rc.top);
        outerPath.lineTo(rc.right - w2, rc.top);
        outerPath.lineTo(rc.right, rc.top + h2);
        outerPath.lineTo(rc.right, rc.bottom - h3);
        outerPath.lineTo(rc.right - w3, rc.bottom);
        outerPath.lineTo(rc.left + w4, rc.bottom);
        outerPath.lineTo(rc.left, rc.bottom - h4);
        outerPath.lineTo(rc.left, rc.top + h1);

        return outerPath;
    }

    public static Path upTriangle(Rect rc)
    {
        Path result = new Path();

        result.moveTo(rc.left, rc.bottom);
        result.lineTo(rc.left+rc.width()/2,rc.top);
        result.lineTo(rc.right,rc.bottom);
        result.lineTo(rc.left,rc.bottom);

        return result;
    }

    public static Path downTriangle(Rect rc)
    {
        Path result = new Path();

        result.moveTo(rc.left,rc.top);
        result.lineTo(rc.left+rc.width()/2, rc.bottom);
        result.lineTo(rc.right, rc.top);
        result.lineTo(rc.left,rc.top);

        return result;
    }

    public static Path prevTriangle(Rect rc)
    {
        Path result = new Path();

        result.moveTo(rc.right,rc.top);
        result.lineTo(rc.left,rc.top+rc.height()/2);
        result.lineTo(rc.right,rc.bottom);
        result.lineTo(rc.right,rc.top);

        return result;
    }

    public static Path nextTriangle(Rect rc)
    {
        Path result = new Path();

        result.moveTo(rc.left,rc.top);
        result.lineTo(rc.right,rc.top+rc.height()/2);
        result.lineTo(rc.left,rc.bottom);
        result.lineTo(rc.left,rc.top);

        return result;
    }

    public static Path simpleRect(Rect rc)
    {
        Path result = new Path();

        result.moveTo(rc.left, rc.top);
        result.lineTo(rc.right, rc.top);
        result.lineTo(rc.right,rc.bottom);
        result.lineTo(rc.left,rc.bottom);
        result.lineTo(rc.left,rc.top);

        return result;
    }

    public static Path keyboardRect(Rect rc)
    {
        Path result = new Path();
        int w=rc.width()/4;
        int h = rc.height()/4;
        result.addPath(simpleRect(new Rect(rc.left, rc.top,rc.left+w,rc.top+h)));
        result.addPath(simpleRect(new Rect(rc.left+w, rc.top, rc.left +w+w, rc.top +h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w, rc.top,rc.left+w+w+w,rc.top+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top, rc.left +w+w+w+w, rc.top +h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w+w, rc.top, rc.left +w+w+w+w+w, rc.top +h)));

        //result.addPath(simpleRect(new Rect(rc.left, rc.top+h,rc.left+w,rc.top+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w, rc.top+h, rc.left +w+w, rc.top +h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top+h,rc.left+w+w+w+w,rc.top+h+h)));
        //result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top+h, rc.left +w+w+w+w, rc.top +h+h)));
        //result.addPath(simpleRect(new Rect(rc.left, rc.top+h+h,rc.left+w,rc.top+h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w, rc.top+h+h, rc.left +w+w, rc.top +h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top+h+h,rc.left+w+w+w+w,rc.top+h+h+h)));
        //result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top+h+h, rc.left +w+w+w+w, rc.top +h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left, rc.top+h+h+h,rc.left+w,rc.top+h+h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w, rc.top+h+h+h, rc.left +w+w, rc.top +h+h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w, rc.top+h+h+h,rc.left+w+w+w,rc.top+h+h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w, rc.top+h+h+h, rc.left +w+w+w+w, rc.top +h+h+h+h)));
        result.addPath(simpleRect(new Rect(rc.left+w+w+w+w, rc.top+h+h+h, rc.left +w+w+w+w+w, rc.top+h+h+h +h)));
        return result;
    }
}

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
}

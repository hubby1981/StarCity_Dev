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
}

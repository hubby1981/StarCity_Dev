package com.sim.star.bitworxx.starcity.views.icons;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;

/**
 * Created by WEIS on 24.04.2015.
 */
public class SkillIcon extends BaseIcon {

    @Override
    public Path getPath(Rect displayIn) {
        generatePoints(displayIn);
        Path result = new Path();

        int mh = Middle.y;
        int mw = Middle.x;
        int w = Size.Width;
        int h = SizeV.Height;

        int x1=mw+(w/4)*1;
        int y1=mh+(h/4)*1;
        int x2=x1+(w/4)*2;
        int y2=y1+(h/4)*2;

        result.addArc(makeRectF(x1,y1,x2,y2),0,360);
        int x3=mw-(w/4)*3;
        int y3=mh+(h/4)*1;
        int x4=x3+(w/4)*2;
        int y4=y3+(h/4)*2;

        result.addArc(makeRectF(x3,y3,x4,y4),0,360);

        int x5=mw-(w/4)*2;
        int y5=mh-(h/4)*3;
        int x6=x5+(w/4)*2;
        int y6=y5+(h/4)*2;

        result.addArc(makeRectF(x5,y5,x6,y6),0,360);
        return result;
    }
}

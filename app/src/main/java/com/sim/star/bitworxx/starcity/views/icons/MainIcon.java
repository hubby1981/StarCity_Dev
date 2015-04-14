package com.sim.star.bitworxx.starcity.views.icons;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by WEIS on 13.04.2015.
 */
public class MainIcon extends BaseIcon {

    @Override
    public Path getPath(Rect displayIn) {
        generatePoints(displayIn);
        Path result = new Path();

        int mh = Middle.y;
        int mw = Middle.x;
        int w = Size.Width;
        int h = Size.Height;

        result.addRect(new RectF((float) mw - w / 2, (float) mh - h / 2, (float) mw + w / 2, (float) mh + h / 2), Path.Direction.CW);
        mh -= h * 2;
        result.addRect(new RectF((float) mw - w / 2, (float) mh - h / 2, (float) mw + w / 2, (float) mh + h / 2), Path.Direction.CW);
        mh += h * 4;


        result.addRect(new RectF((float) mw - w / 2, (float) mh - h / 2, (float) mw + w / 2, (float) mh + h / 2), Path.Direction.CW);

        return result;
    }


}

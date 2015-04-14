package com.sim.star.bitworxx.starcity.views.anim;

import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.views.Mini;

import java.util.ArrayList;

/**
 * Created by WEIS on 13.04.2015.
 */
public class WatchAnimation extends Animateable {


    private boolean Alt = false;

    public WatchAnimation(Mini parent) {

        super(parent);

    }

    public void drawItems() {
        if (canDraw()) {


            int w = DisplayRect.width() / 3;
            w -= MenuConst.FACTOR_TRIANGLE_OUT * MenuConst.FACTOR_TRIANGLE_OUT;

            int l = DisplayRect.left;
            Rect left = new Rect(l, DisplayRect.top, l + w, DisplayRect.bottom);
            l += w + MenuConst.FACTOR_TRIANGLE_OUT + MenuConst.FACTOR_TRIANGLE_OUT;
            Rect middle = new Rect(l, DisplayRect.top, l + w, DisplayRect.bottom);
            l += w + MenuConst.FACTOR_TRIANGLE_OUT + MenuConst.FACTOR_TRIANGLE_OUT;
            Rect right = new Rect(l, DisplayRect.top, l + w, DisplayRect.bottom);


            ArrayList<Rect> rRight = makeSubRect(right, 9);
            ArrayList<Rect> rLeft = makeSubRect(left, 5);
            ArrayList<Rect> rMiddle = makeSubRect(middle, 5);
            int index = 5;
            for (Rect rr : rLeft) {
                if (GM.LT.L1 > index) {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.PLATE_BACK_PAINTER);
                } else {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.BACK_PAINTER);
                }
                index--;
            }

            index = 5;
            for (Rect rr : rMiddle) {
                if (GM.LT.L2 >= index) {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.PLATE_BACK_PAINTER);
                } else {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.BACK_PAINTER);
                }
                index--;
            }

            index = 9;
            for (Rect rr : rRight) {
                if (GM.LT.L3 > index) {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.PLATE_BACK_PAINTER);
                } else {
                    Parent.getAsCanvas().drawRect(rr, MenuConst.BACK_PAINTER);
                }
                index--;
            }
        }
    }

    private ArrayList<Rect> makeSubRect(Rect bound, int count) {
        ArrayList<Rect> result = new ArrayList<Rect>();
        int h = (bound.height() - ((MenuConst.FACTOR_TRIANGLE_OUT * count)) * MenuConst.FACTOR_TRIANGLE_OUT) / count;

        int y = 0;

        for (int i = 0; i < count; i++) {
            int x = bound.left;

            int r = bound.right;
            int b = y + h;

            if (i == count - 1) {
                b = bound.bottom;
                y = b - h;
            } else if (i == 0) {
                y = bound.top;
                b = y + h;

            }
            result.add(new Rect(x, y, r, b));

            y += h + MenuConst.FACTOR_TRIANGLE_OUT;


        }

        return result;
    }
}

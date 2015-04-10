package com.sim.star.bitworxx.starcity.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.game.enums.MenuTriangle;

/**
 * Created by WEIS on 10.04.2015.
 */
public class Main extends MainBorder {

    private Mini MainMenu;

    public Main(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void get_init() {
        HasTitle = true;
        init(MenuConst.MARGIN_CLIP, MenuTriangle.ALL, MenuConst.FACTOR_TRIANGLE_OUT, MenuConst.FACTOR_TRIANGLE_IN);
        MainMenu = new Mini();
    }

    @Override
    protected void DrawItems(Canvas canvas) {
        MainMenu.HandleDisplay(measureItemWidth(), measureItemWidth());
        Point p = new Point(LeftItem, (InnerRect.bottom) - MainMenu.DisplayRect.height());
        canvas.drawBitmap(MainMenu.getAsBitmap(), (float) p.x, (float) p.y, null);
    }
}

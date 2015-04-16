package com.sim.star.bitworxx.starcity.constants;

import android.graphics.Paint;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;

/**
 * Created by WEIS on 15.04.2015.
 */
public class ContentFont {

    public static int FontHeightHeader=40;
    public static int FontHeightSubHeader=FontHeightHeader-4;
    public static int FontHeight=FontHeightSubHeader-4;


    public static int HEADER_X = 1;
    public static int SUB_HEADER_X = 2;
    public static int FONT_X = 3;

    public static int HEADER_Y= 1;
    public static int SUB_HEADER_Y = 1;
    public static int FONT_Y = 1;

    public static int measureTextW(int cells,TextSize size)
    {
        return size==TextSize.HEADER?cells*HEADER_X:size==TextSize.SUB_HEADER?cells*SUB_HEADER_X:cells*FONT_X;
    }

    public static int measureTextH(int rows,TextSize size)
    {
        return size==TextSize.HEADER?rows*HEADER_Y:size==TextSize.SUB_HEADER?rows*SUB_HEADER_Y:rows*FONT_Y;
    }
}

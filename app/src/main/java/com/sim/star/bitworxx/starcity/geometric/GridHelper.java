package com.sim.star.bitworxx.starcity.geometric;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.HashMap;

/**
 * Created by WEIS on 15.04.2015.
 */
public class GridHelper {

    public static HashMap<Point,Rect> measureElements(Rect bound,int maxX,int maxY)
    {
        HashMap<Point,Rect> result=new HashMap<>();

        int w = bound.width()/maxX;
        int h = bound.height()/maxY;
        int x=bound.left;
        int y=bound.top;

        for(int xi =0 ;xi<maxY;xi++)
        {
            for(int yi=0;yi<maxX;yi++)
            {
                result.put(new Point(xi,yi),new Rect(x,y,x+w,y+h));
                x+=w;
            }
            y+=h;
            x=bound.left;
        }

        return result;
    }
}

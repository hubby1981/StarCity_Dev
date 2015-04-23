package com.sim.star.bitworxx.starcity.views.touch;

import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 14.04.2015.
 */
public class ActionContainer {

    private static HashMap<String,ArrayList<ActionHandler>> Handler;
    private static HashMap<String,ArrayList<ActionHandler>> HandlerButton;

    public static boolean InitBorder = false;

    static {
        Handler = new HashMap<>();
        HandlerButton=new HashMap<>();
    }

    public static void checkUp(Point point) {
        checkInternal(point);
    }

    private static void checkInternal(Point point)
    {
        checkInternalKey(point,"MAIN");
        if(MenuBitmaps.ActualWindow!=null)
            checkInternalKey(point,MenuBitmaps.ActualWindow.getPageId());

    }
    private static void checkInternalKey(Point point,String id)
    {


            if(Handler.containsKey(id))
            {
                ArrayList<ActionHandler> handler = Handler.get(id);
                if (Handler != null)
                    for (ActionHandler h : handler) {
                        h.checkUp(point);
                    }

            }
            if(HandlerButton.containsKey(id))
            {
                ArrayList<ActionHandler> handlerButton = HandlerButton.get(id);

                if (HandlerButton != null) {
                    for (ActionHandler h : handlerButton) {
                        h.checkUp(point);
                    }
                }
            }

    }
    public static void addClick(ActionHandler handler)
    {
        if(MenuBitmaps.ActualWindow!=null)
        {
            String id = MenuBitmaps.ActualWindow.getPageId();
            ArrayList<ActionHandler> handlerButton = HandlerButton.get(id);
            if(handlerButton==null) {
                handlerButton = new ArrayList<>();
                HandlerButton.remove(id);
                HandlerButton.put(id,handlerButton);
            }
            handlerButton.add(handler);
        }
    }
    public static void addClickHandler(ActionHandler handler)
    {
        if(MenuBitmaps.ActualWindow!=null)
        {
            String id = MenuBitmaps.ActualWindow.getPageId();
            ArrayList<ActionHandler> handlerButton = Handler.get(id);
            if(handlerButton==null) {
                handlerButton = new ArrayList<>();
                Handler.remove(id);
                Handler.put(id,handlerButton);
            }
            handlerButton.add(handler);
        }
    }

    public static void addClickHandlerMain(ActionHandler handler)
    {

            String id = "MAIN";
            ArrayList<ActionHandler> handlerButton = Handler.get(id);
            if(handlerButton==null) {
                handlerButton = new ArrayList<>();
                Handler.remove(id);
                Handler.put(id,handlerButton);
            }
            handlerButton.add(handler);

    }
    public static void flushPage()
    {
        if(MenuBitmaps.ActualWindow!=null)
            Handler.remove(MenuBitmaps.ActualWindow.getPageId());
    }

    public static void flush()
    {
        if(HandlerButton!=null)
            HandlerButton.clear();
    }


    public static void addButton(Rect rect,Runnable action)
    {
        if(HandlerButton!=null)
            addClick(new ActionHandler(rect, action));
    }
}

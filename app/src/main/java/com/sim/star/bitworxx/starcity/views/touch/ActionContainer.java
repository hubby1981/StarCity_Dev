package com.sim.star.bitworxx.starcity.views.touch;

import android.graphics.Point;
import android.graphics.Rect;

import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.constants.KEY;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 14.04.2015.
 */
public class ActionContainer {

    private static HashMap<String,ArrayList<ActionHandler>> Handler;
    private static HashMap<String,ArrayList<ActionHandler>> HandlerButton;
    private static HashMap<String,ArrayList<ActionHandler>> HandlerButtonHidden;

    public static boolean InitBorder = false;

    static {
        Handler = new HashMap<>();
        HandlerButton=new HashMap<>();
        HandlerButtonHidden=new HashMap<>();

    }

    public static void checkUp(Point point) {
        checkInternal(point);
    }

    private static void checkInternal(Point point)
    {
        checkInternalKey(point, "MAIN");
        if(MenuBitmaps.ActualWindow!=null)
            checkInternalKey(point,MenuBitmaps.ActualWindow.getPageId());

    }
    private static void checkInternalKey(Point point,String id)
    {



            if(KEY.Active.equals("NONE")){
                if(Handler.containsKey(id))
                {
                    ArrayList<ActionHandler> handler = Handler.get(id);
                    if (handler != null)
                        for (ActionHandler h : handler) {
                            h.checkUp(point);
                        }

                }
                if(HandlerButton.containsKey(id))
                {
                    ArrayList<ActionHandler> handlerButton = HandlerButton.get(id);

                    if (handlerButton != null) {
                        for (ActionHandler h : handlerButton) {
                            h.checkUp(point);
                        }
                    }
                }

            }
        if(HandlerButtonHidden.containsKey(id))
        {
            ArrayList<ActionHandler> handlerButton = HandlerButtonHidden.get(id);

            if (handlerButton != null) {
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

    public static void addClickHidden(ActionHandler handler)
    {
        if(MenuBitmaps.ActualWindow!=null)
        {
            String id = MenuBitmaps.ActualWindow.getPageId();
            ArrayList<ActionHandler> handlerButton = HandlerButtonHidden.get(id);
            if(handlerButton==null) {
                handlerButton = new ArrayList<>();
                HandlerButtonHidden.remove(id);
                HandlerButtonHidden.put(id,handlerButton);
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
                Handler.put(id, handlerButton);
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


    public static void addButton(Rect rect,Runnable action,String token)
    {
        if(HandlerButton!=null)
            addClick(new ActionHandler(rect, action,token));
    }


    public static void addButtonHidden(Rect rect,Runnable action,String token)
    {
        if(HandlerButtonHidden!=null)
            addClickHidden(new ActionHandler(rect, action,token));
    }

    public static void clearHidden()
    {
        if(HandlerButtonHidden!=null)
            HandlerButtonHidden.clear();
    }

}

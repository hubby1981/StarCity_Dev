package com.sim.star.bitworxx.starcity.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.sim.star.bitworxx.starcity.constants.DirtyRects;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.game.enums.MenuTriangle;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.anim.BankAnimation;
import com.sim.star.bitworxx.starcity.views.anim.BitmapAnimation;
import com.sim.star.bitworxx.starcity.views.anim.MainAnimation;
import com.sim.star.bitworxx.starcity.views.anim.SubMenuAnimation;
import com.sim.star.bitworxx.starcity.views.anim.WatchAnimation;
import com.sim.star.bitworxx.starcity.views.content.ContentWindow;
import com.sim.star.bitworxx.starcity.views.content.MainContent;

/**
 * Created by WEIS on 10.04.2015.
 */
public class Main extends MainBorder {


    private Mini MainMenu;
    private Mini TopMenu;
    private Mini TimeMenu;
    private Mini SubMenu;

    private Mini SubMenuBank;
    private Mini SubMenuTech;
    private Mini SubMenuSkill;

    private WatchAnimation Watcher;
    private MainAnimation Main;
    private BankAnimation Bank;
    private SubMenuAnimation Sub;
    private BitmapAnimation Race;
    private boolean ShowSubMenu = false;


    public Main(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void get_init() {
        HasTitle = true;
        init(MenuConst.MARGIN_CLIP, MenuTriangle.ALL, MenuConst.FACTOR_TRIANGLE_OUT, MenuConst.FACTOR_TRIANGLE_IN);
        MainMenu = new Mini();
        TopMenu = new Mini();
        TimeMenu = new Mini();
        SubMenu = new Mini();
        SubMenuBank = new Mini();
        SubMenuSkill = new Mini();
        SubMenuTech = new Mini();

        Watcher = new WatchAnimation(TimeMenu);
        Main = new MainAnimation(MainMenu);
        Bank = new BankAnimation(SubMenuBank);
        Sub = new SubMenuAnimation(SubMenu);
        Race = new BitmapAnimation(TopMenu, MenuBitmaps.BITMAP_RACE);

        MainMenu.setRunnable(RunnablesMainMenu.R_A_MAIN_MENU);
        SubMenu.setRunnable(RunnablesMainMenu.R_A_SUB_MENU);


    }

    @Override
    protected void checkUp(Point check) {
        if (Show.ShowMainMenu)
            MainMenu.checkUp(check);
        TopMenu.checkUp(check);
        if (Show.ShowTimer)
            TimeMenu.checkUp(check);
        if (Show.ShowSubMenu) {
            SubMenu.checkUp(check);

            if (Show.ShowSubMenuSecondLevel) {
                SubMenuBank.checkUp(check);
                SubMenuSkill.checkUp(check);
                SubMenuTech.checkUp(check);
            }
        }

    }

    @Override
    protected void drawItems(Canvas canvas) {
        Point p = null;
        if (Show.ShowMainMenu) {
            MainMenu.HandleDisplay(measureItemWidth(), measureItemWidth());
            p = new Point(LeftItem, (InnerRect.bottom) - MainMenu.DisplayRect.height());
            MainMenu.Measure = p;
            canvas.drawBitmap(MainMenu.getAsBitmap(), (float) p.x, (float) p.y, null);
            Main.drawItems();
        }
        if(Show.ShowTopMenu){
                TopMenu.HandleDisplay(measureItemWidth(), measureItemWidth());
                p = new Point(LeftItem, (InnerRect.top));
                TopMenu.Measure = p;
                canvas.drawBitmap(TopMenu.getAsBitmap(), (float) p.x, (float) p.y, null);
                Race.drawItems();}
        if (Show.ShowSubMenu) {
            SubMenu.HandleDisplay(measureItemWidth(), measureItemWidth());
            p = new Point(InnerRect.left + FACTOR_TRIANGLE_OUT, TopItem);
            SubMenu.Measure = p;
            canvas.drawBitmap(SubMenu.getAsBitmap(), (float) p.x, (float) p.y, null);
            Sub.drawItems();
            if (Show.ShowSubMenuSecondLevel) {


                int subLeft = (InnerRect.left + FACTOR_TRIANGLE_OUT) + measureItemWidth() + FACTOR_TRIANGLE_OUT;

                SubMenuTech.HandleDisplay(measureItemWidth(), measureItemWidth());
                p = new Point(subLeft, TopItem);
                SubMenuTech.Measure = p;
                canvas.drawBitmap(SubMenuTech.getAsBitmap(), (float) p.x, (float) p.y, null);

                SubMenuBank.HandleDisplay(measureItemWidth(), measureItemWidth());
                p = new Point(subLeft, (TopItem - measureItemWidth()) - FACTOR_TRIANGLE_OUT);
                SubMenuBank.Measure = p;
                canvas.drawBitmap(SubMenuBank.getAsBitmap(), (float) p.x, (float) p.y, null);
                Bank.drawItems();

                SubMenuSkill.HandleDisplay(measureItemWidth(), measureItemWidth());
                p = new Point(subLeft, TopItem + measureItemWidth() + FACTOR_TRIANGLE_OUT + FACTOR_TRIANGLE_OUT);
                SubMenuSkill.Measure = p;
                canvas.drawBitmap(SubMenuSkill.getAsBitmap(), (float) p.x, (float) p.y, null);
            }
        }
        if (Show.ShowTimer) {
            TimeMenu.HandleDisplay(measureItemWidth(), measureItemWidth());
            p = new Point((InnerRect.right - FACTOR_TRIANGLE_OUT) - measureItemWidth(), TopItem);
            TimeMenu.Measure = p;
            canvas.drawBitmap(TimeMenu.getAsBitmap(), (float) p.x, (float) p.y, null);
            Watcher.drawItems();
            DirtyRects.DirtyWatch=new Rect(p.x,p.y,p.x+TimeMenu.getOutboundRect().width(),p.y+TimeMenu.getOutboundRect().height());
        }
    }

    @Override
    protected void drawContent(Canvas canvas) {


        if(MenuBitmaps.ActualWindow==null)
            MenuBitmaps.ActualWindow = new MainContent(InnerRect);

        if(MenuBitmaps.ActualWindow!=null)
            MenuBitmaps.ActualWindow.drawOnCanvas(canvas);
    }
}

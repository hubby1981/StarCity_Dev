package com.sim.star.bitworxx.starcity.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.R;
import com.sim.star.bitworxx.starcity.constants.CliprRects;
import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.game.enums.Direction;
import com.sim.star.bitworxx.starcity.game.enums.MenuTriangle;
import com.sim.star.bitworxx.starcity.geometric.GeometricHelp;
import com.sim.star.bitworxx.starcity.geometric.TriagleHelper;
import com.sim.star.bitworxx.starcity.highlight.BlinkCode;
import com.sim.star.bitworxx.starcity.player.PlayerStore;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
import com.sim.star.bitworxx.starcity.views.icons.BankIcon;
import com.sim.star.bitworxx.starcity.views.icons.SkillIcon;
import com.sim.star.bitworxx.starcity.views.icons.TechIcon;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;
import com.sim.star.bitworxx.starcity.views.touch.ActionHandler;

import java.util.UUID;

/**
 * Created by WEIS on 09.04.2015.
 */

public abstract class MainBorder extends View {


    protected int MARGIN_CLIP;
    protected int FACTOR_TRIANGLE_OUT;
    protected int FACTOR_TRIANGLE_IN;
    protected boolean HasTitle = false;
    protected Rect InnerRect;
    protected int LeftItem = 0;
    protected int TopItem = 0;
    private MenuTriangle TRIANGLES = MenuTriangle.NONE;
    private Rect OutboundRect = null;
    private RectF OutboundRectF = null;
    private Rect InboundRect = null;
    private RectF InboundRectF = null;
    private Rect TitleRect = null;
    private RectF TitleRectF = null;
    private Path LeftPage=null;
    private Path RightPage=null;
private Paint HeaderFontPaint;
    public static Typeface VenusFace;
    private UUID Id;

    public MainBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
        Id=UUID.randomUUID();


        VenusFace=Typeface.createFromAsset(context.getAssets(),"venus.ttf");
        get_init();
    }

    public abstract void get_init();

    public void init(int marginClip, MenuTriangle triangles, int factorTriangleOut, int factorTriangleIn) {
        MARGIN_CLIP = marginClip;
        TRIANGLES = triangles;
        FACTOR_TRIANGLE_OUT = factorTriangleOut;
        FACTOR_TRIANGLE_IN = factorTriangleIn;
        refresh();

    }

    public void refresh() {
        OutboundRect = InboundRect = null;
        OutboundRectF = InboundRectF = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            Point wire = new Point((int) event.getX(), (int) event.getY());
            checkUp(wire);
            ActionContainer.checkUp(wire);
        }
        return true;
    }

    protected abstract void checkUp(Point check);

    private RectF getOutboundRectF() {
        if (OutboundRectF == null)
            OutboundRectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        return OutboundRectF;
    }

    private Rect getOutboundRect() {
        if (OutboundRect == null)
            OutboundRect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
        return OutboundRect;
    }

    private Rect getInboundRect() {
        if (InboundRect == null)
            InboundRect = new Rect(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
        return InboundRect;
    }

    private RectF getInboundRectF() {
        if (InboundRectF == null)
            InboundRectF = new RectF(getOutboundRect().left + translateMarginWidth(), getOutboundRect().top + translateMarginHeight(),
                getOutboundRect().right - translateMarginWidth(), getOutboundRect().bottom - translateMarginHeight());
        return InboundRectF;
    }

    private Rect getTitleRect() {
        if (TitleRect == null)
            TitleRect = new Rect(getInboundRect().left + translateMarginWidth() * MARGIN_CLIP, getInboundRect().bottom - translateMarginHeight() * FACTOR_TRIANGLE_OUT, getInboundRect().right - translateMarginWidth() * MARGIN_CLIP, getInboundRect().bottom);
        return TitleRect;
    }

    private RectF getTitleRectF() {
        if (TitleRectF == null)
            TitleRectF = new RectF(getInboundRect().left + translateMarginWidth() * MARGIN_CLIP, getOutboundRect().bottom - translateMarginHeight() * FACTOR_TRIANGLE_OUT, getInboundRect().right - translateMarginWidth() * MARGIN_CLIP, getInboundRect().bottom);
        return TitleRectF;
    }

    private int translateMarginWidth() {
        return (getMeasuredWidth() / 100) * MARGIN_CLIP;
    }

    private int translateMarginHeight() {
        return (getMeasuredHeight() / 100) * MARGIN_CLIP;
    }

    private void makeTrianglePath(Canvas canvas, int x, int y, int xx, int yy, Direction d) {
        canvas.clipPath(TriagleHelper.getTriangle(new Point(x, y), FACTOR_TRIANGLE_OUT, translateMarginWidth(), d), Region.Op.DIFFERENCE);
        canvas.clipPath(TriagleHelper.getTriangle(new Point(xx, yy), FACTOR_TRIANGLE_IN, translateMarginWidth(), d), Region.Op.UNION);
    }

    protected int measureItemWidth() {
        return (getInboundRect().width() / 100) * MenuConst.MARGIN_CLIP_MINI;
    }

    protected int measureItemHeight() {
        return (getInboundRect().height() / 100) * MenuConst.MARGIN_CLIP_MINI;
    }

    private void makeAttacherPath(Canvas canvas, int x, int y) {
        Path attacher = new Path();

        int w = measureItemWidth();
        int h = y + translateMarginHeight() / FACTOR_TRIANGLE_OUT;
        int hh = h / 2;
        int xx = w / (MenuConst.MARGIN_CLIP_MINI * FACTOR_TRIANGLE_OUT);
        x -= w / 2;
        w = x + w;

        InnerRect.top = (y + hh) + FACTOR_TRIANGLE_OUT * FACTOR_TRIANGLE_OUT * FACTOR_TRIANGLE_OUT;


        attacher.moveTo(x, y);
        attacher.lineTo(x, hh);
        attacher.lineTo(x, h);
        attacher.lineTo(x + xx, h + xx);
        attacher.lineTo(x + (xx + xx + xx), h + xx);
        attacher.lineTo(x + (xx + xx + xx + xx), h);
        attacher.lineTo(x + (xx + xx + xx + xx), h);

        attacher.lineTo(w - (xx + xx + xx + xx), h);
        attacher.lineTo(w - (xx + xx + xx + xx), h);
        attacher.lineTo(w - (xx + xx + xx), h + xx);
        attacher.lineTo(w - xx, h + xx);
        attacher.lineTo(w, h);
        attacher.lineTo(w, hh);
        attacher.moveTo(w, y);


        canvas.clipPath(attacher, Region.Op.UNION);

    }

    private void makeAttacherPath2(Canvas canvas, Rect bound) {
        Path attacher = new Path();

        int r = (measureItemHeight() / MenuConst.MARGIN_CLIP_MINI * MenuConst.FACTOR_TRIANGLE_OUT);
        int rr = r / 2;
        int rrr = rr;

        InnerRect.left = bound.right + FACTOR_TRIANGLE_OUT;
        TopItem = bound.top;
        attacher.moveTo(bound.left, bound.top);
        attacher.lineTo(bound.right - rrr, bound.top);
        attacher.lineTo(bound.right, bound.top + rrr);
        attacher.lineTo(bound.right, bound.top + rr + rr + rr);
        attacher.lineTo(bound.right - rrr, bound.top + rr + rr + rr + rrr);

        attacher.lineTo(bound.right - rrr, bound.bottom - rr - rr - rr - rrr);
        attacher.lineTo(bound.right, bound.bottom - rr - rr - rr);
        attacher.lineTo(bound.right, bound.bottom - rrr);
        attacher.lineTo(bound.right - rrr, bound.bottom);
        attacher.lineTo(bound.left, bound.bottom);
        canvas.clipPath(attacher, Region.Op.UNION);

    }

    private void makeAttacherPath2Inverse(Canvas canvas, Rect bound) {
        Path attacher = new Path();

        int r = (measureItemHeight() / MenuConst.MARGIN_CLIP_MINI) * MenuConst.FACTOR_TRIANGLE_OUT;
        int rr = r / 2;
        int rrr = rr;

        InnerRect.right = bound.left - FACTOR_TRIANGLE_OUT;

        attacher.moveTo(bound.right, bound.top);
        attacher.lineTo(bound.left + rrr, bound.top);
        attacher.lineTo(bound.left, bound.top + rrr);
        attacher.lineTo(bound.left, bound.top + rr + rr);
        attacher.lineTo(bound.left + rrr, bound.top + rr + rr + rrr);

        attacher.lineTo(bound.left + rrr, bound.bottom - rr - rr - rrr);
        attacher.lineTo(bound.left, bound.bottom - rr - rr);
        attacher.lineTo(bound.left, bound.bottom - rrr);
        attacher.lineTo(bound.left + rrr, bound.bottom);
        attacher.lineTo(bound.right, bound.bottom);
        canvas.clipPath(attacher, Region.Op.UNION);

    }

    private void makeAttacherPathInverse(Canvas canvas, int x, int y, int yy) {
        Path attacher = new Path();

        int w = measureItemWidth();
        int h = yy - translateMarginHeight() / FACTOR_TRIANGLE_OUT;

        int xx = w / (MenuConst.MARGIN_CLIP_MINI * FACTOR_TRIANGLE_OUT);
        x -= w / 2;
        w = x + w;

        InnerRect.bottom = (y - h * FACTOR_TRIANGLE_OUT);
        LeftItem = x;
        attacher.moveTo(x, y);
        attacher.lineTo(x, y - h);

        attacher.lineTo(x + xx, y - (h + xx));
        attacher.lineTo(x + (xx + xx + xx), y - (h + xx));
        attacher.lineTo(x + (xx + xx + xx + xx), y - h);
        attacher.lineTo(x + (xx + xx + xx + xx), y - h);

        attacher.lineTo(w - (xx + xx + xx + xx), y - h);
        attacher.lineTo(w - (xx + xx + xx + xx), y - h);
        attacher.lineTo(w - (xx + xx + xx), y - (h + xx));
        attacher.lineTo(w - xx, y - (h + xx));

        attacher.lineTo(w, y - h);
        attacher.lineTo(w, y);


        canvas.clipPath(attacher, Region.Op.UNION);

    }

    private Path makePlateH(Canvas canvas, int x, int y, int w, int h, boolean invert,boolean sample) {
        Path plate = new Path();


        x += translateMarginWidth() * FACTOR_TRIANGLE_OUT;
        w -= translateMarginWidth() * FACTOR_TRIANGLE_OUT;


        Point p1 = new Point(x, y);
        Point p2 = new Point(w, y);

        Point p3 = new Point(w - translateMarginWidth(), h - ((h - y) / 2));
        Point p4 = new Point(x + translateMarginWidth(), h - ((h - y) / 2));

        plate.moveTo(p1.x, p1.y);
        plate.lineTo(p2.x, p2.y);
        plate.lineTo(p3.x, p3.y);
        plate.lineTo(p4.x, p4.y);
        plate.lineTo(p1.x, p1.y);

        if(!sample)
        { canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);}else plate.close();
        return plate;
    }

    private Path makePlateV(Canvas canvas, int x, int y, int w, int h, boolean invert,boolean sample) {
        Path plate = new Path();


        y += translateMarginHeight() * FACTOR_TRIANGLE_OUT;
        h -= translateMarginHeight() * FACTOR_TRIANGLE_OUT;


        w -= (w - x) / 2;
        Point p1 = new Point(x, y);

        Point p4 = new Point(x, h);


        Point p2 = new Point(w, y + translateMarginHeight());
        Point p3 = new Point(w, h - translateMarginHeight());


        plate.moveTo(p1.x, p1.y);
        plate.lineTo(p2.x, p2.y);
        plate.lineTo(p3.x, p3.y);
        plate.lineTo(p4.x, p4.y);
        plate.lineTo(p1.x, p1.y);
        if(!sample) {
            canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
            canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);
        }else plate.close();
        return  plate;
    }

    protected abstract void drawItems(Canvas canvas);
    protected abstract void drawContent(Canvas canvas);

    private void createBackShader() {
        if (Show.RenderShader) {
            MenuConst.BACK_SHADER_PAINTER = new Paint();
            MenuConst.BACK_SHADER_PAINTER.setStyle(Paint.Style.FILL);

            MenuConst.BACK_SHADER_PAINTER.setShader(MenuConst.BACK_SHADER);

            MenuConst.BACK_SHADER_PAINTER.setAntiAlias(true);

            if (Show.RenderMenuShader) {
                if (MenuConst.BACK_PAINTER_WITH_SHADER == null && MenuConst.BACK_SHADER2 != null) {
                    MenuConst.BACK_PAINTER_WITH_SHADER = new Paint();
                    MenuConst.BACK_PAINTER_WITH_SHADER.setStyle(Paint.Style.FILL);
                    MenuConst.BACK_PAINTER_WITH_SHADER.setColor(ColorSetter.FILL_BACK_COLOR);
                    MenuConst.BACK_PAINTER_WITH_SHADER.setShader(MenuConst.BACK_SHADER2);

                    MenuConst.BACK_PAINTER_WITH_SHADER.setAntiAlias(true);

                }
            }
        }


    }

    private void initBorder() {

        if (ActionContainer.InitBorder == false) {
            Rect o = getOutboundRect();
            Rect i = getInboundRect();

            int w = i.left - o.left;
            ContentFont.FontHeightHeader = (getHeight()/100)*MenuConst.MARGIN_CLIP_MINI/(MenuConst.FACTOR_TRIANGLE_OUT+FACTOR_TRIANGLE_OUT);
            ContentFont.FontHeightHeader+=FACTOR_TRIANGLE_OUT*FACTOR_TRIANGLE_OUT+ContentFont.HEADER_MAX;
            ContentFont.FontHeightSubHeader=ContentFont.FontHeightHeader-ContentFont.SUB_HEADER_MAX;
            ContentFont.FontHeight=ContentFont.FontHeightSubHeader-ContentFont.FONT_MAX;

            Rect rL = new Rect(o.left, (o.top + o.height() / 2) - measureItemHeight(), o.left + w + FACTOR_TRIANGLE_OUT * 4, (o.top + o.height() / 2) + measureItemHeight());

            ActionContainer.addClickHandlerMain(new ActionHandler(rL, RunnablesMainMenu.R_S_SUB_MENU,this.Id.toString()));
            Rect rR = new Rect(o.right - w + FACTOR_TRIANGLE_OUT * 4, (o.top + o.height() / 2) - measureItemHeight(), o.right, (o.top + o.height() / 2) + measureItemHeight());

            ActionContainer.addClickHandlerMain(new ActionHandler(rR, RunnablesMainMenu.R_S_TIME_MENU,this.Id.toString()));

            Rect rM = new Rect(o.right - ((o.width() / 2)) - measureItemWidth(), o.bottom - measureItemHeight(), o.right - ((o.width() / 2)) + measureItemWidth(), o.bottom);

            ActionContainer.addClickHandlerMain(new ActionHandler(rM, RunnablesMainMenu.R_S_MAIN_MENU,this.Id.toString()));
            ActionContainer.InitBorder = true;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Canvas canvasBit=null;
        if(!MenuBitmaps.BitmapDrawables.containsKey(Id))
        {

                MenuBitmaps.BitmapDrawables.put(Id, Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444));
                canvasBit=new Canvas(MenuBitmaps.BitmapDrawables.get(Id));
                drawBorderBack(canvasBit);



        }




        if(Show.ShowOverlay)
        {
            canvas.drawRect(OutboundRect,MenuConst.HALF_TRANSPARENT_BACK_PAINTER);
        }else
        {
            canvas.drawBitmap(MenuBitmaps.BitmapDrawables.get(Id),0,0,null);
            drawContent(canvas);

            drawItems(canvas);
        }

    }

    private void drawBorderBack(Canvas canvas)
    {
        initBorder();

        Path pPlate=null;
        int wL = 4;
        int wH = 4;
        Path outboundPath = new Path();
        outboundPath.addRect(getOutboundRectF(), Path.Direction.CW);

        Path inboundPath = new Path();
        inboundPath.addRect(getInboundRectF(), Path.Direction.CW);

        if (MenuConst.BACK_SHADER_PAINTER == null) {
            createBackShader();
        }

        canvas.clipPath(outboundPath);
        canvas.clipPath(inboundPath, Region.Op.DIFFERENCE);



        InnerRect = new Rect(getInboundRect().left + translateMarginWidth(), getInboundRect().top + translateMarginHeight(),
                getInboundRect().right - translateMarginHeight(), getTitleRect().top - translateMarginWidth() / FACTOR_TRIANGLE_OUT);


        if (HasTitle) {
            makeAttacherPath(canvas, getInboundRect().right - getInboundRect().width() / 2, getInboundRect().top);
            makeAttacherPathInverse(canvas, getTitleRect().right - getTitleRect().width() / 2, getTitleRect().top, getInboundRect().top);

            makeAttacherPath2(canvas, new Rect(getInboundRect().left,
                    (getInboundRect().top + getInboundRect().height() / 2) - measureItemWidth() / 2,
                    getInboundRect().left + (translateMarginWidth() / FACTOR_TRIANGLE_OUT),
                    (getInboundRect().top + getInboundRect().height() / 2) + measureItemWidth() / 2));

            makeAttacherPath2Inverse(canvas, new Rect(getInboundRect().right - (translateMarginWidth() / FACTOR_TRIANGLE_OUT),
                    (getInboundRect().top + getInboundRect().height() / 2) - measureItemWidth() / 2,
                    getInboundRect().right,
                    (getInboundRect().top + getInboundRect().height() / 2) + measureItemWidth() / 2));
        }


        if (HasTitle) {
            Path titlePath = new Path();
            Rect titleR = getTitleRect();
            titlePath.moveTo(titleR.left, titleR.bottom);
            titlePath.lineTo(titleR.left + translateMarginWidth() * FACTOR_TRIANGLE_OUT, titleR.top);
            titlePath.lineTo(titleR.right - translateMarginWidth() * FACTOR_TRIANGLE_OUT, titleR.top);
            titlePath.lineTo(titleR.right, titleR.bottom);
            canvas.clipPath(titlePath, Region.Op.UNION);
        }

        if (TRIANGLES == MenuTriangle.LEFT || TRIANGLES == MenuTriangle.ALL)
            makeTrianglePath(canvas, getOutboundRect().left, getOutboundRect().top, getInboundRect().left, getInboundRect().top, Direction.WEST);
        if (TRIANGLES == MenuTriangle.RIGHT || TRIANGLES == MenuTriangle.ALL)
            makeTrianglePath(canvas, getOutboundRect().right, getOutboundRect().top, getInboundRect().right, getInboundRect().top, Direction.EAST);
        if (TRIANGLES == MenuTriangle.BOTTOM || TRIANGLES == MenuTriangle.ALL)
            makeTrianglePath(canvas, getOutboundRect().right, getOutboundRect().bottom, getInboundRect().right, getInboundRect().bottom, Direction.SOUTH);
        if (TRIANGLES == MenuTriangle.TOP || TRIANGLES == MenuTriangle.ALL)
            makeTrianglePath(canvas, getOutboundRect().left, getOutboundRect().bottom, getInboundRect().left, getInboundRect().bottom, Direction.NORTH);

        if (MenuConst.BACK_PAINTER_WITH_SHADER != null && Show.RenderShader)
            canvas.drawPath(outboundPath, MenuConst.BACK_PAINTER_WITH_SHADER);

        canvas.drawPath(outboundPath, MenuConst.BACK_PAINTER);
        if (HasTitle) {
            Paint pp = new Paint();
            pp.setStyle(Paint.Style.STROKE);
            pp.setAntiAlias(true);
            pp.setColor(ColorSetter.FILL_BACK_COLOR_PLATE);
            pp.setStrokeWidth(MenuConst.MARGIN_CLIP_MINI);
            canvas.drawPath(outboundPath, pp);
        }


        pPlate = makePlateH(canvas, getOutboundRect().left, getOutboundRect().top+wH, getOutboundRect().right, getInboundRect().top+wH, true,false);



        if (HasTitle) {
            pPlate=makePlateH(canvas, getTitleRect().left, getOutboundRect().bottom-wH, getTitleRect().right, (getTitleRect().bottom - translateMarginHeight())-wH, false,false);
        } else {
            pPlate=makePlateH(canvas, getOutboundRect().left, getOutboundRect().bottom-wH, getOutboundRect().right, getInboundRect().bottom-wH, false,false);
        }
        pPlate=makePlateV(canvas, getOutboundRect().left+wL, getOutboundRect().top, getInboundRect().left+wL, getOutboundRect().bottom, true,false);
        pPlate=makePlateV(canvas, getOutboundRect().right-wL, getOutboundRect().top, getInboundRect().right-wL, getOutboundRect().bottom, false,false);

        int wTitle = (getTitleRect().width()/100)*MenuConst.MARGIN_CLIP_MINI;
        Rect leftPage = new Rect(getTitleRect().left,getTitleRect().top,getTitleRect().left+wTitle,getTitleRect().bottom);
        Rect rightPage = new Rect(getTitleRect().right-wTitle,getTitleRect().top,getTitleRect().right,getTitleRect().bottom);
        LeftPage=GeometricHelp.generateTrianglePath(leftPage,0,0,0,0,48,30,0,0);
        RightPage=GeometricHelp.generateTrianglePath(rightPage,0,0,0,0,0,0,48,30);

        HeaderFontPaint = new Paint();
        HeaderFontPaint.setStyle(Paint.Style.FILL);
        HeaderFontPaint.setTypeface(MainBorder.VenusFace);
        HeaderFontPaint.setFakeBoldText(true);
        HeaderFontPaint.setStrokeWidth(1);
        HeaderFontPaint.setColor(ColorSetter.FILL_STROKE_BACK_FORE);
        HeaderFontPaint.setTextSize((float) ContentFont.FontHeightHeader+8);


        Path pp1 = GeometricHelp.prevTriangle(new Rect(leftPage.right-leftPage.width()/2,leftPage.top+leftPage.height()/4,leftPage.right-leftPage.width()/4,leftPage.bottom-leftPage.height()/4));
        canvas.drawPath(pp1,MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(pp1,MenuConst.STROKE_BACK_PAINTER);

        pp1 = GeometricHelp.nextTriangle(new Rect(rightPage.left+leftPage.width()/4,rightPage.top+rightPage.height()/4,rightPage.left+leftPage.width()/2,rightPage.bottom-rightPage.height()/4));
        canvas.drawPath(pp1,MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(pp1,MenuConst.STROKE_BACK_PAINTER);

        ActionContainer.addClickHandlerMain(new ActionHandler(leftPage, RunnablesMainMenu.R_A_PREV_PAGE,this.Id.toString()));
        ActionContainer.addClickHandlerMain(new ActionHandler(rightPage, RunnablesMainMenu.R_A_NEXT_PAGE,this.Id.toString()));

        HeaderFontPaint.setTextSize((float) ContentFont.FontHeightHeader-8);
        HeaderFontPaint.setFakeBoldText(false);

        int hh = (int)(leftPage.height()/1.6)+2;

        String money= PlayerStore.getPlayerBank().getMainMoney();
        String skill=PlayerStore.getPlayerBank().getMainLoop();
        String tech =PlayerStore.getPlayerBank().getMainTech();
        String c1 =PlayerStore.getPlayerBank().getMainCrystalBlue();
        String c2 =PlayerStore.getPlayerBank().getMainCrystalGreen();
        String c3 =PlayerStore.getPlayerBank().getMainCrystalYellow();
        String c4 =PlayerStore.getPlayerBank().getMainCrystalRed();
        String c5 =PlayerStore.getPlayerBank().getMainCrystalViolet();
        Rect rbi = new Rect(leftPage.right+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,(leftPage.right+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);
        int tw = (int) HeaderFontPaint.measureText(money);
        int tw2 = (int) HeaderFontPaint.measureText(skill);
        int tw3 = (int) HeaderFontPaint.measureText(tech);
        int tw4 = (int) HeaderFontPaint.measureText(c1);
        int tw5 = (int) HeaderFontPaint.measureText(c2);
        int tw6 = (int) HeaderFontPaint.measureText(c3);
        int tw7 = (int) HeaderFontPaint.measureText(c4);


        Rect rsi = new Rect((rbi.right+tw)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rbi.right+tw)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);

        Rect rti = new Rect((rsi.right+tw2)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rsi.right+tw2)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);

        Rect rci1 = new Rect((rti.right+tw3)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rti.right+tw3)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);
        Rect rci2 = new Rect((rci1.right+tw4)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rci1.right+tw4)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);
        Rect rci3 = new Rect((rci2.right+tw5)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rci2.right+tw5)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);

        Rect rci4 = new Rect((rci3.right+tw6)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rci3.right+tw6)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);

        Rect rci5 = new Rect((rci4.right+tw7)+MenuConst.MARGIN_CLIP_MINI*1,leftPage.top+2,((rci4.right+tw7)+MenuConst.MARGIN_CLIP_MINI*1)+hh,leftPage.top+hh);



        BankIcon bi = new BankIcon();
        SkillIcon si = new SkillIcon();
        TechIcon ti = new TechIcon();

        canvas.drawPath( bi.getPath(rbi),MenuConst.FORE_PAINTER_ICON);
        canvas.drawText(money, rbi.right, rbi.centerY() + rbi.height() / 4, HeaderFontPaint);
        canvas.drawPath(si.getPath(rsi), MenuConst.FORE_PAINTER_ICON);
        canvas.drawText(skill, rsi.right, rsi.centerY() + rsi.height() / 4, HeaderFontPaint);
        canvas.drawPath(ti.getPath(rti), MenuConst.FORE_PAINTER_ICON);
        canvas.drawText(tech, rti.right, rti.centerY() + rti.height() / 4, HeaderFontPaint);
        Bitmap bitC1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
        Bitmap bitC2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
        Bitmap bitC3 = BitmapFactory.decodeResource(getResources(), R.drawable.c3);
        Bitmap bitC4 = BitmapFactory.decodeResource(getResources(), R.drawable.c4);
        Bitmap bitC5 = BitmapFactory.decodeResource(getResources(), R.drawable.c5);

        canvas.drawBitmap(bitC1,new Rect(0,0,bitC1.getWidth(),bitC1.getHeight()),rci1,null);
        canvas.drawBitmap(bitC2,new Rect(0,0,bitC2.getWidth(),bitC2.getHeight()),rci2,null);
        canvas.drawBitmap(bitC3,new Rect(0,0,bitC3.getWidth(),bitC3.getHeight()),rci3,null);
        canvas.drawBitmap(bitC4,new Rect(0,0,bitC4.getWidth(),bitC4.getHeight()),rci4,null);
        canvas.drawBitmap(bitC5,new Rect(0,0,bitC5.getWidth(),bitC5.getHeight()),rci5,null);

        canvas.drawText(c1, rci1.right, rci1.centerY() + rci1.height() / 4, HeaderFontPaint);
        canvas.drawText(c2, rci2.right, rci2.centerY() + rci1.height() / 4, HeaderFontPaint);
        canvas.drawText(c3, rci3.right, rci3.centerY() + rci1.height() / 4, HeaderFontPaint);
        canvas.drawText(c4, rci4.right, rci4.centerY() + rci1.height() / 4, HeaderFontPaint);
        canvas.drawText(c5, rci5.right, rci5.centerY() + rci1.height() / 4, HeaderFontPaint);


        canvas.clipRect(InnerRect, Region.Op.UNION);

        CliprRects.InnerRectMain=InnerRect;
        CliprRects.OuterRectMain=OutboundRect;
    }




}

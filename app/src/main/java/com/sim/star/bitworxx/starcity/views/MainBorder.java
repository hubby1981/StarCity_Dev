package com.sim.star.bitworxx.starcity.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.sim.star.bitworxx.starcity.MainScreen;
import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.ContentFont;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.display.Show;
import com.sim.star.bitworxx.starcity.game.enums.Direction;
import com.sim.star.bitworxx.starcity.game.enums.MenuTriangle;
import com.sim.star.bitworxx.starcity.geometric.TriagleHelper;
import com.sim.star.bitworxx.starcity.runnable.RunnablesMainMenu;
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

    private UUID Id;

    public MainBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
        Id=UUID.randomUUID();


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

    private void makePlateH(Canvas canvas, int x, int y, int w, int h, boolean invert) {
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

        canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);
    }

    private void makePlateV(Canvas canvas, int x, int y, int w, int h, boolean invert) {
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

        canvas.drawPath(plate, MenuConst.PLATE_BACK_PAINTER);
        canvas.drawPath(plate, MenuConst.PLATE_STROKE_BACK_PAINTER);
    }

    protected abstract void drawItems(Canvas canvas);
    protected abstract void drawContent(Canvas canvas);

    private void createBackShader() {
        if (Show.RenderShader) {
            MenuConst.BACK_SHADER_PAINTER = new Paint();
            MenuConst.BACK_SHADER_PAINTER.setStyle(Paint.Style.FILL);
            MenuConst.BACK_SHADER_PAINTER.setColor(ColorSetter.FILL_SHADER_BACK_HALF);
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
            ContentFont.FontHeightHeader+=FACTOR_TRIANGLE_OUT*FACTOR_TRIANGLE_OUT+1;
            ContentFont.FontHeightSubHeader=ContentFont.FontHeightHeader-FACTOR_TRIANGLE_OUT;
            ContentFont.FontHeight=ContentFont.FontHeightSubHeader-FACTOR_TRIANGLE_OUT;

            Rect rL = new Rect(o.left, (o.top + o.height() / 2) - measureItemHeight(), o.left + w + FACTOR_TRIANGLE_OUT * 4, (o.top + o.height() / 2) + measureItemHeight());

            ActionContainer.Handler.add(new ActionHandler(rL, RunnablesMainMenu.R_S_SUB_MENU));
            Rect rR = new Rect(o.right - w + FACTOR_TRIANGLE_OUT * 4, (o.top + o.height() / 2) - measureItemHeight(), o.right, (o.top + o.height() / 2) + measureItemHeight());

            ActionContainer.Handler.add(new ActionHandler(rR, RunnablesMainMenu.R_S_TIME_MENU));

            Rect rM = new Rect(o.right - ((o.width() / 2)) - measureItemWidth(), o.bottom - measureItemHeight(), o.right - ((o.width() / 2)) + measureItemWidth(), o.bottom);

            ActionContainer.Handler.add(new ActionHandler(rM, RunnablesMainMenu.R_S_MAIN_MENU));
            ActionContainer.InitBorder = true;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Canvas canvasBit;
        if(!MenuBitmaps.BitmapDrawables.containsKey(Id))
        {

                MenuBitmaps.BitmapDrawables.put(Id, Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444));
                canvasBit=new Canvas(MenuBitmaps.BitmapDrawables.get(Id));
                drawBorderBack(canvasBit);



        }


        canvas.drawBitmap(MenuBitmaps.BitmapDrawables.get(Id),0,0,null);
        drawContent(canvas);

        drawItems(canvas);


    }

    private void drawBorderBack(Canvas canvas)
    {
        initBorder();


        Path outboundPath = new Path();
        outboundPath.addRect(getOutboundRectF(), Path.Direction.CW);

        Path inboundPath = new Path();
        inboundPath.addRect(getInboundRectF(), Path.Direction.CW);

        if (MenuConst.BACK_SHADER_PAINTER == null) {
            createBackShader();
        }
        if (MenuConst.BACK_SHADER_PAINTER != null)
        {
            canvas.drawRect(getOutboundRect(),MenuConst.BACK_PAINTER_BLACK);
            canvas.drawRect(getInboundRect(), MenuConst.BACK_SHADER_PAINTER);
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
            pp.setColor(ColorSetter.FILL_BACK_COLOR_PLATE_HALF);
            pp.setStrokeWidth(MenuConst.MARGIN_CLIP_MINI);
            canvas.drawPath(outboundPath, pp);
        }

        makePlateH(canvas, getOutboundRect().left, getOutboundRect().top, getOutboundRect().right, getInboundRect().top, true);
        if (HasTitle) {
            makePlateH(canvas, getTitleRect().left, getOutboundRect().bottom, getTitleRect().right, getTitleRect().bottom - translateMarginHeight(), false);
        } else {
            makePlateH(canvas, getOutboundRect().left, getOutboundRect().bottom, getOutboundRect().right, getInboundRect().bottom, false);
        }
        makePlateV(canvas, getOutboundRect().left, getOutboundRect().top, getInboundRect().left, getOutboundRect().bottom, true);
        makePlateV(canvas, getOutboundRect().right, getOutboundRect().top, getInboundRect().right, getOutboundRect().bottom, false);


        canvas.clipRect(InnerRect, Region.Op.UNION);
    }

    private void checkRenderClip(Canvas canvas) {
        if (Show.RenderClipShow) {
            for (ActionHandler h : ActionContainer.Handler) {
                canvas.drawRect(h.Bound, MenuConst.PLATE_BACK_PAINTER);
            }
        }
    }


}

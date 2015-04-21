package com.sim.star.bitworxx.starcity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.constants.DirtyRects;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.db.Meta;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.views.Main;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.net.IDN;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class MainScreen extends Activity {

    public static Runnable Init;
    public Timer GeneralTimer;
    private GM gm;
    private MenuConst mc;
    private ActionContainer ac;
    private DB db;


    public static UUID Id=UUID.randomUUID();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gm = new GM();
        mc = new MenuConst();
        ac = new ActionContainer();
        db  = new DB();
        db.setConnection(openOrCreateDatabase(DB.DB_NAME,MODE_PRIVATE,null));

        MetaObjectContainer ships = Meta.getContainer("starship");
        MetaObjectContainer destroyer = Meta.getContainer("starship","shiptype","DESTROYER");
        MetaObjectContainer explorer = Meta.getContainer("starship","shiptype","EXPLORER");
        MenuConst.BACK_SHADER = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader2), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        MenuBitmaps.BITMAP_RACE = BitmapFactory.decodeResource(getResources(), R.drawable.race_human);
        try {
            setContentView(R.layout.activity_main_screen);
        } catch (Exception e) {
            StackTraceElement[] rt = e.getStackTrace();
        }


        GeneralTimer = create_timer();
        Init = new Runnable() {
            @Override
            public void run() {
                update();
            }
        };
        runOnUiThread(Init);
    }


    public Timer create_timer() {
        Timer result = new Timer("GM", true);
        result.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        update();
                    }
                });
            }
        }, 0, 1000);
        return result;
    }


    public void update() {
       GM.animate();
        findViewById(R.id.imageView).invalidate();
    }








}

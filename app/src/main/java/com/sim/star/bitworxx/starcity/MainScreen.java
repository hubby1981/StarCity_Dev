package com.sim.star.bitworxx.starcity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Bundle;

import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends Activity {

    public static Runnable Init;
    public Timer GeneralTimer;
    private GM gm;
    private MenuConst mc;
    private ActionContainer ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DB.Connection = openOrCreateDatabase(DB.DB_NAME, MODE_PRIVATE, null);

        gm = new GM();
        mc = new MenuConst();
        ac = new ActionContainer();
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
        findViewById(R.id.mainview).invalidate();
    }




}

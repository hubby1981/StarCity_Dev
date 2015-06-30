package com.sim.star.bitworxx.starcity;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Bundle;

import com.sim.star.bitworxx.starcity.banking.BankingHelper;
import com.sim.star.bitworxx.starcity.constants.ColorSetter;
import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.constants.MenuBitmaps;
import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.constants.RBN;
import com.sim.star.bitworxx.starcity.constants.SqlTables;
import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.db.Meta;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;
import com.sim.star.bitworxx.starcity.meta.storages.BankStorageLoader;
import com.sim.star.bitworxx.starcity.player.PlayerStore;
import com.sim.star.bitworxx.starcity.statistics.properties.races.RaceRepoProperty;
import com.sim.star.bitworxx.starcity.views.touch.ActionContainer;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends Activity {

    public static Runnable Init;
    public static Runnable Loop;

    public Timer GeneralTimer;
    private GM gm;
    private MenuConst mc;
    private ActionContainer ac;
    private DB db;
    private Intent ResultIntent;
    private TaskStackBuilder Task;

        private BankingHelper bk;
    private PlayerStore pl;
    private int Count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gm = new GM();
        mc = new MenuConst();
        ac = new ActionContainer();
        db = new DB();
        db.setConnection(openOrCreateDatabase(DB.DB_NAME, MODE_PRIVATE, null));
       // db.Connection.execSQL("delete from "+ SqlTables.SQL_META_OBJECT);


        pl = new PlayerStore();
        bk=new BankingHelper();





        ResultIntent = this.getIntent();
        Task = TaskStackBuilder.create(this);
        Task.addNextIntent(ResultIntent);

        MetaObjectContainer ships = Meta.getContainer("starship");
        MetaObjectContainer destroyer = Meta.getContainer("starship","shiptype","DESTROYER");
        MetaObjectContainer explorer = Meta.getContainer("starship","shiptype","EXPLORER");



        MenuConst.BACK_SHADER = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.back_shader2), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_SUN01 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.sun_01), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_SUN02 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.sun_02), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        MenuConst.BACK_SHADER_PLANET01 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet1), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET02 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet2), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET03 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet3), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET04 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet4), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET05 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet5), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET06 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet6), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET07 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet7), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET08 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet1), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET09 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet14), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET10 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet10), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET11 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet11), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET12 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet12), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET13 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet13), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET14 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet14), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET15 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet15), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET16 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet16), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET17 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet17), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET18 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet18), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET19 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet19), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        MenuConst.BACK_SHADER_PLANET20 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.planet20), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        MenuConst.BACK_SHADER_MOON01 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.moon_01), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

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
        Loop= new Runnable() {
            @Override
            public void run() {/*
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(StarCityApp.getAppContext())
                                .setSmallIcon(R.drawable.ico)
                                .setContentTitle("Next loop")
                                .setContentText("A loop has ended you earned 2.3mcrd");
                mBuilder.setContentIntent(Task.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT));
                mNotificationManager.notify(0, mBuilder.build());*/
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
        }, 0, 10);
        return result;
    }




    public void update() {
       Count++;
        if(Count>155)
        {

            GM.animate();
            Count=0;
        }

        findViewById(R.id.imageView).invalidate();
    }








}

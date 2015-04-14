package com.sim.star.bitworxx.starcity.constants;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by WEIS on 14.04.2015.
 */
public class DB {

    public static String DB_NAME = "StarCityByBitworxx";


    public static SQLiteDatabase Connection;


    public static Cursor getQuery(String query, String[] args) {
        return DB.Connection.rawQuery(query, args);
    }
}

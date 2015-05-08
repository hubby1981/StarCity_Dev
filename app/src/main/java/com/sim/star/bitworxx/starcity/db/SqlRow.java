package com.sim.star.bitworxx.starcity.db;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 08.05.2015.
 */
public class SqlRow {

    private HashMap<String,String> Values;

    public SqlRow(Cursor cursor,ArrayList<String> columns)
    {
        Values=new HashMap<>();
        if(cursor!=null)
        {
            for(String s : columns)
            {
                int index = cursor.getColumnIndex(s);
                if(index>=0)
                    if(!Values.containsKey(s))
                        Values.put(s,cursor.getString(index));

            }
        }
    }

    public String get(String field)
    {
        return Values!=null?Values.containsKey(field)?Values.get(field):"":"";
    }
}

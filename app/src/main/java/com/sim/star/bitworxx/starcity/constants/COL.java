package com.sim.star.bitworxx.starcity.constants;

import com.sim.star.bitworxx.starcity.db.SF;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 08.05.2015.
 */
public class COL {

    public static String TEXT_COL ="text";
    public static HashMap<String,ArrayList<String>> COLUMNS;
    static
    {
        COLUMNS=new HashMap<>();

        COLUMNS.put(TEXT_COL,getTextCols());
    }

    public static ArrayList<String> getCol(String key)
    {
        return COLUMNS.containsKey(key)?COLUMNS.get(key):new ArrayList<String>();
    }


    public static ArrayList<String> getTextCols()
    {
        ArrayList<String> result=new ArrayList<>();
        result.add(SF.TEXT_KEY);
        result.add(SF.TEXT_LOCALE);
        result.add(SF.TEXT_SIZE);
        result.add(SF.TEXT_TEXT);

        return result;
    }
}

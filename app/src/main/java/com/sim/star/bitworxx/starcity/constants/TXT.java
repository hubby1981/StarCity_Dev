package com.sim.star.bitworxx.starcity.constants;

import android.content.ContentValues;
import android.hardware.Camera;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.db.SF;
import com.sim.star.bitworxx.starcity.db.SqlRow;
import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 16.04.2015.
 */
public class TXT {

    public static HashMap<String,TextDescription> ALL_TEXT;

    static{
        ALL_TEXT=new HashMap<String,TextDescription>(){

        };

        ArrayList<SqlRow> setup=DB.readFromTable(DB.SQL_SELECT_TEXT,COL.TEXT_COL);
        if(setup.size()==0)
            DB.writeToTable(SqlTables.SQL_TEXT,setup());


    }

    public static ArrayList<ContentValues> setup()
    {
        ArrayList<ContentValues> result=new ArrayList<>();
        result.add(getValuesFrom("en","header-main","M.A.P. System",TextSize.HEADER));
        result.add(getValuesFrom("en","header-systems","System Overview",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-system","System: ",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","page","Page",TextSize.TEXT));
        result.add(getValuesFrom("en","btn-system-add","ADD",TextSize.TEXT));
        result.add(getValuesFrom("en","btn-system-buy","buy",TextSize.TEXT));
        result.add(getValuesFrom("en","btn-system-generate","Build",TextSize.TEXT));
        result.add(getValuesFrom("en","header-main-functions","Functions",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-main-functions_desc","All Functions are designed for.",TextSize.TEXT));
        result.add(getValuesFrom("en","header-systems-table","Your Systems Overview",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_name","Name",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_sector","Sector",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_status","Status",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","rbn-use-action-1","use yellow",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-2","use green",TextSize.TEXT));



        return result;
    }

    private static ContentValues getValuesFrom(String locale,String key,String text,TextSize size)
    {
        ContentValues result = new ContentValues();

        result.put(SF.TEXT_LOCALE, locale);
        result.put(SF.TEXT_KEY, key);
        result.put(SF.TEXT_TEXT, text);
        result.put(SF.TEXT_SIZE, size.toString());
        return result;
    }

    private static String getSelect(String locale,String key)
    {
        return DB.SQL_SELECT_TEXT_SPECIAL.replace("["+SF.TEXT_LOCALE+"]",locale).replace("["+SF.TEXT_KEY+"]",key);
    }

    private static TextDescription getKey(String locale,String key)
    {
        if(ALL_TEXT.containsKey(locale+key))
            return ALL_TEXT.get(locale+key);

        ArrayList<SqlRow> rows=DB.readFromTable(getSelect(locale,key),COL.TEXT_COL);
        if(rows!=null&&rows.size()>0)
        {
            for(SqlRow r : rows)
            {
                if(!ALL_TEXT.containsKey(locale+key))
                {
                    ALL_TEXT.put(locale+key,new TextDescription(r.get(SF.TEXT_TEXT),TextSize.valueOf(r.get(SF.TEXT_SIZE))));
                }
            }
        }

        if(ALL_TEXT.containsKey(locale+key))
            return ALL_TEXT.get(locale+key);
        return null;
    }


    public static TextDescription get(String key)
    {
        String k1 = GM.LOCALE_A +key;
        String k2 = GM.LOCALE + key;

        TextDescription result=getKey(GM.LOCALE_A,key);
        if(result==null)
        {
            result=getKey(GM.LOCALE,key);
            if(result==null)
                result=new TextDescription(key,TextSize.TEXT);
        }

        return result;
    }
}

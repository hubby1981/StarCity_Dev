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
        callCleanText();
        ArrayList<SqlRow> setup=DB.readFromTable(DB.SQL_SELECT_TEXT,COL.TEXT_COL);
        if(setup.size()==0)
            DB.writeToTable(SqlTables.SQL_TEXT,setup());


    }

    public static void callCleanText()
    {
        DB.Connection.execSQL("DELETE FROM "+SqlTables.SQL_TEXT);

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
        result.add(getValuesFrom("en","btn-main-play","play",TextSize.TEXT));
        result.add(getValuesFrom("en","btn-main-new","new game",TextSize.TEXT));
        result.add(getValuesFrom("en","btn-main-options","options",TextSize.TEXT));

        result.add(getValuesFrom("en","btn-system-generate","Build",TextSize.TEXT));
        result.add(getValuesFrom("en","header-main-functions","Functions",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-main-functions_desc","All Functions are designed for.",TextSize.TEXT));
        result.add(getValuesFrom("en","header-systems-table","All Systems",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_name","Name",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_sector","Sector",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","header-systems-table_status","Status",TextSize.SUB_HEADER));
        result.add(getValuesFrom("en","rbn-use-action-1","use yellow",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-2","use green",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-3","use blue",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-4","use red",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-5","use orange",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-6","use violet",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-7","use aqua",TextSize.TEXT));
        result.add(getValuesFrom("en","rbn-use-action-8","use purple",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors","choose color",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-1","yellow",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-2","green",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-3","blue",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-4","red",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-5","orange",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-6","violet",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-7","aqua",TextSize.TEXT));
        result.add(getValuesFrom("en","cmb-colors-8","purple",TextSize.TEXT));


        result.add(getValuesFrom("en","key-0","0",TextSize.TEXT));
        result.add(getValuesFrom("en","key-1","1",TextSize.TEXT));
        result.add(getValuesFrom("en","key-2","2",TextSize.TEXT));
        result.add(getValuesFrom("en","key-3","3",TextSize.TEXT));
        result.add(getValuesFrom("en","key-4","4",TextSize.TEXT));
        result.add(getValuesFrom("en","key-5","5",TextSize.TEXT));
        result.add(getValuesFrom("en","key-6","6",TextSize.TEXT));
        result.add(getValuesFrom("en","key-7","7",TextSize.TEXT));
        result.add(getValuesFrom("en","key-8","8",TextSize.TEXT));
        result.add(getValuesFrom("en","key-9","9",TextSize.TEXT));

        result.add(getValuesFrom("en","key-Q","Q",TextSize.TEXT));
        result.add(getValuesFrom("en","key-W","W",TextSize.TEXT));
        result.add(getValuesFrom("en","key-E","E",TextSize.TEXT));
        result.add(getValuesFrom("en","key-R","R",TextSize.TEXT));
        result.add(getValuesFrom("en","key-T","T",TextSize.TEXT));
        result.add(getValuesFrom("en","key-Z","Z",TextSize.TEXT));
        result.add(getValuesFrom("en","key-U","U",TextSize.TEXT));
        result.add(getValuesFrom("en","key-I","I",TextSize.TEXT));
        result.add(getValuesFrom("en","key-O","O",TextSize.TEXT));
        result.add(getValuesFrom("en","key-P","P",TextSize.TEXT));

        result.add(getValuesFrom("en","key-A","A",TextSize.TEXT));
        result.add(getValuesFrom("en","key-S","S",TextSize.TEXT));
        result.add(getValuesFrom("en","key-D","D",TextSize.TEXT));
        result.add(getValuesFrom("en","key-F","F",TextSize.TEXT));
        result.add(getValuesFrom("en","key-G","G",TextSize.TEXT));
        result.add(getValuesFrom("en","key-H","H",TextSize.TEXT));
        result.add(getValuesFrom("en","key-J","J",TextSize.TEXT));
        result.add(getValuesFrom("en","key-K","K",TextSize.TEXT));
        result.add(getValuesFrom("en","key-L","L",TextSize.TEXT));

        result.add(getValuesFrom("en","key-_","_",TextSize.TEXT));
        result.add(getValuesFrom("en","key-Y","Y",TextSize.TEXT));
        result.add(getValuesFrom("en","key-X","X",TextSize.TEXT));
        result.add(getValuesFrom("en","key-C","C",TextSize.TEXT));
        result.add(getValuesFrom("en","key-V","V",TextSize.TEXT));
        result.add(getValuesFrom("en","key-B","B",TextSize.TEXT));
        result.add(getValuesFrom("en","key-N","N",TextSize.TEXT));
        result.add(getValuesFrom("en","key-M","M",TextSize.TEXT));
        result.add(getValuesFrom("en","key-<","DEL",TextSize.TEXT));
        result.add(getValuesFrom("en","key->","ESC",TextSize.TEXT));
        result.add(getValuesFrom("en","key-empty","SPC",TextSize.TEXT));

        result.add(getValuesFrom("en","key-@","@",TextSize.TEXT));
        result.add(getValuesFrom("en","key-.",".",TextSize.TEXT));
        result.add(getValuesFrom("en","key--","-",TextSize.TEXT));



        result.add(getValuesFrom("de","header-main","M.A.P. System",TextSize.HEADER));
        result.add(getValuesFrom("de","header-systems","System Uebersicht",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","header-system","System: ",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","page","Seite",TextSize.TEXT));
        result.add(getValuesFrom("de","btn-system-add","NEU",TextSize.TEXT));
        result.add(getValuesFrom("de","btn-system-buy","kaufen",TextSize.TEXT));
        result.add(getValuesFrom("de","btn-system-generate","Bauen",TextSize.TEXT));
        result.add(getValuesFrom("de","header-main-functions","Funktionen",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","header-main-functions_desc","Alle Funktionen wurden gestaltet.",TextSize.TEXT));
        result.add(getValuesFrom("de","header-systems-table","Alle Systeme",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","header-systems-table_name","Name",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","header-systems-table_sector","Sektor",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","header-systems-table_status","Status",TextSize.SUB_HEADER));
        result.add(getValuesFrom("de","rbn-use-action-1","nimm gelb",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-2","nimm gruen",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-3","nimm blau",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-4","nimm red",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-5","nimm orange",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-6","nimm violett",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-7","nimm aqua",TextSize.TEXT));
        result.add(getValuesFrom("de","rbn-use-action-8","nimm lila",TextSize.TEXT));


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

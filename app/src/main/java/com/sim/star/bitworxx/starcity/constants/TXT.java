package com.sim.star.bitworxx.starcity.constants;

import android.hardware.Camera;

import com.sim.star.bitworxx.starcity.game.enums.TextSize;
import com.sim.star.bitworxx.starcity.views.pages.TextDescription;

import java.util.HashMap;

/**
 * Created by WEIS on 16.04.2015.
 */
public class TXT {

    public static HashMap<String,TextDescription> ALL_TEXT;
    public static String LOCALE = "en-";
    public static String LOCALE_A = "en-";
    static{
        ALL_TEXT=new HashMap<String,TextDescription>(){

        };

        ALL_TEXT.put("en-header-main",new TextDescription("M.A.P. System", TextSize.HEADER));
        ALL_TEXT.put("de-header-main",new TextDescription("M.A.P. System", TextSize.HEADER));

        ALL_TEXT.put("en-header-systems",new TextDescription("System Overview", TextSize.HEADER));
        ALL_TEXT.put("de-header-systems",new TextDescription("System Übersicht", TextSize.HEADER));

        ALL_TEXT.put("en-page",new TextDescription("PAGE", TextSize.TEXT));
        ALL_TEXT.put("de-page",new TextDescription("Seite", TextSize.TEXT));

        ALL_TEXT.put("en-btn-system-add",new TextDescription("Add", TextSize.TEXT));
        ALL_TEXT.put("de-btn-system-add",new TextDescription("Neu", TextSize.TEXT));

        ALL_TEXT.put("en-header-main-functions",new TextDescription("Functions", TextSize.SUB_HEADER));
        ALL_TEXT.put("de-header-main-functions",new TextDescription("Funktionen", TextSize.SUB_HEADER));

        ALL_TEXT.put("en-header-main-functions_desc",new TextDescription("All Functions are designed for.", TextSize.TEXT));
        ALL_TEXT.put("de-header-main-functions_desc",new TextDescription("Alle Funktionen sind darauf ausgelegt.", TextSize.TEXT));

        ALL_TEXT.put("en-header-systems-table",new TextDescription("Your Systems Overview", TextSize.SUB_HEADER));
        ALL_TEXT.put("de-header-systems-table",new TextDescription("Deine System Übersicht", TextSize.SUB_HEADER));

        ALL_TEXT.put("en-header-systems-table_name",new TextDescription("Name", TextSize.TEXT));
        ALL_TEXT.put("en-header-systems-table_sector",new TextDescription("Sector", TextSize.TEXT));
        ALL_TEXT.put("en-header-systems-table_status",new TextDescription("Status", TextSize.TEXT));
    }


    public static TextDescription get(String key)
    {
        String k1 = LOCALE_A +key;
        String k2 = LOCALE + key;

        return ALL_TEXT.containsKey(k1)?ALL_TEXT.get(k1):ALL_TEXT.containsKey(k2)?ALL_TEXT.get(k2):new TextDescription(key,TextSize.TEXT);
    }
}

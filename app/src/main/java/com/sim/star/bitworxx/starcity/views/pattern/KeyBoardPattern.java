package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.constants.CMB;
import com.sim.star.bitworxx.starcity.constants.KEY;
import com.sim.star.bitworxx.starcity.game.enums.ContentType;
import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

import java.util.ArrayList;

/**
 * Created by WEIS on 21.05.2015.
 */
public class KeyBoardPattern extends CoPoPattern {
    public String Key;
    protected KeyBoardPattern(CoPo p,String key) {
        super(p);
        Key=key;
    }


    @Override
    public ArrayList<PatternBase> getHiddenPatterns()
    {
        ArrayList<PatternBase> result=new ArrayList<>();
        CoPo p = P;


        boolean u = KEY.getKey(Key);
        if(u) {
            StackingPattern st = new StackingPattern(1,1, 1, 1, new CoPo(p.L , p.T+1,p.L + 21,p.T+8));
            result.add(st);
            st.register(new ContentDescription("key-0", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-1", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-2", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-3", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-4", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-5", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-6", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-7", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-8", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-9", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-@", ContentType.BUTTON_HIDDEN));

            st.register(new ContentDescription("key-Q", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-W", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-E", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-R", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-T", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-Z", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-U", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-I", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-O", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-P", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-.", ContentType.BUTTON_HIDDEN));

            st.register(new ContentDescription("key-A", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-S", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-D", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-F", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-G", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-H", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-J", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-K", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-L", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-_", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key--", ContentType.BUTTON_HIDDEN));


            st.register(new ContentDescription("key-empty", ContentType.BUTTON_HIDDEN));

            st.register(new ContentDescription("key-Y", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-X", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-C", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-V", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-B", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-N", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-M", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key-<", ContentType.BUTTON_HIDDEN));
            st.register(new ContentDescription("key->", ContentType.BUTTON_HIDDEN));


        }
        return result;
    }
}

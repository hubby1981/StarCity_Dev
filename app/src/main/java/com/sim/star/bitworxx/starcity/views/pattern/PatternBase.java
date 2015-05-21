package com.sim.star.bitworxx.starcity.views.pattern;

import com.sim.star.bitworxx.starcity.geometric.CoPo;
import com.sim.star.bitworxx.starcity.views.pages.Content;
import com.sim.star.bitworxx.starcity.views.pages.ContentDescription;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WEIS on 16.04.2015.
 */
public abstract class PatternBase {

    public ArrayList<ContentDescription> Contents;
    public ArrayList<PatternBase> Patterns;


    public PatternBase()
    {
        Contents=new ArrayList<>();Patterns=new ArrayList<>();

    }

    public ArrayList<Content> build()
    {
        ArrayList<Content> contents = new ArrayList<>();
        if(Contents!=null){
        for(ContentDescription cd :Contents)
        {
            Content c = cd.build();
            if(c!=null)
                contents.add(c);
        }}
        if(Patterns!=null)
            for(PatternBase p : Patterns)
            {
                for(Content c : p.build())
                {
                    contents.add(c);
                }
            }


            for(ContentDescription cd :getHidden())
            {
                Content c = cd.build();
                if(c!=null)
                    contents.add(c);
            }

            for(PatternBase p : getHiddenPatterns())
            {
                for(Content c : p.build())
                {
                    contents.add(c);
                }
            }

        return contents;
    }

    public  ArrayList<ContentDescription> getHidden()
    {
        return new ArrayList<>();
    }
    public  ArrayList<PatternBase> getHiddenPatterns()
    {
        return new ArrayList<>();
    }

}

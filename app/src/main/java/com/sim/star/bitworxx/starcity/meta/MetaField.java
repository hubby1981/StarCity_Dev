package com.sim.star.bitworxx.starcity.meta;

import com.sim.star.bitworxx.starcity.game.enums.MetaFieldUsage;

/**
 * Created by WEIS on 14.04.2015.
 */
public class MetaField {
    public String Value="";
    public float InternalValue=0;

    public MetaField(String value,float internalValue){
        Value = value;
        InternalValue = internalValue;
    }
    public MetaField(String value){
        Value = value;
    }
    public MetaField()
    {
        
    }
}

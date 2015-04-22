package com.sim.star.bitworxx.starcity.meta.game.interfaces;

/**
 * Created by WEIS on 22.04.2015.
 */
public interface IMetaObject {

    String getId();
    String getName();
    String getValue(String field);
    float  getInternalValue(String field);
}

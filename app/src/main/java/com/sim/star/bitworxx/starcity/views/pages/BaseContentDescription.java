package com.sim.star.bitworxx.starcity.views.pages;

import java.util.ArrayList;

/**
 * Created by WEIS on 17.04.2015.
 */
public abstract class BaseContentDescription<T> {

    public abstract boolean hasChilds();
    public abstract ArrayList<T> getChilds();
}

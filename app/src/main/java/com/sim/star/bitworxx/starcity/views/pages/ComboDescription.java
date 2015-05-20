package com.sim.star.bitworxx.starcity.views.pages;

/**
 * Created by WEIS on 20.05.2015.
 */
public class ComboDescription extends CheckboxDescription {



    public ComboDescription(Runnable actrion) {
        super(actrion);
    }

    public ComboDescription(Runnable actrion, boolean searchText) {
        super(actrion, searchText);
    }

    public ComboDescription(TextDescription text, Runnable action) {
        super(text, action);
    }
}

package com.sim.star.bitworxx.starcity.views.pages;

/**
 * Created by WEIS on 21.04.2015.
 */
public class RadioboxDescription extends CheckboxDescription {

    public RadioboxDescription(Runnable actrion) {
        super(actrion);
    }

    public RadioboxDescription(Runnable actrion, boolean searchText) {
        super(actrion, searchText);
    }

    public RadioboxDescription(TextDescription text, Runnable action) {
        super(text, action);

    }
}

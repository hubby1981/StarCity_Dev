package com.sim.star.bitworxx.starcity.views.pages;

/**
 * Created by WEIS on 21.05.2015.
 */
public class TextBoxDescription extends CheckboxDescription {

    public int Size=5;
    public String Text="";

    public TextBoxDescription(Runnable actrion) {
        super(actrion);
    }

    public TextBoxDescription(Runnable actrion, boolean searchText) {
        super(actrion, searchText);
    }

    public TextBoxDescription(TextDescription text, Runnable action) {
        super(text, action);
    }
}

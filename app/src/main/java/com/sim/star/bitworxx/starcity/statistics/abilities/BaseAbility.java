package com.sim.star.bitworxx.starcity.statistics.abilities;


import java.util.ArrayList;

/**
 * Created by WEIS on 30.06.2015.
 */
public abstract class BaseAbility {

    public abstract AbilitiesEnum getAbility();

    public abstract ArrayList<AbilitiesEnum> getAllPossible();

    public boolean canUseAbility(AbilitiesEnum ability)
    {
        return getAllPossible().contains(ability);
    }
}

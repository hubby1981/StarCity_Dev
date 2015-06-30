package com.sim.star.bitworxx.starcity.statistics.abilities;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.06.2015.
 */
public class Pirate extends BaseAbility {
    @Override
    public AbilitiesEnum getAbility() {
        return AbilitiesEnum.Pirate;
    }

    @Override
    public ArrayList<AbilitiesEnum> getAllPossible() {
        ArrayList<AbilitiesEnum> result = new ArrayList<>();
        result.add(AbilitiesEnum.Spaceman);
        result.add(AbilitiesEnum.Miner);
        result.add(AbilitiesEnum.Trader);
        result.add(AbilitiesEnum.Soldier);
        result.add(AbilitiesEnum.Settler);



        return result;
    }
}

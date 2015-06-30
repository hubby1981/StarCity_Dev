package com.sim.star.bitworxx.starcity.statistics.abilities;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.06.2015.
 */
public class Settler extends  BaseAbility {

    @Override
    public AbilitiesEnum getAbility() {
        return AbilitiesEnum.Settler;
    }

    @Override
    public ArrayList<AbilitiesEnum> getAllPossible() {
        ArrayList<AbilitiesEnum> result = new ArrayList<>();
        result.add(AbilitiesEnum.Spaceman);
        result.add(AbilitiesEnum.Miner);
        result.add(AbilitiesEnum.Pirate);
        result.add(AbilitiesEnum.Soldier);
        result.add(AbilitiesEnum.Diplomat);
        result.add(AbilitiesEnum.Trader);



        return result;
    }
}

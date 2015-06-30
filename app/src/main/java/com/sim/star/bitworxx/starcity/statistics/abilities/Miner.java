package com.sim.star.bitworxx.starcity.statistics.abilities;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.06.2015.
 */
public class Miner extends BaseAbility {
    @Override
    public AbilitiesEnum getAbility() {
        return AbilitiesEnum.Miner;
    }

    @Override
    public ArrayList<AbilitiesEnum> getAllPossible() {
        ArrayList<AbilitiesEnum> result = new ArrayList<>();
        result.add(AbilitiesEnum.Spaceman);
        result.add(AbilitiesEnum.Trader);
        result.add(AbilitiesEnum.Pirate);

        result.add(AbilitiesEnum.Settler);



        return result;
    }
}

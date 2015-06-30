package com.sim.star.bitworxx.starcity.statistics.abilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WEIS on 30.06.2015.
 */
public class Trader extends BaseAbility {


    @Override
    public AbilitiesEnum getAbility() {
        return AbilitiesEnum.Trader;
    }

    @Override
    public ArrayList<AbilitiesEnum> getAllPossible() {
        ArrayList<AbilitiesEnum> result = new ArrayList<>();
        result.add(AbilitiesEnum.Spaceman);
        result.add(AbilitiesEnum.Miner);
        result.add(AbilitiesEnum.Pirate);
        result.add(AbilitiesEnum.Soldier);
        result.add(AbilitiesEnum.Diplomat);
        result.add(AbilitiesEnum.Settler);



        return result;
    }
}

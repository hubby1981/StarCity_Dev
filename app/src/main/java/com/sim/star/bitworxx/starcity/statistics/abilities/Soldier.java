package com.sim.star.bitworxx.starcity.statistics.abilities;

import java.util.ArrayList;

/**
 * Created by WEIS on 30.06.2015.
 */
public class Soldier extends BaseAbility {
    @Override
    public AbilitiesEnum getAbility() {
        return AbilitiesEnum.Soldier;
    }

    @Override
    public ArrayList<AbilitiesEnum> getAllPossible() {
        ArrayList<AbilitiesEnum> result = new ArrayList<>();
        result.add(AbilitiesEnum.Trader);
        result.add(AbilitiesEnum.Spaceman);
        result.add(AbilitiesEnum.Pirate);
        result.add(AbilitiesEnum.Soldier);
        result.add(AbilitiesEnum.Diplomat);
        result.add(AbilitiesEnum.Settler);



        return result;
    }
}

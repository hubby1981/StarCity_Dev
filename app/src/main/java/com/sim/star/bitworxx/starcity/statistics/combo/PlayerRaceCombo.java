package com.sim.star.bitworxx.starcity.statistics.combo;

import com.sim.star.bitworxx.starcity.statistics.properties.BasePropertyAbility;
import com.sim.star.bitworxx.starcity.statistics.properties.BasePropertyRace;
import com.sim.star.bitworxx.starcity.statistics.properties.PropertiesEnum;

/**
 * Created by WEIS on 30.06.2015.
 */
public class PlayerRaceCombo {

    private BasePropertyAbility FirstAbility;
    private BasePropertyAbility SecondAbility;
    private BasePropertyRace RaceProperty;

    public PlayerRaceCombo(BasePropertyAbility firstAbility,BasePropertyAbility secondAbility,BasePropertyRace raceProperty)
    {
        FirstAbility = firstAbility;
        SecondAbility = secondAbility;
        RaceProperty = raceProperty;
    }


    public int getComboCount(PropertiesEnum property)
    {
        return RaceProperty.getProperty(property)+FirstAbility.getProperty(property)+SecondAbility.getProperty(property);
    }

    private int getHalf(int value)
    {
        return value>1?value/2:1;
    }
}

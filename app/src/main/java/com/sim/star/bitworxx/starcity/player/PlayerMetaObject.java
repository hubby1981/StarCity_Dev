package com.sim.star.bitworxx.starcity.player;

import com.sim.star.bitworxx.starcity.game.enums.RaceEnum;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.statistics.abilities.AbilitiesEnum;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

/**
 * Created by WEIS on 29.04.2015.
 */
public class PlayerMetaObject extends MetaObject {
    public PlayerMetaObject() {
        super("player");
    }

    public PlayerMetaObject(String name)
    {
        super(name);
    }

    @Override
    public void create()
    {
        super.create();


        setId(UUID.randomUUID().toString().replace("-", ""));
        setName(PlayerStore.LAST_NAME);
        setRace(PlayerStore.LAST_RACE);
        setLastPlayed(new Date());
    }


    public RaceEnum getRace()
    {
        return RaceEnum.valueOf(getValue(F.FIELD_PLAYER_RACE));
    }

    public void setRace(RaceEnum race)
    {
        setFieldValue(F.FIELD_PLAYER_RACE, race.toString());
    }


    public AbilitiesEnum getRaceAbyFirst()
    {
        return AbilitiesEnum.valueOf(getValue(F.FIELD_PLAYER_ABILITY_FIRST));
    }

    public void setRaceAbyFirst(AbilitiesEnum ability)
    {
        setFieldValue(F.FIELD_PLAYER_ABILITY_FIRST,ability.toString());
    }

    public AbilitiesEnum getRaceAbySecond()
    {
        return AbilitiesEnum.valueOf(getValue(F.FIELD_PLAYER_ABILITY_SECOND));
    }

    public void setRaceAbySecond(AbilitiesEnum ability)
    {
        setFieldValue(F.FIELD_PLAYER_ABILITY_SECOND,ability.toString());
    }

    public Date getLastPlayed()
    {
        try{

            return new Date((long)getInternalValue(F.FIELD_PLAYER_LAST_PLAYED));

        }catch(Exception e){return new Date();}
    }

    public void setLastPlayed(Date date)
    {
        setFieldInternalValue(F.FIELD_PLAYER_LAST_PLAYED,date.getTime());
    }


}

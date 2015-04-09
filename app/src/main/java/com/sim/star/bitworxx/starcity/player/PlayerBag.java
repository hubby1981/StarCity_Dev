package com.sim.star.bitworxx.starcity.player;

import com.sim.star.bitworxx.starcity.game.enums.RaceEnum;

import java.util.Date;
import java.util.UUID;

/**
 * Created by WEIS on 09.04.2015.
 */
public class PlayerBag {

    public String PlayerName;
    public String PlayerToken;
    public Date LastPlayed;
    public RaceEnum PlayerRace;

    public static PlayerBag create_bag(String name, RaceEnum race) {
        PlayerBag bag = new PlayerBag();
        bag.LastPlayed = new Date();
        bag.PlayerToken = UUID.randomUUID().toString().replace("-", "");
        bag.PlayerName = name;
        bag.PlayerRace = race;
        return bag;
    }
}

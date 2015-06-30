package com.sim.star.bitworxx.starcity.statistics.properties.abilities;



/**
 * Created by WEIS on 30.06.2015.
 */
public class AbilityRepoProperty {
    public static int getTraderCount()
    {
        return new TraderProperty().getAllCount();
    }

    public static int getSpacemanCount()
    {
        return new SpacemanProperty().getAllCount();
    }

    public static int getMinerCount()
    {
        return new MinerProperty().getAllCount();
    }

    public static int getPirateCount()
    {
        return new PirateProperty().getAllCount();
    }

    public static int getSoldierCount()
    {
        return new SoldierProperty().getAllCount();
    }

    public static int getDiplomatCount()
    {
        return new DiplomatProperty().getAllCount();
    }

    public static int getSettlerCount()
    {
        return new SettlerProperty().getAllCount();
    }

    public static String getAllAsStringCount()
    {
        return "Trader: "+getTraderCount()+"\r\nSpaceman: "+getSpacemanCount()
                +"\r\nMiner: "+getMinerCount()+"\r\nPirate: "+getPirateCount()
                +"\r\nSoldier: "+getSoldierCount()+"\r\nDiplomat: "+getDiplomatCount()+"\r\nSettler: "+getSettlerCount();
    }
}

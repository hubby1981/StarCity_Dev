package com.sim.star.bitworxx.starcity.statistics.properties.races;

/**
 * Created by WEIS on 30.06.2015.
 */
public class RaceRepoProperty {


    public static int getHumanCount()
    {
        return new HumanProperty().getAllCount();
    }

    public static int getInsectCount()
    {
        return new InsectProperty().getAllCount();
    }

    public static int getPlantCount()
    {
        return new PlantProperty().getAllCount();
    }

    public static int getOctopodCount()
    {
        return new OctopodProperty().getAllCount();
    }

    public static int getReptileCount()
    {
        return new ReptileProperty().getAllCount();
    }

    public static int getTechnoCount()
    {
        return new TechnoProperty().getAllCount();
    }

    public static int getSingularityCount()
    {
        return new SingularityProperty().getAllCount();
    }

    public static String getAllAsStringCount()
    {
        return "Human: "+getHumanCount()+"\r\nInsect: "+getInsectCount()
                +"\r\nPlant: "+getPlantCount()+"\r\nOctopod: "+getOctopodCount()
                +"\r\nReptile: "+getReptileCount()+"\r\nTechno: "+getTechnoCount()+"\r\nSingularity: "+getSingularityCount();
    }
}

package com.sim.star.bitworxx.starcity.statistics.properties;

/**
 * Created by WEIS on 30.06.2015.
 */
public abstract class BasePropertyRace {
    public abstract int getPropertyValue_attack();
    public abstract int getPropertyValue_defense();
    public abstract int getPropertyValue_trading();
    public abstract int getPropertyValue_reduction();
    public abstract int getPropertyValue_growing();
    public abstract int getPropertyValue_colonization();
    public abstract int getPropertyValue_danger();
    public abstract int getPropertyValue_morality();
    public abstract int getPropertyValue_strength();
    public abstract int getPropertyValue_live();
    public abstract int getPropertyValue_population();
    public abstract int getPropertyValue_flee();
    public abstract int getPropertyValue_progress();
    public abstract int getPropertyValue_innovation();
    public abstract int getPropertyValue_willpower();
    public abstract int getPropertyValue_psi();
    public abstract int getPropertyValue_abandonment();
    public abstract int getPropertyValue_fail();
    public abstract int getPropertyValue_bounty();
    public abstract int getPropertyValue_price();
    public abstract int getPropertyValue_power();
    public abstract int getPropertyValue_losses();
    public abstract int getPropertyValue_locate();
    public abstract int getPropertyValue_skill();
    public abstract int getPropertyValue_planning();



    public int getAllCount()
    {
        return
                getPropertyValue_attack()+
                getPropertyValue_defense()+
                getPropertyValue_trading()+
                getPropertyValue_reduction()+
                getPropertyValue_growing()+
                getPropertyValue_colonization()+
                getPropertyValue_danger()+
                getPropertyValue_morality()+
                getPropertyValue_strength()+
                getPropertyValue_live()+
                getPropertyValue_population()+
                getPropertyValue_flee()+
                getPropertyValue_progress()+
                getPropertyValue_innovation()+
                getPropertyValue_willpower()+
                getPropertyValue_psi()+
                getPropertyValue_abandonment()+
                getPropertyValue_fail()+
                getPropertyValue_bounty()+
                getPropertyValue_price()+
                getPropertyValue_power()+
                getPropertyValue_losses()+
                getPropertyValue_locate()+
                getPropertyValue_skill()+
                getPropertyValue_planning();
    }


    public int getProperty(PropertiesEnum property)
    {
        if(property==PropertiesEnum.attack)
            return getPropertyValue_attack();
        if(property==PropertiesEnum.defense)
            return getPropertyValue_defense();
        if(property==PropertiesEnum.trading)
            return getPropertyValue_trading();
        if(property==PropertiesEnum.reduction)
            return getPropertyValue_reduction();
        if(property==PropertiesEnum.growing)
            return getPropertyValue_growing();
        if(property==PropertiesEnum.colonization)
            return getPropertyValue_colonization();
        if(property==PropertiesEnum.danger)
            return getPropertyValue_danger();
        if(property==PropertiesEnum.morality)
            return getPropertyValue_morality();
        if(property==PropertiesEnum.strength)
            return getPropertyValue_strength();
        if(property==PropertiesEnum.live)
            return getPropertyValue_live();
        if(property==PropertiesEnum.population)
            return getPropertyValue_population();
        if(property==PropertiesEnum.flee)
            return getPropertyValue_flee();
        if(property==PropertiesEnum.progress)
            return getPropertyValue_progress();
        if(property==PropertiesEnum.innovation)
            return getPropertyValue_innovation();
        if(property==PropertiesEnum.willpower)
            return getPropertyValue_willpower();
        if(property==PropertiesEnum.psi)
            return getPropertyValue_psi();
        if(property==PropertiesEnum.abandonment)
            return getPropertyValue_abandonment();
        if(property==PropertiesEnum.fail)
            return getPropertyValue_fail();
        if(property==PropertiesEnum.bounty)
            return getPropertyValue_bounty();
        if(property==PropertiesEnum.price)
            return getPropertyValue_price();
        if(property==PropertiesEnum.power)
            return getPropertyValue_power();
        if(property==PropertiesEnum.losses)
            return getPropertyValue_losses();
        if(property==PropertiesEnum.locate)
            return getPropertyValue_locate();
        if(property==PropertiesEnum.skill)
            return getPropertyValue_skill();
        if(property==PropertiesEnum.planning)
            return getPropertyValue_planning();
        return 0;
    }
}

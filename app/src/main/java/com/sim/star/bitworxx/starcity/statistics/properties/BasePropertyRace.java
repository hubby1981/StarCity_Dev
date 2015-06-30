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
}
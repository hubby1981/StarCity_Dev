package com.sim.star.bitworxx.starcity.player;

import com.sim.star.bitworxx.starcity.banking.BankMetaObject;
import com.sim.star.bitworxx.starcity.banking.BankingHelper;
import com.sim.star.bitworxx.starcity.constants.DB;
import com.sim.star.bitworxx.starcity.game.enums.RaceEnum;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;

/**
 * Created by WEIS on 29.04.2015.
 */
public class PlayerStore {

    public static RaceEnum LAST_RACE =RaceEnum.MustSelect;
    public static String LAST_NAME="MUST_SET";
    public static PlayerMetaObject LAST_PLAYER;

    static{
        LAST_PLAYER = getPlayer();

    }


    public static BankMetaObject getPlayerBank()
    {
        return BankingHelper.getBank(LAST_PLAYER.getId());
    }


    public static PlayerMetaObject getPlayer()
    {
        PlayerMetaObject result=null;
        PlayerMetaContainer player = new PlayerMetaContainer("player");
        if(player!=null)
        {
            DB.fillContainer(player);
            if(player.Objects.size()==0)
            {
                result=new PlayerMetaObject();
                result.create();
                DB.addMetaObject(result);
            }
            else
            {
                result=player.getFirst();
            }
        }
        return result;
    }
}

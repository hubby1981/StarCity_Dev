package com.sim.star.bitworxx.starcity.stellar.planet;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.sim.star.bitworxx.starcity.constants.MenuConst;
import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.stellar.elements.BaseElements;
import com.sim.star.bitworxx.starcity.stellar.elements.NobleGas;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetAtmosphere;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetCore;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetSurface;

/**
 * Created by WEIS on 28.04.2015.
 */
public class GasPlanet extends BasePlanet {

    private static int MAX=15;

    public GasPlanet()
    {
        super();
    }

    public GasPlanet(MetaObject data)
    {
        super(data);
    }

    @Override
    protected void createCore() {
        setCoreType(RandomRange.getRandom(1,10)>=5?PlanetCore.ROCK:PlanetCore.METAL);
    }

    @Override
    protected void createAtmosphere() {
        setAtmosphereType(PlanetAtmosphere.GAS);
    }

    @Override
    protected void createSurface() {
        setSurfaceType(PlanetSurface.GAS);
    }



    @Override
    protected void createSize() {

        setSize(PlanetConst.getGasPlanetSize());
    }

    @Override
    protected void createGasAtmosphere() {

        setAtmosphereGasSystem( RandomRange.getRandom(1,30));
        float all = 100;
        float main = 0;
        float subFirst=0;

        BaseElements mainGas = PlanetConst.getMainGasPlanetRandom();
        NobleGas subFirstGas = PlanetConst.getSubFirstGasPlanetRandom();
        NobleGas subSecondGas = PlanetConst.getSubSecondGasPlanetRandom();

        main = PlanetConst.getBaseElementSize(mainGas);
        float rest = all-main;

        setAtmosphereGasMain(mainGas);
        setAtmosphereGasMainInternal(main);
        setAtmosphereGasSubFirst(subFirstGas);
        setAtmosphereGasSubFirstInternal(rest);
        if(getAtmosphereGasSystem()>MAX)
        {

            float rest1 = (rest /100)*RandomRange.getFloat(PlanetConst.MIN_SUB_SECOND,PlanetConst.MAX_SUB_SECOND);
            setAtmosphereGasSubSecond(subSecondGas);
            setAtmosphereGasSubSecondInternal(rest1);
        }
    }

    @Override
    protected void createSubClass() {
            setSubClass("gas");
    }
}

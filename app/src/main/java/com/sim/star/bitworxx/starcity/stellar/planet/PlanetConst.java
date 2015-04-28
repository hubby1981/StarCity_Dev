package com.sim.star.bitworxx.starcity.stellar.planet;

import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.stellar.elements.BaseElements;
import com.sim.star.bitworxx.starcity.stellar.elements.NobleGas;

/**
 * Created by WEIS on 28.04.2015.
 */
public class PlanetConst {

    public static float MAX_HYDROGEN = (float)89.9;
    public static float MIN_HYDROGEN = (float)31.1;


    public static float MAX_OXYGEN = (float)30.1;
    public static float MIN_OXYGEN = (float)4.4;

    public static float MAX_CARBON = (float)50.1;
    public static float MIN_CARBON = (float)22.1;

    public static float MAX_SILICON = (float)99.9;
    public static float MIN_SILICON = (float)1.1;

    public static float MAX_NITROGEN = (float)10.1;
    public static float MIN_NITROGEN = (float)1.1;


    public static float MIN_SUB_SECOND = (float)10.1;
    public static float MAX_SUB_SECOND= (float)20.1;
    
    public static int ALPHA=200;

    public static float getSolidLiquidPlanetSize()
    {
        return RandomRange.getFloat((float)1.9,(float)3.1);
    }

    public static float getSolidPlanetSize()
    {
        return RandomRange.getFloat((float)1.3,(float)4.1);
    }

    public static float getGasPlanetSize()
    {
        return RandomRange.getFloat((float)2,(float)4.1);
    }

    public static float getLiquidPlanetSize()
    {
        return RandomRange.getFloat((float)3,(float)4);
    }

    public static BaseElements getMainGasPlanetRandom()
    {
        int random = RandomRange.getRandom(1,20);
        if(random <12)
        {
            return BaseElements.HYDROGEN;
        }
        else if(random<15)
        {
            return BaseElements.NITROGEN;

        }
        else if(random<18)
        {
            return BaseElements.CARBON;

        }
        else
        {
            return BaseElements.OXYGEN;

        }
    }
    public static NobleGas getSubFirstGasPlanetRandom()
    {
        int random = RandomRange.getRandom(1,20);
        if(random <12)
        {
            return NobleGas.HELIUM;
        }
        else if(random<15)
        {
            return NobleGas.NEON;

        }
        else if(random<17)
        {
            return NobleGas.ARGON;

        }
        else if(random<19)
        {
            return NobleGas.KRYPTON;

        }
        else
        {
            return NobleGas.XENON;

        }
    }
    public static NobleGas getSubSecondGasPlanetRandom()
    {
        int random = RandomRange.getRandom(1,20);
        if(random <12)
        {
            return NobleGas.XENON;
        }
        else if(random<15)
        {
            return NobleGas.ARGON;

        }
        else if(random<17)
        {
            return NobleGas.KRYPTON;

        }
        else if(random<19)
        {
            return NobleGas.NEON;

        }
        else
        {
            return NobleGas.HELIUM;

        }
    }


    public static float getBaseElementSize(BaseElements element) {
        if (element == BaseElements.HYDROGEN) {
            return RandomRange.getFloat(MIN_HYDROGEN,MAX_HYDROGEN);
        }
        if (element == BaseElements.OXYGEN) {
            return RandomRange.getFloat(MIN_OXYGEN,MAX_OXYGEN);
        }
        if (element == BaseElements.CARBON) {
            return RandomRange.getFloat(MIN_CARBON,MAX_CARBON);
        }
        if (element == BaseElements.SILICON) {
            return RandomRange.getFloat(MIN_SILICON,MAX_SILICON);
        }
        if (element == BaseElements.NITROGEN) {
            return RandomRange.getFloat(MIN_NITROGEN,MAX_NITROGEN);
        }
        return RandomRange.getFloat(1,99);

    }



    public static int getHeliumShader()
    {
        return Color.argb(ALPHA,251,0,0);
    }
    public static int getNeonShader()
    {
        return Color.argb(ALPHA,194,22,0);
    }
    public static int getArgonShader()
    {
        return Color.argb(ALPHA,123,34,158);
    }
    public static int getKryptonShader()
    {
        return Color.argb(ALPHA,9,91,132);
    }
    public static int getXenonShader()
    {
        return  Color.argb(ALPHA,121,89,136);
    }

    public static int getHydrogenShader()
    {
        return Color.argb(ALPHA,191,239,255);
    }

    public static int getOxygenShader()
    {
        return Color.argb(ALPHA,200,200,255);
    }

    public static int getCarbonShader()
    {
        return Color.argb(ALPHA,224,181,152);
    }

    public static int getSiliconShader()
    {
        return Color.argb(ALPHA,107,107,107);
    }

    public static int getNitrogenShader()
    {
        return Color.argb(ALPHA,160,24,160);
    }

    public static int getEnergyShader()
    {
        return Color.argb(ALPHA,135,205,255);
    }


    public static int getRadialBaseElement(BaseElements element)
    {
        if(element==BaseElements.HYDROGEN)return getHydrogenShader();
        if(element==BaseElements.NITROGEN)return getHydrogenShader();

        if(element==BaseElements.CARBON)return getCarbonShader();
        if(element==BaseElements.SILICON)return getSiliconShader();
        if(element==BaseElements.ENERGY)return getEnergyShader();
        return getOxygenShader();
    }

    public static int getRadialNobleElement(NobleGas element)
    {
        if(element==NobleGas.NEON)return getNeonShader();
        if(element==NobleGas.ARGON)return getArgonShader();

        if(element==NobleGas.KRYPTON)return getKryptonShader();
        if(element==NobleGas.XENON)return getXenonShader();

        return getHeliumShader();
    }
}

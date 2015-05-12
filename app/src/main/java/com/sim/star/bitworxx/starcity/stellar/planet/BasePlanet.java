package com.sim.star.bitworxx.starcity.stellar.planet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.sim.star.bitworxx.starcity.db.RandomRange;
import com.sim.star.bitworxx.starcity.helper.BitmapHelper;
import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.fields.F;
import com.sim.star.bitworxx.starcity.meta.game.GalaxySystemObjectMetaObject;
import com.sim.star.bitworxx.starcity.stellar.elements.BaseElements;
import com.sim.star.bitworxx.starcity.stellar.elements.NobleGas;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetAtmosphere;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetCore;
import com.sim.star.bitworxx.starcity.stellar.elements.PlanetSurface;

import java.nio.ByteBuffer;
import java.util.Date;

/**
 * Created by WEIS on 28.04.2015.
 */
public abstract class BasePlanet {
    public MetaObject Data;

    public BasePlanet(MetaObject data)
    {
        Data=data;
    }

    public BasePlanet()
    {
       create();
    }

    protected void create()
    {
        Data = new GalaxySystemObjectMetaObject();
        Data.create();
        createFields();

    }

    protected void createFields(){

        Data.Fields.register(F.FIELD_PLANET_TYPE, new MetaField("planet"));
        Data.Fields.register(F.FIELD_PLANET_SUBCLASS, new MetaField("solid"));

        Data.Fields.register(F.FIELD_PLANET_CORE_TYPE,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_SURFACE_TYPE,new MetaField());

        Data.Fields.register(F.FIELD_PLANET_ATMOSPHERE_TYPE,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_ATMOSPHERE_GAS0,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_ATMOSPHERE_GAS1,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_ATMOSPHERE_GAS2,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_ATMOSPHERE_GAS3,new MetaField());

        Data.Fields.register(F.FIELD_PLANET_SIZE,new MetaField());
        Data.Fields.register(F.FIELD_PLANET_SHADER,new MetaField("", RandomRange.getRandom(1,20)));

        createSubClass();
        createSize();
        createCore();
        createAtmosphere();
        createGasAtmosphere();
        createSurface();

    }

    protected abstract void createCore();
    protected abstract void createAtmosphere();
    protected abstract void createSurface();

    protected abstract void createSize();
    protected abstract void createGasAtmosphere();
    protected abstract void createSubClass();

    public PlanetCore getCoreType()
    {
        return PlanetCore.valueOf(Data.getValue("core_type"));
    }

    public void setCoreType(PlanetCore coreType)
    {
        Data.setFieldValue(F.FIELD_PLANET_CORE_TYPE,coreType.toString());
    }

    public PlanetSurface getSurfaceType()
    {
        return PlanetSurface.valueOf(Data.getValue(F.FIELD_PLANET_SURFACE_TYPE));
    }

    public void setSurfaceType(PlanetSurface surfaceType)
    {
        Data.setFieldValue(F.FIELD_PLANET_SURFACE_TYPE,surfaceType.toString());
    }

    public PlanetAtmosphere getAtmosphereType()
    {
        return PlanetAtmosphere.valueOf(Data.getValue(F.FIELD_PLANET_ATMOSPHERE_TYPE));
    }

    public void setAtmosphereType(PlanetAtmosphere atmosphereType)
    {
        Data.setFieldValue(F.FIELD_PLANET_ATMOSPHERE_TYPE,atmosphereType.toString());
    }

    public float getSize()
    {
        return Data.getInternalValue(F.FIELD_PLANET_SIZE);
    }

    public void setSize(float size)
    {
        Data.setFieldInternalValue(F.FIELD_PLANET_SIZE,size);
    }

    public float getAtmosphereGasSystem()
    {
        return Data.getInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS0);
    }
    public void setAtmosphereGasSystem(float gas)
    {
        Data.setFieldInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS0,gas);

    }

    public BaseElements getAtmosphereGasMain()
    {
        String value = Data.getValue(F.FIELD_PLANET_ATMOSPHERE_GAS1);
        try{ BaseElements.valueOf(value);}catch(Exception e){};
        return BaseElements.valueOf(value);
    }
    public void setAtmosphereGasMain(BaseElements gas)
    {
        Data.setFieldValue(F.FIELD_PLANET_ATMOSPHERE_GAS1, gas.toString());

    }

    public float getAtmosphereGasMainInternal()
    {
        return Data.getInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS1);
    }
    public void setAtmosphereGasMainInternal(float gas)
    {
        Data.setFieldInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS1,gas);
    }

    public NobleGas getAtmosphereGasSubFirst()
    {
        return NobleGas.valueOf(Data.getValue(F.FIELD_PLANET_ATMOSPHERE_GAS2));
    }
    public void setAtmosphereGasSubFirst(NobleGas gas)
    {
        Data.setFieldValue(F.FIELD_PLANET_ATMOSPHERE_GAS2, gas.toString());

    }

    public float getAtmosphereGasSubFirstInternal()
    {
        return Data.getInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS2);
    }
    public void setAtmosphereGasSubFirstInternal(float gas)
    {
        Data.setFieldInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS2,gas);

    }

    public NobleGas getAtmosphereGasSubSecond()
    {
        return NobleGas.valueOf(Data.getValue(F.FIELD_PLANET_ATMOSPHERE_GAS3));
    }
    public void setAtmosphereGasSubSecond(NobleGas gas)
    {
        Data.setFieldValue(F.FIELD_PLANET_ATMOSPHERE_GAS3, gas.toString());

    }

    public float getAtmosphereGasSubSecondInternal()
    {
        return Data.getInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS3);
    }
    public void setAtmosphereGasSubSecondInternal(float gas)
    {
        Data.setFieldInternalValue(F.FIELD_PLANET_ATMOSPHERE_GAS3,gas);

    }


    public String getSubClass()
    {
        return Data.getValue(F.FIELD_PLANET_SUBCLASS);
    }

    public void setSubClass(String subClass){
        Data.setFieldValue(F.FIELD_PLANET_SUBCLASS,subClass);
    }
}

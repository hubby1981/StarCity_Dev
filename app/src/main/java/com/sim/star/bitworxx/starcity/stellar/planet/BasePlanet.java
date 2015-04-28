package com.sim.star.bitworxx.starcity.stellar.planet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.sim.star.bitworxx.starcity.helper.BitmapHelper;
import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
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

        Data.Fields.register("type", new MetaField("planet"));
        Data.Fields.register("subclass", new MetaField("solid"));

        Data.Fields.register("core_type",new MetaField());
        Data.Fields.register("surface_type",new MetaField());

        Data.Fields.register("atmosphere_type",new MetaField());
        Data.Fields.register("atmosphere_gas0",new MetaField());
        Data.Fields.register("atmosphere_gas1",new MetaField());
        Data.Fields.register("atmosphere_gas2",new MetaField());
        Data.Fields.register("atmosphere_gas3",new MetaField());

        Data.Fields.register("size",new MetaField());
        Data.Fields.register("texture",new MetaField());

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
        Data.setFieldValue("core_type",coreType.toString());
    }

    public PlanetSurface getSurfaceType()
    {
        return PlanetSurface.valueOf(Data.getValue("surface_type"));
    }

    public void setSurfaceType(PlanetSurface surfaceType)
    {
        Data.setFieldValue("surface_type",surfaceType.toString());
    }

    public PlanetAtmosphere getAtmosphereType()
    {
        return PlanetAtmosphere.valueOf(Data.getValue("atmosphere_type"));
    }

    public void setAtmosphereType(PlanetAtmosphere atmosphereType)
    {
        Data.setFieldValue("atmosphere_type",atmosphereType.toString());
    }

    public float getSize()
    {
        return Data.getInternalValue("size");
    }

    public void setSize(float size)
    {
        Data.setFieldInternalValue("size",size);
    }

    public float getAtmosphereGasSystem()
    {
        return Data.getInternalValue("atmosphere_gas0");
    }
    public void setAtmosphereGasSystem(float gas)
    {
        Data.setFieldInternalValue("atmosphere_gas0",gas);

    }

    public BaseElements getAtmosphereGasMain()
    {
        String value = Data.getValue("atmosphere_gas1");
        try{ BaseElements.valueOf(value);}catch(Exception e){};
        return BaseElements.valueOf(value);
    }
    public void setAtmosphereGasMain(BaseElements gas)
    {
        Data.setFieldValue("atmosphere_gas1", gas.toString());

    }

    public float getAtmosphereGasMainInternal()
    {
        return Data.getInternalValue("atmosphere_gas1");
    }
    public void setAtmosphereGasMainInternal(float gas)
    {
        Data.setFieldInternalValue("atmosphere_gas1",gas);

    }

    public NobleGas getAtmosphereGasSubFirst()
    {
        return NobleGas.valueOf(Data.getValue("atmosphere_gas2"));
    }
    public void setAtmosphereGasSubFirst(NobleGas gas)
    {
        Data.setFieldValue("atmosphere_gas2", gas.toString());

    }

    public float getAtmosphereGasSubFirstInternal()
    {
        return Data.getInternalValue("atmosphere_gas2");
    }
    public void setAtmosphereGasSubFirstInternal(float gas)
    {
        Data.setFieldInternalValue("atmosphere_gas2",gas);

    }

    public NobleGas getAtmosphereGasSubSecond()
    {
        return NobleGas.valueOf(Data.getValue("atmosphere_gas3"));
    }
    public void setAtmosphereGasSubSecond(NobleGas gas)
    {
        Data.setFieldValue("atmosphere_gas3", gas.toString());

    }

    public float getAtmosphereGasSubSecondInternal()
    {
        return Data.getInternalValue("atmosphere_gas3");
    }
    public void setAtmosphereGasSubSecondInternal(float gas)
    {
        Data.setFieldInternalValue("atmosphere_gas3",gas);

    }


    public String getSubClass()
    {
        return Data.getValue("subclass");
    }

    public void setSubClass(String subClass){
        Data.setFieldValue("subclass",subClass);
    }
}

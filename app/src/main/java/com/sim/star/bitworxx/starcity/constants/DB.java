package com.sim.star.bitworxx.starcity.constants;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sim.star.bitworxx.starcity.cycle.GM;
import com.sim.star.bitworxx.starcity.meta.MetaField;
import com.sim.star.bitworxx.starcity.meta.MetaFieldContainer;
import com.sim.star.bitworxx.starcity.meta.MetaObject;
import com.sim.star.bitworxx.starcity.meta.MetaObjectContainer;

import java.util.Date;
import java.util.Map;

/**
 * Created by WEIS on 14.04.2015.
 */
public class DB {

    public static String DB_NAME = "StarCityByBitworxx";
    public static String CREATE_IF_NOT="CREATE TABLE IF NOT EXISTS ";
    public static String LINE=";";
    public static String CREATE_SQL_META_OBJECT = CREATE_IF_NOT+ SqlTables.SQL_META_OBJECT+"(id integer primary key autoincrement,name text)"+LINE;
    public static String CREATE_SQL_META_PATTERN = CREATE_IF_NOT+ SqlTables.SQL_META_PATTERN+"(id integer primary key autoincrement,name text)"+LINE;
    public static String CREATE_SQL_META_OBJECT_TO_META_PATTERN = CREATE_IF_NOT+ SqlTables.SQL_META_OBJECT_TO_META_PATTERN+"(meta_object_id integer,meta_pattern_id integer)"+LINE;
    public static String CREATE_SQL_META_FIELD = CREATE_IF_NOT+ SqlTables.SQL_META_FIELD+"(meta_object_id integer,name text,value text,internal_value numeric)"+LINE;
    public static String CREATE_SQL_META_PATTERN_FIELD = CREATE_IF_NOT+ SqlTables.SQL_META_PATTERN_FIELD+"(meta_pattern_id integer,name text,value text,internal_value numeric)"+LINE;
    public static String CREATE_SQL_SETUP = CREATE_IF_NOT+ SqlTables.SQL_SETUP+ SqlSetup.SQL_FIELDS+LINE;


    public static String SQL_SELECT_META = "SELECT id,name FROM "+ SqlTables.SQL_META_OBJECT+" WHERE name='[name]'";
    public static String SQL_SELECT_META_FIELD = "SELECT name,value,internal_value FROM "+ SqlTables.SQL_META_FIELD+" WHERE meta_object_id='[id]'";
    public static String SQL_INSERT_META_FIELD = "INSERT INTO "+ SqlTables.SQL_META_FIELD+" VALUES([id],'[name]','[value]',[internal_value])";
    public static String SQL_DELETE_META_FIELD = "DELETE FROM "+ SqlTables.SQL_META_FIELD+" WHERE meta_object_id='[id]'";

    public static String SQL_SELECT_ONE="SELECT value FROM ";

    public static String CREATE_SQL=CREATE_SQL_SETUP;


    public static SQLiteDatabase Connection;


    public static Cursor getQuery(String query, String[] args) {
        if(Connection!=null)
            return Connection.rawQuery(query, args);
        return null;
    }


    public static void setConnection(SQLiteDatabase connection)
    {
        Connection = connection;
        if(Connection!=null)
        {
            Connection.execSQL(CREATE_SQL);
            Connection.execSQL(CREATE_SQL_META_OBJECT);
            Connection.execSQL(CREATE_SQL_META_PATTERN);
            Connection.execSQL(CREATE_SQL_META_OBJECT_TO_META_PATTERN);
            Connection.execSQL(CREATE_SQL_META_FIELD);
            Connection.execSQL(CREATE_SQL_META_PATTERN_FIELD);

            /*
            Connection.execSQL("insert into "+SqlTables.SQL_META_OBJECT+" (name) values('starship')");
            Connection.execSQL("insert into "+SqlTables.SQL_META_OBJECT+" (name) values('starship')");
            Connection.execSQL("insert into "+SqlTables.SQL_META_OBJECT+" (name) values('starship')");


            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(1,'shipname','BEYOND',0.0)");
            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(1,'shiptype','DESTROYER',0.0)");

            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(2,'shipname','DARKNEY',0.0)");
            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(2,'shiptype','EXPLORER',0.0)");


            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(3,'shipname','BEYOND II',0.0)");
            Connection.execSQL("insert into "+SqlTables.SQL_META_FIELD+" (meta_object_id,name,value,internal_value) values(3,'shiptype','DESTROYER',0.0)");*/
        }
        checkInit();
    }


    private static void checkInit()
    {
        checkSetup();
    }

    private static void checkSetup()
    {
       String result= hasNameOrCreate(SqlTables.SQL_SETUP, SqlSetup.SQL_NAME_VERSION, SqlSetup.SQL_VALUE_VERSION);
       result=  hasNameOrCreate(SqlTables.SQL_SETUP, SqlSetup.SQL_NAME_INSTALLED,new Date().toString());

    }

    private static String hasNameOrCreate(String table,String name,String value)
    {
        try{
        Cursor cursor = Connection.rawQuery(SQL_SELECT_ONE+table+" WHERE name='"+name+"'",null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
           return cursor.getString(0);
        }
        else
        {
            Connection.execSQL("INSERT INTO "+table+" VALUES('"+name+"','"+value+"')");
        }
        return value;}catch(Exception e){
            return e.getMessage();
        }
    }

    public static void fillContainer(MetaObjectContainer container)
    {

        if(Connection!=null){
            Cursor cMeta = Connection.rawQuery(SQL_SELECT_META.replace("[name]",container.Name),null);
            if(cMeta.getCount()>0)
            {
                while (cMeta.moveToNext()) {

                    MetaObject metaObject = container.createItem( cMeta.getString(1));
                    fillFields(cMeta.getInt(0),metaObject);
                    container.register(cMeta.getInt(0), metaObject);
                }
            }
        }



    }


    public static void fillFields(Integer id,MetaObject metaObject)
    {
        if(Connection!=null){
            Cursor cMeta = Connection.rawQuery(SQL_SELECT_META_FIELD.replace("[id]",id.toString()),null);
            metaObject.RealDB=id;
            if(cMeta.getCount()>0)
            {
                while (cMeta.moveToNext()) {
                    metaObject.Fields.register(cMeta.getString(0), new MetaField(cMeta.getString(1), cMeta.getFloat(2)));
                }
            }
        }
    }

public static Integer addMetaObject(MetaObject metaObject)
    {
        Integer id=-1;
        if(Connection!=null)
        {

            ContentValues values = new ContentValues();
            values.put("name",metaObject.Name);
            id =((Long) Connection.insert(SqlTables.SQL_META_OBJECT,"",values)).intValue();

            saveFields(id,metaObject);
        }
        return id;
    }

    public static void saveFields(Integer id,MetaObject metaObject)
    {
        if(Connection!=null)
        {
            Connection.execSQL(SQL_DELETE_META_FIELD.replace("[id]",id.toString()));

            for(Map.Entry<String,MetaField> f : metaObject.Fields.Fields.entrySet())
            {
                ContentValues values = new ContentValues();
                    values.put("meta_object_id",id);
                    values.put("name",f.getKey());
                    values.put("value",f.getValue().Value);
                    values.put("internal_value",f.getValue().InternalValue);

                Connection.insert(SqlTables.SQL_META_FIELD,"",values);
            }
        }
    }





}

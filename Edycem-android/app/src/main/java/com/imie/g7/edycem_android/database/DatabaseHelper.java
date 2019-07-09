package com.imie.g7.edycem_android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOM_BASE = "edycem.db";
    private static final int VERSION = 1;

    /**
     * Constructeur.
     * @param context Context
     */
    public DatabaseHelper(Context context)
    {
        super(context, NOM_BASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

}

package com.imie.g7.edycem_android.database;

import android.provider.BaseColumns;

public class BaseContrat {

    private BaseContrat() {}

    public static class ProjectContrat implements BaseColumns
    {
        public static final String TABLE_PROJECT = "project";
        public static final String COLONNE_ID = "id";
        public static final String COLONNE_NAME = "name";
        public static final String COLONNE_USER_ID= "user_id";
    }
}

package com.imie.g7.edycem_android.database;

import android.provider.BaseColumns;

public class BaseContrat {

    private BaseContrat() {}

    public static class InformationSectionContrat implements BaseColumns {
        public static final String TABLE_INFORMATION_SECTION = "information_section";
        public static final String COLONNE_ID = "id";
        public static final String COLONNE_ANNEE = "annee";
        public static final String COLONNE_PRIORITE = "priorite";
        public static final String COLONNE_SITE = "site";
        public static final String COLONNE_PROJECT= "project";
        public static final String COLONNE_DEADLINE = "deadline";
        public static final String COLONNE_OBJECTIVES = "objectives";
        public static final String COLONNE_CHAIRE= "chaire";
        public static final String COLONNE_CONFIDENTIALITY_CONTRACT = "confidentiality_contract";
        public static final String COLONNE_LICENCE = "licence";
        public static final String COLONNE_BREVET= "brevet";
        public static final String COLONNE_PROJECT_ID = "project_id";
    }

    public static class ProjectContrat implements BaseColumns {
        public static final String TABLE_PROJECT = "project";
        public static final String COLONNE_ID = "id";
        public static final String COLONNE_SOCIETY = "societe";
        public static final String COLONNE_NAME = "name";
        public static final String COLONNE_USER_ID= "user_id";
    }

    public static class TimeSpentContrat implements BaseColumns {
        public static final String TABLE_TIME_SPENT = "time_spent";
        public static final String COLONNE_ID = "id";
        public static final String COLONNE_PROJECT_ID = "project_id";
        public static final String COLONNE_TASK_ID = "task_id";
        public static final String COLONNE_USER_ID = "user_id";
        public static final String COLONNE_HOURS= "hours";
        public static final String COLONNE_ENTRY_DATE = "entry_date";
        public static final String COLONNE_DESCRIPTION= "description";
    }

    public static class UsersContrat implements BaseColumns {
        public static final String TABLE_USERS = "users";
        public static final String COLONNE_ID = "id";
        public static final String COLONNE_NAME = "name";
        public static final String COLONNE_SURNAME = "surname";
        public static final String COLONNE_EMAIL = "email";
        public static final String COLONNE_PASSWORD= "password";
    }

}

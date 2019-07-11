package com.imie.g7.edycem_android.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.imie.g7.edycem_android.database.BaseContrat;
import com.imie.g7.edycem_android.database.DatabaseHelper;
import com.imie.g7.edycem_android.database.dto.InformationSectionDto;

public class InformationSectionDao {

    public static InformationSectionDto getInformationSectionOfAProject(Context context, int projectId) {
        InformationSectionDto informationSection = new InformationSectionDto();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        db.beginTransaction();
        try {
            String selection = BaseContrat.InformationSectionContrat.COLONNE_PROJECT_ID + " = ? ";
            String[] selectionArgs = {String.valueOf(projectId)};
            Cursor cursor = db.query(false,
                     BaseContrat.InformationSectionContrat.TABLE_INFORMATION_SECTION,
                    null,selection,selectionArgs,null,
                    null,null,null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    informationSection.setId(cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_ID)));
                    informationSection.setAnnee(cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_ANNEE)));
                    informationSection.setBrevet((boolean) (cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_BREVET))
                            == 1));
                    informationSection.setChaire((boolean) (cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_CHAIRE))
                            == 1));
                    informationSection.setConfidentialityContract((boolean) (cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat
                                    .COLONNE_CONFIDENTIALITY_CONTRACT)) == 1));
                    informationSection.setDeadline(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_DEADLINE)));
                    informationSection.setLicence((boolean) (cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_LICENCE))
                            == 1));
                    informationSection.setObjectives(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_OBJECTIVES)));
                    informationSection.setPriorite(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_PRIORITE)));
                    informationSection.setProject(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_PROJECT)));
                    informationSection.setProjectId(cursor.getInt(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_PROJECT_ID)));
                    informationSection.setSite(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.InformationSectionContrat.COLONNE_SITE)));
                } catch (Exception exception) {
                    exception.printStackTrace();
                } finally {
                    cursor.close();
                }
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
        return informationSection;
    }

    public  static void insertInformationSectionOfAProject(Context context,
                                                           InformationSectionDto informationSection) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(BaseContrat.InformationSectionContrat.COLONNE_ANNEE,
                    informationSection.getAnnee());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_BREVET,
                    informationSection.isBrevet());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_CHAIRE,
                    informationSection.isChaire());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_CONFIDENTIALITY_CONTRACT,
                    informationSection.isConfidentialityContract());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_DEADLINE,
                    informationSection.getDeadline());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_ID,
                    informationSection.getId());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_LICENCE,
                    informationSection.isLicence());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_OBJECTIVES,
                    informationSection.getObjectives());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_PRIORITE,
                    informationSection.getPriorite());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_PROJECT,
                    informationSection.getProject());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_PROJECT_ID,
                    informationSection.getProjectId());
            values.put(BaseContrat.InformationSectionContrat.COLONNE_SITE,
                    informationSection.getSite());
            db.insert(BaseContrat.InformationSectionContrat.TABLE_INFORMATION_SECTION,
                    null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }
}

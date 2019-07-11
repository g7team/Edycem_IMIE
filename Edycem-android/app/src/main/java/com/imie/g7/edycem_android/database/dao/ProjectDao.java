package com.imie.g7.edycem_android.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.imie.g7.edycem_android.database.BaseContrat;
import com.imie.g7.edycem_android.database.DatabaseHelper;
import com.imie.g7.edycem_android.database.dto.ProjectDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    public static List<ProjectDto> getListProject(Context context) {
        List<ProjectDto> listProjects = new ArrayList<ProjectDto>();
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        db.beginTransaction();
        try {
            Cursor cursor = db.query(false,BaseContrat.ProjectContrat.TABLE_PROJECT,
                    null,null,null,null,
                    null,null,null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        listProjects.add(new ProjectDto(
                                cursor.getInt(cursor
                                        .getColumnIndex(BaseContrat.ProjectContrat.COLONNE_ID)),
                                cursor.getString(cursor
                                        .getColumnIndex(BaseContrat.ProjectContrat.COLONNE_SOCIETY)),
                                cursor.getString(cursor
                                        .getColumnIndex(BaseContrat.ProjectContrat.COLONNE_NAME)),
                                cursor.getInt(cursor
                                        .getColumnIndex(BaseContrat.ProjectContrat.COLONNE_USER_ID))
                        ));
                        cursor.moveToNext();
                    }
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
        return listProjects;
    }

    public static int insertNewProject(Context context, ProjectDto project) {
        int id = -1;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.beginTransaction();
        try {
           ContentValues values = new ContentValues();
            values.put(BaseContrat.ProjectContrat.COLONNE_NAME, project.getName());
            values.put(BaseContrat.ProjectContrat.COLONNE_SOCIETY, project.getSociety());
            values.put(BaseContrat.ProjectContrat.COLONNE_USER_ID, project.getUserId());
            id = (int) db.insert(BaseContrat.ProjectContrat.TABLE_PROJECT, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
            return  id;
        }
    }
}

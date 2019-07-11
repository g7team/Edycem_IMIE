package com.imie.g7.edycem_android.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.imie.g7.edycem_android.database.BaseContrat;
import com.imie.g7.edycem_android.database.DatabaseHelper;
import com.imie.g7.edycem_android.database.dto.UsersDto;

public class UsersDao {

    public static int getUserByEmail(Context context, String mail, String password) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        db.beginTransaction();
        int id = -1;
        try {
            String selection = BaseContrat.UsersContrat.COLONNE_EMAIL + " = ? ";
            String[] selectionArgs = {mail};
            Cursor cursor = db.query(false,
                    BaseContrat.InformationSectionContrat.TABLE_INFORMATION_SECTION,
                    null,selection,selectionArgs,null,
                    null,null,null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    if (password.equals(cursor.getString(cursor
                            .getColumnIndex(BaseContrat.UsersContrat.COLONNE_PASSWORD)))) {
                        id = cursor.getInt(cursor
                                .getColumnIndex(BaseContrat.UsersContrat.COLONNE_ID));
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
            return id;
        }
    }
}

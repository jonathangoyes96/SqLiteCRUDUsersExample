package com.optic.sqlitecrudusersexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.optic.sqlitecrudusersexample.contracts.LawyersContract;
import com.optic.sqlitecrudusersexample.contracts.LawyersContract.LawyerEntry;

/**
 * Created by Optic on 12/04/2018.
 * Clase que permite manejar las bases de datos sqlite en android
 */

public class LawyersDbHelper extends SQLiteOpenHelper {
    // Version de la base de datos
    public static final int DATABASE_VERSION = 1;

    // Nombre de la base de datos que se creara
    public static final String DATABASE_NAME = "Lawyers.db";

    public LawyersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
     * CREANDO LA BASE DE DATOS SQLITE
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + LawyerEntry.TABLE_NAME + " ("
                + LawyerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LawyerEntry.ID + " TEXT NOT NULL,"
                + LawyerEntry.NAME + " TEXT NOT NULL,"
                + LawyerEntry.SPECIALTY + " TEXT NOT NULL,"
                + LawyerEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + LawyerEntry.BIO + " TEXT NOT NULL,"
                + LawyerEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + LawyersContract.LawyerEntry.ID + "))");
    }
    /*
     * onUpgrade recibe tres parametros
     * SQLiteDatabase db: Manejador de la base de datos.
     * int oldVersion: Se trata de un entero que indica la versión antigua de la base de datos.
     * int newVersion: Entero que se refiere a la versión nueva de la base de datos.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

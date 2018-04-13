package com.optic.sqlitecrudusersexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.optic.sqlitecrudusersexample.contracts.LawyersContract;
import com.optic.sqlitecrudusersexample.contracts.LawyersContract.LawyerEntry;
import com.optic.sqlitecrudusersexample.models.Lawyer;

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
     * CREANDO LA BASE DE DATOS SQLITE Y INSERTAND DATOS
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create table
        sqLiteDatabase.execSQL("CREATE TABLE " + LawyerEntry.TABLE_NAME + " ("
                + LawyerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LawyerEntry.ID + " TEXT NOT NULL,"
                + LawyerEntry.NAME + " TEXT NOT NULL,"
                + LawyerEntry.SPECIALTY + " TEXT NOT NULL,"
                + LawyerEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + LawyerEntry.BIO + " TEXT NOT NULL,"
                + LawyerEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + LawyersContract.LawyerEntry.ID + "))");


        // Insertar datos ficticios para prueba inicial
        mockData(sqLiteDatabase);

    }

    /*
     * DATOS FICTICIOS PARA HACER PRUEBAS
     */
    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLawyer(sqLiteDatabase, new Lawyer("Carlos Perez", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "carlos_perez.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Daniel Samper", "Abogado accidentes de tráfico",
                "300 200 2222", "Gran profesional con experiencia de 5 años en accidentes de tráfico.",
                "daniel_samper.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Lucia Aristizabal", "Abogado de derechos laborales",
                "300 200 3333", "Gran profesional con más de 3 años de experiencia en defensa de los trabajadores.",
                "lucia_aristizabal.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Marina Acosta", "Abogado de familia",
                "300 200 4444", "Gran profesional con experiencia de 5 años en casos de familia.",
                "marina_acosta.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Olga Ortiz", "Abogado de administración pública",
                "300 200 5555", "Gran profesional con experiencia de 5 años en casos en expedientes de urbanismo.",
                "olga_ortiz.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Pamela Briger", "Abogado fiscalista",
                "300 200 6666", "Gran profesional con experiencia de 5 años en casos de derecho financiero",
                "pamela_briger.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Rodrigo Benavidez", "Abogado Mercantilista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en redacción de contratos mercantiles",
                "rodrigo_benavidez.jpg"));
        mockLawyer(sqLiteDatabase, new Lawyer("Tom Bonz", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "tom_bonz.jpg"));
    }

    public long mockLawyer(SQLiteDatabase db, Lawyer lawyer) {
        return db.insert(
                LawyerEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());
    }

    /*
     * METODO QUE PERMITE GUARDAR DATOS EN LA BASE DE DATOS
     */
    public long saveLawyer(Lawyer lawyer) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                LawyersContract.LawyerEntry.TABLE_NAME,
                null,
                lawyer.toContentValues());

    }

    /*
     * METODO QUE PERMITE OBTENER TODOS LOS ABOGADOS EXISTENTES EN LA BASE DE DATOS
     */
    public Cursor getAllLawyers() {
        return getReadableDatabase()
                .query(
                        LawyerEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    /*
     * METODO QUE PERMITE OBTENER UN ABOGADO POR ID DE LA BASE DE DATOS
     */
    public Cursor getLawyerById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                LawyerEntry.TABLE_NAME,
                null,
                LawyerEntry.ID + " LIKE ?", new String[]{lawyerId},
                null,
                null,
                null);
        return c;
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

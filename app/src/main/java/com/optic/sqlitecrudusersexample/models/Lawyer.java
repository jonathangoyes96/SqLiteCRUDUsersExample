package com.optic.sqlitecrudusersexample.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.optic.sqlitecrudusersexample.contracts.LawyersContract;

import java.util.UUID;

/**
 * Created by Optic on 12/04/2018.
 */

public class Lawyer {
    private String id;
    private String name;
    private String specialty;
    private String phoneNumber;
    private String bio;
    private String avatarUri;

    public Lawyer(String name, String specialty, String phoneNumber, String bio, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }



    /*
     * METODO QUE RETORNA LOS VALORES A INSERTAR EN LA BASE DE DATOS
     */
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(LawyersContract.LawyerEntry.ID, id);
        values.put(LawyersContract.LawyerEntry.NAME, name);
        values.put(LawyersContract.LawyerEntry.SPECIALTY, specialty);
        values.put(LawyersContract.LawyerEntry.PHONE_NUMBER, phoneNumber);
        values.put(LawyersContract.LawyerEntry.BIO, bio);
        values.put(LawyersContract.LawyerEntry.AVATAR_URI, avatarUri);
        return values;
    }
}

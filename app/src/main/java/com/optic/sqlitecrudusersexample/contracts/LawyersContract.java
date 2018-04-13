package com.optic.sqlitecrudusersexample.contracts;

import android.provider.BaseColumns;

/**
 * Created by User on 12/04/2018.
 * Esquema de la base de datos para abogados
 * BaseColumns Se implementó la interfaz on el fin de agregar una columna extra que se recomienda tenga toda tabla.
 */

public class LawyersContract {

    public static abstract class LawyerEntry implements BaseColumns {
        public static final String TABLE_NAME ="lawyer";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SPECIALTY = "specialty";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String AVATAR_URI = "avatarUri";
        public static final String BIO = "bio";
    }
}

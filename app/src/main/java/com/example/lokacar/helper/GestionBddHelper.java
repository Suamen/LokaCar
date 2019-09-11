package com.example.lokacar.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.lokacar.data.bo.DataContract;

public class GestionBddHelper extends SQLiteOpenHelper {

    public GestionBddHelper(Context context) {

        super(context, DataContract.DATABASE_NAME, null, DataContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataContract.CREATE_TABLE_GERANT);
        db.execSQL(DataContract.CREATE_TABLE_AGENCE);

        // Table Vehicule
        db.execSQL(DataContract.CREATE_TABLE_VEHICULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_GERANT);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_AGENCE);

            // Table Vehicule
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_VEHICULE);

            onCreate(db);
        }
    }
}

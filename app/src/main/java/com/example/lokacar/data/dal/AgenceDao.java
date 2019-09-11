package com.example.lokacar.data.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.bo.DataContract;
import com.example.lokacar.data.bo.Gerant;
import com.example.lokacar.helper.GestionBddHelper;

public class AgenceDao {
    private SQLiteDatabase db;
    private GestionBddHelper helper;
    private GerantDao gerantDao;


    public AgenceDao(Context context) {
        gerantDao = new GerantDao(context);
        ;
        helper = new GestionBddHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertAgence(Agence agence) {
        ContentValues values = new ContentValues();
        values.put(DataContract.COL_NOM, agence.getNomAgence());
        values.put(DataContract.COL_GERANT, 1);
        db.insert(DataContract.NOM_TABLE_AGENCE, null, values);
    }

    public Agence selectById(int id) {
        Agence agence = null;

        Cursor c = db.query(
                DataContract.NOM_TABLE_AGENCE,
                new String[]{
                        DataContract.COL_ID,
                        DataContract.COL_NOM,
                        DataContract.COL_ADRESSE,
                        DataContract.COL_GERANT,
                },
                " ID = " + id,
                null,
                null,
                null,
                null
        );

        if (c != null && c.moveToFirst()) {

            int id_gerant = c.getInt(c.getColumnIndex(DataContract.COL_GERANT));
            Gerant gerant = gerantDao.selectById(id_gerant);

            agence = new Agence(
                    c.getInt(c.getColumnIndex(DataContract.COL_ID)),
                    c.getString(c.getColumnIndex(DataContract.COL_NOM)),
                    null,
                    gerant
            );
        }
        return agence;
    }

}

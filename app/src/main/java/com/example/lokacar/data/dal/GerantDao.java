package com.example.lokacar.data.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lokacar.data.bo.DataContract;
import com.example.lokacar.data.bo.Gerant;
import com.example.lokacar.helper.GestionBddHelper;

import java.util.ArrayList;
import java.util.List;

public class GerantDao {
    private SQLiteDatabase db;
    private GestionBddHelper helper;

    public GerantDao (Context context){
        helper = new GestionBddHelper(context);
        db = helper.getWritableDatabase();
    }

    public List<Gerant> selectAll(){
        List<Gerant> listeGerant = new ArrayList<>();

        Cursor c = db.query(
                DataContract.NOM_TABLE_GERANT,
                new String[]{
                        DataContract.COL_ID,
                        DataContract.COL_NOM,
                        DataContract.COL_PRENOM,
                        DataContract.COL_ADRESSE,
                        DataContract.COL_TEL,
                        DataContract.COL_EMAIL,
                        DataContract.COL_LOGIN,
                        DataContract.COL_MDP
                },
                null,
                null,
                null,
                null,
                null
        );

        if (c != null && c.moveToFirst()) {
            do {
                Gerant gerant = new Gerant(
                        c.getInt(c.getColumnIndex(DataContract.COL_ID)),
                        c.getString(c.getColumnIndex(DataContract.COL_NOM)),
                        c.getString(c.getColumnIndex(DataContract.COL_PRENOM)),
                        null,
                        c.getString(c.getColumnIndex(DataContract.COL_TEL)),
                        c.getString(c.getColumnIndex(DataContract.COL_EMAIL)),
                        c.getString(c.getColumnIndex(DataContract.COL_LOGIN)),
                        c.getString(c.getColumnIndex(DataContract.COL_MDP))
                );
                listeGerant.add(gerant);
            } while (c.moveToNext());
        }
        return listeGerant;
    }

    public void insertGerant(Gerant gerant) {
        ContentValues values = new ContentValues();
        values.put(DataContract.COL_NOM, gerant.getNom());
        values.put(DataContract.COL_PRENOM, gerant.getPrenom());
        //values.put(DataContract.COL_ADRESSE,);
        values.put(DataContract.COL_TEL, gerant.getTel());
        values.put(DataContract.COL_EMAIL, gerant.getEmail());
        values.put(DataContract.COL_LOGIN, gerant.getLogin());
        values.put(DataContract.COL_MDP, gerant.getMdp());
        db.insert(DataContract.NOM_TABLE_GERANT,null, values);
    }

    public Gerant selectById(int id){
        Gerant gerant = null;

        Cursor c = db.query(
                DataContract.NOM_TABLE_GERANT,
                new String[]{
                        DataContract.COL_ID,
                        DataContract.COL_NOM,
                        DataContract.COL_PRENOM,
                        DataContract.COL_ADRESSE,
                        DataContract.COL_TEL,
                        DataContract.COL_EMAIL
                },
                " ID = " + id,
                null,
                null,
                null,
                null
        );

        if (c != null && c.moveToFirst())
        {
            gerant = new Gerant(
                    c.getInt(c.getColumnIndex(DataContract.COL_ID)),
                    c.getString(c.getColumnIndex(DataContract.COL_NOM)),
                    c.getString(c.getColumnIndex(DataContract.COL_PRENOM)),
                    null,
                    c.getString(c.getColumnIndex(DataContract.COL_TEL)),
                    c.getString(c.getColumnIndex(DataContract.COL_EMAIL))
            );
        }
        return gerant;
    }

}

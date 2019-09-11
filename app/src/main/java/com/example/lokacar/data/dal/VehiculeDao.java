package com.example.lokacar.data.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.bo.DataContract;
import com.example.lokacar.data.bo.Location;
import com.example.lokacar.data.bo.Vehicule;
import com.example.lokacar.helper.GestionBddHelper;

import java.util.ArrayList;
import java.util.List;

public class VehiculeDao {

    private GestionBddHelper dbHelper;
    private AgenceDao daoAgence;

    public VehiculeDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
        daoAgence = new AgenceDao(context);
    }

    private ContentValues getContentValues(Vehicule vehicule) {

        ContentValues values = new ContentValues();
        values.put(DataContract._IMMATRICULATION, vehicule.getImmatriculation());
        values.put(DataContract._MARQUE, vehicule.getMarque());
        values.put(DataContract._PHOTO_VEHICULE, vehicule.getPhotoVehicule());
        values.put(DataContract._KILOMETRAGE, vehicule.getKilometrage());

        if (vehicule.isLoue()) values.put(DataContract._IS_LOUE, 1);
        else values.put(DataContract._IS_LOUE, 0);

        if (vehicule.isDisponible()) values.put(DataContract._IS_DISPONIBLE, 1);
        else values.put(DataContract._IS_DISPONIBLE, 0);

        values.put(DataContract._ID_AGENCE, vehicule.getAgence().getId());

        return values;
    }

    // Get Voiture from cursor
    private Vehicule getVehicule(Cursor cursor) {

        boolean isLoue = false, isDisponible = true;

        String immatriculation = cursor.getString(cursor.getColumnIndex(DataContract._IMMATRICULATION));
        String marque = cursor.getString(cursor.getColumnIndex(DataContract._MARQUE));
        String photoVehicule = cursor.getString(cursor.getColumnIndex(DataContract._PHOTO_VEHICULE));
        int kilometrage = cursor.getInt(cursor.getColumnIndex(DataContract._KILOMETRAGE));

        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_LOUE)) == 1)
            isLoue = true;

        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_DISPONIBLE)) != 1)
            isDisponible = false;

        List<Location> locations = null;

        int idAgence = cursor.getInt(cursor.getColumnIndex(DataContract._ID_AGENCE));
        Agence agence = daoAgence.selectById(idAgence);

        return new Vehicule(immatriculation, marque, photoVehicule, kilometrage, isLoue, isDisponible, locations, agence);

    }

    // Select all
    public List<Vehicule> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_VEHICULE,
                null,
                null,
                null,
                null,
                null,
                DataContract._MARQUE);

        List<Vehicule> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){

            while (cursor.moveToNext()) {
                objects.add(getVehicule(cursor));
            }

            cursor.close();
        }

        return objects;

    }

    // Select all par Agence
    public List<Vehicule> selectAllbyAgence(int idAgence) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_VEHICULE,
                null,
                DataContract._ID_AGENCE+" = ?",
                new String[]{""+idAgence},
                null,
                null,
                DataContract._MARQUE);

        List<Vehicule> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){

            while (cursor.moveToNext()) {
                objects.add(getVehicule(cursor));
            }

            cursor.close();
        }

        return objects;
    }


    // Insert
    public void insert(Vehicule vehicule){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(DataContract.NOM_TABLE_VEHICULE, null, getContentValues(vehicule));
        db.close();
    }

    // Insert or Update
    public void insertOrUpdate(Vehicule vehicule){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.query(DataContract.NOM_TABLE_VEHICULE, null,
                DataContract._IMMATRICULATION+" = "+vehicule.getImmatriculation(),
                null,null,null,null);

        if(c.getCount() > 0){
            update(vehicule);
        }
        else {
            insert(vehicule);
        }

        c.close();
        db.close();
    }

    public void update(Vehicule vehicule) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.update(DataContract.NOM_TABLE_VEHICULE, getContentValues(vehicule),
                DataContract._IMMATRICULATION + " = " + vehicule.getImmatriculation(),
                null);
        db.close();
    }

}

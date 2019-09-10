package com.example.lokacar.data.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.bo.Client;
import com.example.lokacar.data.bo.Location;
import com.example.lokacar.data.bo.Vehicule;
import com.example.lokacar.data.dal.dao.AgenceDAO;
import com.example.lokacar.data.dal.dao.ClientDAO;
import com.example.lokacar.data.dal.dao.LocationDAO;
import com.example.lokacar.data.dal.dao.VehiculeDAO;

@Database(entities = {
        Agence.class,
        //ChiffreAffaires.class,
        Client.class,
        Location.class,
        Vehicule.class
}, version = 1)
public abstract class database extends RoomDatabase {

    public static final String DATA_BASE_NAME = "lokacar_bdd";

    public abstract AgenceDAO agenceDAO();

    //public abstract ChiffreAffairesDAO chiffreAffairesDAO();

    public abstract ClientDAO clientDAO();

    public abstract LocationDAO locationDAO();

    //public abstract GerantDAO gerantDAO();

    public abstract VehiculeDAO vehiculeDAO();

    public static database getDataBase(Context context) {
        return Room.databaseBuilder(context, database.class, DATA_BASE_NAME).build();
    }


}


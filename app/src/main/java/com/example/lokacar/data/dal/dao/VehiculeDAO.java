package com.example.lokacar.data.dal.dao;

import androidx.room.Query;

import com.example.lokacar.data.bo.Vehicule;
import com.example.lokacar.data.dal.GeneriqueDAO;

import java.util.List;

public interface VehiculeDAO extends GeneriqueDAO<Vehicule> {

    @Query("SELECT * FROM vehicules")
    List<Vehicule> getAll();

    @Query("SELECT * FROM vehicules where immat = :immat")
    Vehicule selectByImmat(String immat);

    @Query("SELECT * FROM vehicules WHERE dispo = :dispo")
    List<Vehicule> selectByDispo(String dispo);

    @Query("DELETE FROM vehicules")
    void nukeTable();
}

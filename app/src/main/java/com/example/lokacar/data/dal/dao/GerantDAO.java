package com.example.lokacar.data.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lokacar.data.bo.Gerant;
import com.example.lokacar.data.dal.GeneriqueDAO;

import java.util.List;

@Dao
public interface GerantDAO extends GeneriqueDAO<Gerant> {

    @Query("SELECT * FROM gerants")
    List<Gerant> getAll();

    @Query("SELECT * from gerants WHERE agence_id= :agenceId")
    List<Gerant> selectByIdAgence(int agenceId);

    @Query("DELETE FROM gerants")
    void nukeTable();
}

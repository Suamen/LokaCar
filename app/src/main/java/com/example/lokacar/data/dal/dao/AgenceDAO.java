package com.example.lokacar.data.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.dal.GeneriqueDAO;

import java.util.List;
@Dao
public interface AgenceDAO extends GeneriqueDAO<Agence> {

    @Query("SELECT * FROM agences")
    List<Agence> getAll();

    @Query("SELECT * FROM agences WHERE id = :id")
    Agence selectById(int id);


    @Query("DELETE FROM agences")
    void nukeTable();
}

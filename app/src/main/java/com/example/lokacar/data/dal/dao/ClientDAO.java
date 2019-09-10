package com.example.lokacar.data.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lokacar.data.bo.Client;
import com.example.lokacar.data.dal.GeneriqueDAO;

import java.util.List;

@Dao
public interface ClientDAO extends GeneriqueDAO<Client> {

    @Query("SELECT * FROM clients")
    List<Client> getAll();

    @Query("SELECT * FROM clients where id = :id")
    Client selectById(int id);

    @Query("SELECT * FROM clients where nom LIKE :nom")
    List<Client> selectByName(String nom);

    @Query("DELETE FROM clients")
    void nukeTable();
}

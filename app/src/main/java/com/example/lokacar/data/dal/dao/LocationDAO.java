package com.example.lokacar.data.dal.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lokacar.data.bo.Location;
import com.example.lokacar.data.dal.GeneriqueDAO;

import java.util.List;

@Dao
public interface LocationDAO extends GeneriqueDAO<Location> {

    @Query("SELECT * FROM locations")
    List<Location> getAll();

    @Query("SELECT * FROM locations where id = :id")
    Location selectById(String id);

    @Query("SELECT * FROM locations where vehicule_id= :immat")
    List<Location> selectByImmat(String immat);

    @Query("SELECT * FROM locations where client_id= :clientId")
    List<Location> selectByIdClient(int clientId);

    @Query("SELECT * FROM Locations AS l, Clients c WHERE l.client_id = c.id AND c.nom LIKE :nom")
    List<Location> selectByNameClient(String nom);

    @Query("SELECT * FROM locations where agence_id= :agenceId")
    List<Location> selectByIdAgence(String agenceId);

    @Query("SELECT * FROM Locations WHERE dateReservation = :dateReservation")
    List<Location> selectParDateReservation(long dateReservation);

    @Query("SELECT * FROM Locations WHERE dateDepart = :dateDepart")
    List<Location> selectParDateDepart(long dateDepart);

    @Query("SELECT * FROM Locations WHERE dateRetourPrevu = :dateRetour")
    List<Location> selectParDateRetourPrevu(long dateRetour);

    @Query("DELETE FROM locations")
    void nukeTable();
}

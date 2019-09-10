package com.example.lokacar.data.bo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;

@Entity(tableName = "locations",
        foreignKeys = {
                @ForeignKey(entity = Vehicule.class, parentColumns = "immat", childColumns = "vehicule_id"),
                @ForeignKey(entity = Agence.class, parentColumns = "id", childColumns = "agence_id"),
                @ForeignKey(entity = Client.class, parentColumns = "id", childColumns = "client_id")

        })
public class Location {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @NonNull
    private long dateReservation;
    @NonNull
    private long dateDepart;
    @NonNull
    private long dateRetourReel;

    @Nullable
    private long dateRetourPrevu;


    @ColumnInfo(name = "vehicule_id")
    private String vehiculeId;

    @ColumnInfo(name = "agence_id")
    private int agenceId;

    @ColumnInfo(name = "client_id")
    private int clientId;

    @Ignore
    private Client client;

    public Location() {
    }

    public Location(Date dateReservation, Date dateDepart, Date dateRetourReel, Date dateRetourPrevu, String vehiculeId, int agenceId, int clientId) {
        this.dateReservation = dateReservation.getTime();
        this.dateDepart = dateDepart.getTime();
        this.dateRetourReel = dateRetourReel.getTime();
        this.dateRetourPrevu = dateRetourPrevu.getTime();
        this.vehiculeId = vehiculeId;
        this.agenceId = agenceId;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(long dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateDepart =  dateReservation.getTime();
    }


    public long getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(long dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart.getTime();
    }


    public long getDateRetourReel() {
        return dateRetourReel;
    }

    public void setDateRetourReel(long dateRetourReel) {
        this.dateRetourReel = dateRetourReel;
    }

    public void setDateretourReel(Date dateretourReel) {
        this.dateRetourReel = dateretourReel.getTime();
    }


    public long getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(long dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public void setDateRetourPrevu(Date dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu.getTime();
    }


    @NonNull
    public String getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(@NonNull String vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    @NonNull
    public int getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(@NonNull int agenceId) {
        this.agenceId = agenceId;
    }

    @NonNull
    public int getClientId() {
        return clientId;
    }

    public void setClientId(@NonNull int clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", dateReservation=" + dateReservation +
                ", dateDepart=" + dateDepart +
                ", dateRetourReel=" + dateRetourReel +
                ", dateRetourPrevu=" + dateRetourPrevu +
                ", vehicule=" + vehiculeId +
                ", agence=" + agenceId +
                ", client=" + clientId +
                '}';
    }
}

package com.example.lokacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final ImageButton listVhDButton = findViewById(R.id.ListeVehiculeDispo);
        final ImageButton listVhLButton = findViewById(R.id.ListeVehiculeLoue);
        final ImageButton listAffCAButton = findViewById(R.id.AfficherCA);
        final ImageButton listRVButton = findViewById(R.id.RestitutionVehicule);

    }

    public void clicListeVoituresDisponibles (View view) {
//        Intent intent = new Intent (this, ListeVoituresActivity.class);
//        startActivity(intent);
    }

    public void clicListeVoituresLouees (View view) {
        Intent intent = new Intent (this, liste_locations.class);
        startActivity(intent);
    }

    public void clicChiffreAffaire (View view) {
//        Intent intent = new Intent (this, ChiffreAffaireActivity.class);
//        startActivity(intent);
    }

    public void clicRestitutionVoiture (View view) {
//        Intent intent = new Intent (this, ListeLocationsActivity.class);
//        startActivity(intent);
    }
}

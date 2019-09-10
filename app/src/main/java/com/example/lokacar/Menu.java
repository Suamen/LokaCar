package com.example.lokacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void clicListeVoituresDisponibles (View view) {
//        Intent intent = new Intent (this, ListeVoituresActivity.class);
//        startActivity(intent);
    }

    public void clicListeVoituresLouees (View view) {
//        Intent intent = new Intent (this, ListeClientsActivity.class);
//        startActivity(intent);
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

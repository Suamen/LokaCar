package com.example.lokacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lokacar.ListeVehicule.ListeViewVehicule;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final ImageButton listVhDButton = findViewById(R.id.ListeVehiculeDispo);
        final ImageButton listVhLButton = findViewById(R.id.ListeVehiculeLoue);
        final ImageButton listAffCAButton = findViewById(R.id.AfficherCA);
        final ImageButton listRVButton = findViewById(R.id.RestitutionVehicule);

        listVhDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, ListeViewVehicule.class);
                startActivity(intent);
            }
        });

        listVhLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, liste_locations.class);
                startActivity(intent);
            }
        });

        listAffCAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, CaActivity.class);
                startActivity(intent);
            }
        });

        listRVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
}

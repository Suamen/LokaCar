package com.example.lokacar.ListeVehicule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lokacar.R;
import com.example.lokacar.data.bo.Vehicule;

public class ListeViewVehicule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_view_vehicule);

        ListView listView = (ListView)findViewById(R.id.ListeViewVehicule);

        Vehicule tom = new Vehicule("AV-HEH-25",180000,"Disponible",1 );
        Vehicule jerry = new Vehicule("AB-HEH-25",160000,"Disponible",1 );
        Vehicule donald = new Vehicule("AC-HEH-25",50000,"Disponible",1 );

        Vehicule[] users = new Vehicule[]{tom, jerry, donald};


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<Vehicule> arrayAdapter
                = new ArrayAdapter<Vehicule>(this, android.R.layout.simple_list_item_1 , users);


        listView.setAdapter(arrayAdapter);
    }
}

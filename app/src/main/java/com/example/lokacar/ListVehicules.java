package com.example.lokacar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.bo.Vehicule;
import com.example.lokacar.data.dal.VehiculeDao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListVehicules extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private VehiculeDao vehiculeDao;
    private List<Vehicule> listVehicules;
    private ImageButton ajouterVehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehicules);
        ajouterVehicule = findViewById(R.id.ajouterVehicule);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewvh);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        vehiculeDao = new VehiculeDao(ListVehicules.this);

        listVehicules = vehiculeDao.selectAll();

        //specify an adapter (see also next example)
        mAdapter = new MyAdapter(listVehicules);
        mRecyclerView.setAdapter(mAdapter);

        ajouterVehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ListVehicules.this, ajouterVehicule.class);
                startActivity(intent);
            }
        });

    }
}


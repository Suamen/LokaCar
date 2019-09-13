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
    private List<Vehicule> listVehicules = new List<Vehicule>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Vehicule> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Vehicule vehicule) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Vehicule> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends Vehicule> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Vehicule get(int index) {
            return null;
        }

        @Override
        public Vehicule set(int index, Vehicule element) {
            return null;
        }

        @Override
        public void add(int index, Vehicule element) {

        }

        @Override
        public Vehicule remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<Vehicule> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Vehicule> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<Vehicule> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
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


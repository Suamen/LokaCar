package com.example.lokacar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lokacar.data.bo.Vehicule;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //Permet de stocker les données à afficher.
    private List<Vehicule> listVehicules;

    // Fournit une référence aux vues pour chaque élément de données
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Chaque élément contient seulement une TextView
        public TextView marqueVehicule;
        public TextView immatVehicule;
        public ImageView photoVehicule;

        public ViewHolder(View v) {
            super(v);
            marqueVehicule = v.findViewById(R.id.marque);
            immatVehicule = v.findViewById(R.id.immat);
            photoVehicule = v.findViewById(R.id.photo);
        }
    }

    // Constructeur qui attend les données à afficher en paramètre
    public MyAdapter(List<Vehicule> myListVehicules) {
        listVehicules = myListVehicules;
    }

    // Créé un ViewHolder qui représente le fichier activity_list_vehicules.xml
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicule_cards, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Remplie la vue représentant une ligne
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.marqueVehicule.setText(listVehicules.get(position).getMarque());
        holder.immatVehicule.setText(listVehicules.get(position).getImmatriculation());
//        int idt = R.drawable.citroen;
//        holder.immatVehicule.setText(Integer.toString(idt));

        if (listVehicules.get(position).getPhotoVehicule() != null) {
            int id = Integer.parseInt(listVehicules.get(position).getPhotoVehicule());
            holder.photoVehicule.setImageResource(id);
        }
    }

    // Retourne le nombre de données à afficher
    @Override
    public int getItemCount() {
        return listVehicules.size();
    }
}

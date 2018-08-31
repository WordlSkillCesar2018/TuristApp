package com.example.worldskills.turistapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends RecyclerView.Adapter<AdaptadorGrid.Holder> {
    Context context;
    ArrayList<Info> llenar;
    Adaptador.OnItemClickListener onItemClickListener;

    public AdaptadorGrid(Context context, ArrayList<Info> llenar) {
        this.llenar=llenar;
        this.context=context;
    }



    public interface OnItemClickListener {
        void onItemClick(LinearLayout b, View var2, int var3, long var4);
    }

    @Override
    public AdaptadorGrid.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(context).inflate(R.layout.modelogrid,parent,false);
        return new AdaptadorGrid.Holder(myview);
    }


    @Override
    public void onBindViewHolder(final AdaptadorGrid.Holder holder, final int position) {
        final Info a=llenar.get(position);
        holder.nombre.setText(a.getNombre());
        holder.descripcion.setText(a.getDescripcion());
        holder.ubicacion.setText(a.getUbicacion());
    }

    @Override
    public int getItemCount() {
        return llenar.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView nombre, descripcion, ubicacion;
        ImageView imageView;
        LinearLayout click;
        public Holder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            descripcion=itemView.findViewById(R.id.descripcion);
            ubicacion=itemView.findViewById(R.id.ubicacion);
            click=itemView.findViewById(R.id.click);
        }
    }
}

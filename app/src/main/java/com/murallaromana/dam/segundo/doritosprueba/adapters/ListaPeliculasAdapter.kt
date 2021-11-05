package com.murallaromana.dam.segundo.doritosprueba.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.murallaromana.dam.segundo.doritosprueba.R
import com.murallaromana.dam.segundo.doritosprueba.model.entidades.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter(val peliculas: List<Pelicula>): RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>(){
    class PeliculasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota)
        val ivPelicula = itemView.findViewById<ImageView>(R.id.ivPelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =
        LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)


        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        holder.tvGenero.setText(pelicula.genero)
        holder.tvNota.setText(pelicula.nota.toString())
        //Picasso.get().load(pelicula.URL).into(holder.ivPelicula)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}
package com.murallaromana.dam.segundo.aplicacionpeliculas.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.murallaromana.dam.segundo.aplicacionpeliculas.R
import com.murallaromana.dam.segundo.aplicacionpeliculas.activites.DetallesPeliculas
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter(val peliculas: List<Pelicula>?, val activity: Activity) :
    RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>() {
    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota)
        val ivPelicula = itemView.findViewById<ImageView>(R.id.ivPelicula)
        val layoutPelicula = itemView.findViewById<ConstraintLayout>(R.id.layoutPelicula)
        val tvDirector = itemView.findViewById<TextView>(R.id.tvDirector)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)

        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas?.get(position)

        holder.tvTitulo.setText(pelicula?.titulo)
        holder.tvGenero.setText(pelicula?.genero)
        holder.tvNota.setText(pelicula?.nota.toString())
        holder.tvDirector.setText(pelicula?.director)
        Picasso.get().load(pelicula?.URL).into(holder.ivPelicula)

        holder.layoutPelicula.setOnClickListener {
            val intent = Intent(activity, DetallesPeliculas::class.java)
            intent.putExtra("id", pelicula?.id)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        if (peliculas == null) return 0;
        else return peliculas.size
    }
}
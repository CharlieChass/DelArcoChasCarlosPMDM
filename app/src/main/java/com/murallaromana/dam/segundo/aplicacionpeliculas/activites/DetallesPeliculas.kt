package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.App
import com.murallaromana.dam.segundo.aplicacionpeliculas.R
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityDetallesPeliculasBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.squareup.picasso.Picasso

class DetallesPeliculas : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesPeliculasBinding
    private lateinit var pelicula: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        //binding.tvDetalleTitulo.setText(pelicula.titulo)
        Picasso.get().load(pelicula.URL).into(binding.ivDetallePelicula)
        binding.tvDetallesTelefono.setText(pelicula.telefonoDirector)
        binding.tvDetallesDirector.setText(pelicula.director)

        if(pelicula !=null) setTitle(pelicula.titulo)
        else setTitle("Nueva Pelicula")
    }
    //Asignar el Menu a la página De añadir pelicula
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_pelicula,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save_or_update -> {
                Toast.makeText(this, "Pelicula guardada correctamente.", Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            R.id.action_delete->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Eliminar Pelicula")
                    .setMessage("La película seleccionada va a ser eliminada, ¿está seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        //Eliminar Pelicula
                        App.peliculas.remove(pelicula)
                        Toast.makeText(this, "Pelicula eliminada.", Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton("Cancelar", null)
                    .show()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
        return false
    }
}
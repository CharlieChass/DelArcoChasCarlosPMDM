package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.App
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityAddPeliculaBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula


class AddPeliculaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPeliculaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btAAdirPelicula.setOnClickListener() {
            if (binding.TieTitulo == null) {
                Toast.makeText(this, "Rellena Titulo", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.TiePuntuacion.text.toString() != "") {
                    App.peliculas.add(
                        Pelicula(
                            binding.TieTitulo.text.toString(),
                            binding.TieGenero.text.toString(),
                            binding.TieDirector.text.toString(),
                            //binding.TiePuntuacion.text.toString().toDouble(),
                            2.5,
                            binding.TieNumeroDirector.text.toString(),
                            binding.TieURL.text.toString(),
                            binding.tvAddResumen.text.toString()
                        )
                    )
                    Toast.makeText(this, "Pelicula Añadida", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    //Crear AlertDialog
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Faltan Datos")
                        .setMessage("Añade datos al texto")
                        .setPositiveButton("Aceptar") { view, _ ->
                            view.dismiss()
                        }
                        .setCancelable(false)
                        .create()
                    dialog.show()
                }
            }
        }
    }
}
package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Intent
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

        val pelicula = intent.getSerializableExtra("pelicula") as Pelicula?


        if (pelicula == null) {//Añadir PELICULA
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
                                binding.TiePuntuacion.text.toString().toDouble(),
                                binding.TieNumeroDirector.text.toString(),
                                binding.TieURL.text.toString(),
                                binding.TieResumen.text.toString()
                            )
                        )
                        Toast.makeText(this, "Pelicula Añadida", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
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
        } else {//Editar PELICULA

            rellenarEditadoPelicula(pelicula)

            binding.btAAdirPelicula.setOnClickListener() {
                val nuevaPelicula: Pelicula

                nuevaPelicula = Pelicula(
                    binding.TieTitulo.text.toString(),
                    binding.TieGenero.text.toString(),
                    binding.TieDirector.text.toString(),
                    binding.TiePuntuacion.text.toString().toDouble(),
                    binding.TieNumeroDirector.text.toString(),
                    binding.TieURL.text.toString(),
                    binding.TieResumen.text.toString()
                )

                val p = App.peliculas.find { it.titulo == pelicula.titulo }?.apply {
                    titulo = nuevaPelicula.titulo
                    genero = nuevaPelicula.genero
                    director = nuevaPelicula.director
                    telefonoDirector = nuevaPelicula.telefonoDirector
                    nota = nuevaPelicula.nota
                    URL = nuevaPelicula.URL
                    resumen = nuevaPelicula.resumen
                }
                finish()

                //App.peliculas.find{it.titulo == pelicula.titulo}?.titulo = nuevaPelicula.titulo
                //App.peliculas.find{it.genero == pelicula.genero}?.genero = nuevaPelicula.genero
                //App.peliculas.find{it.director == pelicula.director}?.director = nuevaPelicula.director
                //App.peliculas.find{it.telefonoDirector == pelicula.telefonoDirector}?.telefonoDirector = nuevaPelicula.telefonoDirector
                //App.peliculas.find{it.nota == pelicula.nota}?.nota = nuevaPelicula.nota
                //App.peliculas.find{it.URL == pelicula.URL}?.URL = nuevaPelicula.URL
                //App.peliculas.find{it.resumen == pelicula.resumen}?.resumen = nuevaPelicula.resumen
            }
        }
    }
    fun rellenarEditadoPelicula(pelicula: Pelicula){
        binding.TieTitulo.setText(pelicula.titulo)
        binding.TieDirector.setText(pelicula.director)
        binding.TieGenero.setText(pelicula.genero)
        binding.TieNumeroDirector.setText(pelicula.telefonoDirector)
        binding.TiePuntuacion.setText(pelicula.nota.toString())
        binding.TieURL.setText(pelicula.URL)
        binding.TieResumen.setText(pelicula.resumen)
    }
}


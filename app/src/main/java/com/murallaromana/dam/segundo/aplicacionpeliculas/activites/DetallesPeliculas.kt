package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.murallaromana.dam.segundo.aplicacionpeliculas.R
import com.murallaromana.dam.segundo.aplicacionpeliculas.RetrofitClient
import com.murallaromana.dam.segundo.aplicacionpeliculas.adapters.ListaPeliculasAdapter
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityDetallesPeliculasBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.Preferences
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.murallaromana.dam.segundo.aplicacionpeliculas.utils.Alertas
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetallesPeliculas : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesPeliculasBinding
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this
        val layoutManager = LinearLayoutManager(this)
        var id = intent.getStringExtra("id")

        //CONFIGURAR RETROFIT
        pref = Preferences(applicationContext)

        val llamadaApi =
            RetrofitClient.apiRetrofit.getById("Bearer " + pref.recogerToken(), id)
        llamadaApi.enqueue(object : Callback<Pelicula> {
            override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                Log.d("respuesta: onResponse", response.toString())

                val pelicula = response.body()
                //        val adapter = ListaPeliculasAdapter(pelicula, context)
                if (pelicula != null) {
                    Picasso.get().load(pelicula.URL).into(binding.ivDetallePelicula)
                    binding.tvDetallesTelefono.setText(pelicula.telefonoDirector)
                    binding.tvDetallesDirector.setText(pelicula.director)
                    binding.tvResumen.setText(pelicula.resumen)
                    title = pelicula.titulo
                }

//            LLamada Director
                binding.tvDetallesTelefono.setOnClickListener() {
                    val intent2 = Intent(Intent.ACTION_DIAL)
                    intent2.data = Uri.parse("tel:" + binding.tvDetallesTelefono.text.toString())
                    startActivity(intent2)
                }
            }

            override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }
        })
    }

    //Asignar el Menu a la página De añadir pelicula
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_pelicula, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save_or_update -> {
                val intent = Intent(this, AddPeliculaActivity::class.java)

                //TODO Aqui tenemos que hacer los putExtra con datos de la pelicula
                //igual que en el adapter de la lista para pasar los datos

                //intent.putExtra("pelicula", pelicula)

                //Iniciar la activity
                startActivity(intent)
                true
            }
            R.id.action_delete -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Eliminar Pelicula")
                    .setMessage("La película seleccionada va a ser eliminada, ¿está seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->

                        //Eliminar Pelicula
                        var id = intent.getStringExtra("id")
                        val llamadaApi =
                            RetrofitClient.apiRetrofit.delete("Bearer " + pref.recogerToken(), id)
                        llamadaApi.enqueue(object : Callback<Pelicula> {
                            override fun onResponse(
                                call: Call<Pelicula>,
                                response: Response<Pelicula>
                            ) {
                                Log.d("respuesta: onResponse", response.toString())

                            }

                            override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                                Log.d("respuesta: onFailure", t.toString())
                            }
                        })

                        Toast.makeText(this, "Pelicula eliminada.", Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton("Cancelar", null)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return false
    }

    //Mostrar cambios al editar la pelicula
    // override fun onResume() {
    //  super.onResume()
    //  binding.tvDetallesTelefono.setText(pelicula.telefonoDirector)
    //  binding.tvDetallesDirector.setText(pelicula.director)
    //  binding.tvResumen.setText(pelicula.resumen)
    //  title = pelicula.titulo
    //  }
}
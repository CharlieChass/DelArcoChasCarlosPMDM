package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.murallaromana.dam.segundo.aplicacionpeliculas.RetrofitClient
import com.murallaromana.dam.segundo.aplicacionpeliculas.adapters.ListaPeliculasAdapter
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.PeliculasActivityBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.Preferences
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {
    private lateinit var binding: PeliculasActivityBinding
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeliculasActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this
        val layoutManager = LinearLayoutManager(this)

        binding.fabAAdir.setOnClickListener() {
            val intent = Intent(this, AddPeliculaActivity::class.java)
            startActivity(intent)
        }


        //CONFIGURAR API-RETROFIT
        pref = Preferences(applicationContext)
        val llamadaApi: Call<List<Pelicula>> =
            RetrofitClient.apiRetrofit.getPeliculas("Bearer " + pref.recogerToken())
        llamadaApi.enqueue(object : Callback<List<Pelicula>> {
            override fun onResponse(
                call: Call<List<Pelicula>>,
                response: Response<List<Pelicula>>
            ) {
                val listPeliculas = response.body()

                //Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()

                val adapter = ListaPeliculasAdapter(listPeliculas, context)
                binding.rvPeliculas.adapter = adapter
                binding.rvPeliculas.layoutManager = layoutManager
            }

            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("Prueba", t.message.toString())
            }

        })
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
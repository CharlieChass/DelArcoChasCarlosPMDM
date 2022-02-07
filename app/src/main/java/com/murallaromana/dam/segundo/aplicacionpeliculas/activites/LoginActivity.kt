package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.RetrofitClient
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityMainBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.data.Preferences
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Token
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = Preferences(applicationContext)
        val context = this

        binding.tieCorreo.setText("carlosPrueba1@gmail.com")
        binding.tieContraseA.setText("1234")

        //Crear Cuenta
        binding.btCrear.setOnClickListener() {
            val intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btAceptar.setOnClickListener() {
            binding.btAceptar.isEnabled=false

            val email = binding.tieCorreo.text.toString()
            val contraseña = binding.tieContraseA.text.toString()

            if (binding.tieCorreo.text.toString().length == 0 || binding.tieContraseA.text.toString().length == 0) {
                val adb = AlertDialog.Builder(this)
                adb.setTitle("Datos Incorrectos")
                adb.setMessage("Usuario o Contraseña vacio")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else {
                val call: Call<Token> = RetrofitClient.apiRetrofit.login(Usuario(null, email, contraseña))

                call.enqueue(object : Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Log.d("respuesta: onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        Log.d("respuesta: onResponse", response.toString())
                        if (response.code() > 299 || response.code() < 200) {
                            val adb = AlertDialog.Builder(context)
                            adb.setTitle("Inicio Fallido")
                            adb.setMessage("El usuario o la contraseña no coinciden")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                        } else {
                            val token = response.body()?.token.toString()
                            sharedPref.guardar(token)
                            val intent = Intent(context, PeliculasActivity::class.java)
                            startActivity(intent)

                        }
                    }
                })
            }
        }
    }

}



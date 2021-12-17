package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityMainBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Crear Cuenta
        binding.btCrear.setOnClickListener() {
            abrirRegistro()
        }

        val sharedPref = getSharedPreferences("peliculas", Context.MODE_PRIVATE)
        val email = sharedPref.getString("email", "")
        val contraseña = sharedPref.getString("password","")
        binding.tieCorreo.setText(email)

        binding.btAceptar.setOnClickListener() {
            if (binding.tieCorreo.text.toString() == email && binding.tieContraseA.text.toString() == contraseña) {
                abrirListaPeliculas()
            } else {
                mensajeCorreoNoValido()
            }
        }
    }

    fun abrirListaPeliculas(){
        val intent = Intent(this, PeliculasActivity::class.java)
        startActivity(intent)
    }

    fun abrirRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }

    fun mensajeCorreoNoValido() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Error de Autentificación")
            .setMessage("El Correo o la Contraseña no son correctos")
            .setPositiveButton("Aceptar") { view, _ ->
                binding.tieCorreo.setText("")
                view.dismiss()
            }
            .setCancelable(false)
            .create()
        dialog.show()
    }
}
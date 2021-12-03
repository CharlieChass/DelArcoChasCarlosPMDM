package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCrear.setOnClickListener() {

            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        val sharedPref = getSharedPreferences("peliculas", Context.MODE_PRIVATE)
        val email = sharedPref.getString("email", "")
        binding.tieCorreo.setText(email)
        binding.btAceptar.setOnClickListener() {

            if (binding.tieCorreo.text.toString() == email) {
                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
            } else {
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Correo no es valido")
                    .setMessage("Ese correo no esta Registrado")
                    .setPositiveButton("Aceptar") { view, _ ->
                        binding.tieCorreo.setText("")
                        view.dismiss()
                    }
                    .setCancelable(false)
                    .create()
                dialog.show()
            }
        }
    }
}
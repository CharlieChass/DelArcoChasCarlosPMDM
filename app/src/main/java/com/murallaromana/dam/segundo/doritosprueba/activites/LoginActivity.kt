package com.murallaromana.dam.segundo.doritosprueba.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.murallaromana.dam.segundo.doritosprueba.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("doritos-prueba", Context.MODE_PRIVATE)
        val email = sharedPref.getString("gmail", "")
        Log.d("MainActivity", "Email cargado: ${email}")
        binding.ettGmail.setText(email)

        binding.btCrear.setOnClickListener(){

            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

            binding.btAceptar.setOnClickListener() {
                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
            }
    }
}
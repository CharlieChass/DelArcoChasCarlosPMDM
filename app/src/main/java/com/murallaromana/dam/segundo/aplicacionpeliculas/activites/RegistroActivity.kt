package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.RegistroActivityBinding

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: RegistroActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCuenta.setOnClickListener {
            val sharedPref = getSharedPreferences("doritos-prueba", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.putString("gmail",binding.tieGmail.text.toString())
            editor.putString("password",binding.ettCrearContraseA.text.toString())
            editor.commit()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
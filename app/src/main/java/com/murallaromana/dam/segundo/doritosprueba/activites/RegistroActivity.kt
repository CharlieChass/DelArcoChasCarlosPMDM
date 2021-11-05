package com.murallaromana.dam.segundo.doritosprueba.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.murallaromana.dam.segundo.doritosprueba.databinding.SegundaActivityBinding

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: SegundaActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SegundaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCuenta.setOnClickListener {
            val sharedPref = getSharedPreferences("doritos-prueba", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            Toast.makeText(this, "Email:" + binding.tieGmail.text.toString(), Toast.LENGTH_SHORT).show()

            editor.putString("gmail",binding.tieGmail.text.toString())
            editor.putString("password",binding.ettCrearContraseA.text.toString())
            editor.commit()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
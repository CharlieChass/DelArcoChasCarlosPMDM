package com.murallaromana.dam.segundo.doritosprueba

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murallaromana.dam.segundo.doritosprueba.databinding.SegundaActivityBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: SegundaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SegundaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCuenta.setOnClickListener() {
            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("gmail",binding.tieGmail.text.toString())
            editor.putString("password",binding.ettCrearContraseA.text.toString())
            editor.commit()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
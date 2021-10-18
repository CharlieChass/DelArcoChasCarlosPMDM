package com.murallaromana.dam.segundo.doritosprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murallaromana.dam.segundo.doritosprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCrear.setOnClickListener(){

            val intent = Intent(this,SegundaActivity::class.java)
            startActivity(intent)
            binding.ettGmail.setText("")
            binding.ettContraseA.setText("")
        }
    }
}
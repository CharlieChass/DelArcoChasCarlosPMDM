package com.murallaromana.dam.segundo.doritosprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murallaromana.dam.segundo.doritosprueba.databinding.SegundaActivityBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: SegundaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SegundaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCuenta.setOnClickListener(){

}
    }
}
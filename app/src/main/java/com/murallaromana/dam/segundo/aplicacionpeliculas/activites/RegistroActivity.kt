package com.murallaromana.dam.segundo.aplicacionpeliculas.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.murallaromana.dam.segundo.aplicacionpeliculas.RetrofitClient
import com.murallaromana.dam.segundo.aplicacionpeliculas.databinding.RegistroActivityBinding
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Token
import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: RegistroActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this

        binding.tieCorreo.setText("carlosPrueba1@gmail.com")
        binding.ettCrearContraseA.setText("1234")

        binding.btCuenta.setOnClickListener {

            val email = binding.tieCorreo.text.toString()
            val contraseña = binding.ettCrearContraseA.text.toString()
            if (binding.tieCorreo.text.toString().length == 0 || binding.ettCrearContraseA.text.toString().length == 0) {
                alerta("fallo")
                val adb = AlertDialog.Builder(this)
                adb.setTitle("Añade Correo o contraseña")
                adb.setMessage("Correo o Contraseña vacio")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else {
                val call: Call<Usuario> = RetrofitClient.apiRetrofit.signup(Usuario(null, email, contraseña))

                call.enqueue(object : Callback<Usuario> {
                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Log.d("respuesta: onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        Log.d("respuesta: onResponse", response.toString())
                        if (response.code() > 299 || response.code() < 200) {
                            val adb = AlertDialog.Builder(context)
                            adb.setTitle("Registro fallido")
                            adb.setMessage("Usuario o contraseña Mal")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                        } else {
                            val intent = Intent(context, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    }
                })
            }
        }
    }
    fun alerta(mensaje : String){
        val adb = AlertDialog.Builder(this)
        adb.setTitle("Añade Correo o contraseña")
        adb.setMessage(mensaje)
        adb.setPositiveButton("Aceptar",null)
        adb.show()
    }

}
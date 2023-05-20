package com.example.application_3.WI

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.application_3.BASE_DATOS.Constantes
import com.example.application_3.MainActivity
import com.example.application_3.R
import com.example.application_3.VIEWMODEL.FormularioViewModel
import com.example.application_3.databinding.ActivityFormularioMainBinding
import org.checkerframework.checker.units.qual.s
import kotlin.reflect.KClass

class FormularioMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormularioMainBinding
    lateinit var viewModel: FormularioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFormularioMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get()
        viewModel.OPERACION= intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo=viewModel
        binding.lifecycleOwner=this

        viewModel.operacionExitosa.observe(this, Observer {
            if (it){
                mostrarMensaje("Operación Exitosa")
                irAlInicio()
            }else{
                mostrarMensaje("Ocurrió un error...")
            }
        })
    }

    private fun mostrarMensaje(s: String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
        TODO("Not yet implemented")
    }
    private fun irAlInicio(){
        val intent=Intent(applicationContext,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

//    private fun Intent(
//        applicationContext: Context?,
//        kClass: KClass<MainActivity>,
//        java: Any
//    ): Intent {
//        TODO("Not yet implemented")
//    }
}
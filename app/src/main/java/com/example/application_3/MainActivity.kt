package com.example.application_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application_3.ADAPTADORES.PersonalAdapter
import com.example.application_3.BASE_DATOS.Constantes
import com.example.application_3.VIEWMODEL.MainViewModel
import com.example.application_3.WI.FormularioMainActivity
import com.example.application_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel=ViewModelProvider(this).get()
        viewModel.iniciar()

        binding.miRecycler.apply {
            layoutManager=LinearLayoutManager(applicationContext)
        }

        viewModel.personalList.observe(this, Observer {
            binding.miRecycler.adapter= it?.let { it1 -> PersonalAdapter(it1) }
        })

        binding.botonFormularioMain.setOnClickListener {
            val intent = Intent(this,FormularioMainActivity::class.java)
            intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_INSERTAR)
            startActivity(intent)
        }
//
//            val name = binding.idNombre.text.toString()
//            val email = binding.idEmail.text.toString()
//            if (name.isNotBlank() && email.isNotBlank()){
//                val prefs = getSharedPreferences("credenciales", MODE_PRIVATE)
//                val editor = prefs.edit()
//
//                editor.putString("name",name)
//                editor.putString("email",email)
//                editor.apply() //para guargar los datos
//
//                val name2= prefs.getString("name",null)
//                val email2 = prefs.getString("email",null)
//
//                binding.showData.text = "Hola, $name2 \n Email : $email2 "
//
//            }
//        }


    }


}
package com.example.application_3.VIEWMODEL

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_3.BASE_DATOS.Constantes
import com.example.application_3.BASE_DATOS.PersonalApp.Companion.db
import com.example.application_3.TABLAS.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormularioViewModel:ViewModel() {
    var iddni = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var lenguajes = MutableLiveData<String>()
    var OPERACION :String = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        iddni.value = 11111111
    }

    fun guardarUsuarios(){
        var mPersonal= Personal("0",nombre.value!!,email.value!!, lenguajes = String())
        when(OPERACION){
            Constantes.OPERACION_INSERTAR->{
                    //PARA INSERTAR EN BASE DE DATOS
                    Log.d("mensaje", "nombre ${nombre.value}")
                    Log.d("mensaje", "email ${nombre.value}")
                viewModelScope.launch {
                    val result = withContext(Dispatchers.IO){
                        db.personalDao().insert(
                            arrayListOf<Personal>(
                                mPersonal
                            )
                        )
                    }
                    operacionExitosa.value=result.isNotEmpty()
                }
            }
            Constantes.OPERACION_EDITAR-> {
            }

        }
    }
}
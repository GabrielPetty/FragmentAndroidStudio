package com.example.application_3.VIEWMODEL

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_3.BASE_DATOS.PersonalApp.Companion.db
import com.example.application_3.TABLAS.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {
    val personalList=MutableLiveData<List<Personal>??>()
    var parametroBusqueda = MutableLiveData<String>()

    fun iniciar(){
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO){
//                db.personalDao().insert(arrayListOf<Personal>(
//                    Personal(23769652, "ale","g.a.petty@gmail.com","kotlin")
//                ))
                db.personalDao().getAll()
            }
//            for (personal in personalList.value!!){
//                Log.d("mensaje","id ${personal.iddni},nombre ${personal.nombre}")
//            }

        }
    }
}
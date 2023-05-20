package com.example.application_3.BASE_DATOS

import android.app.Application
import androidx.room.Room

class PersonalApp:Application() {
    companion object{
        lateinit var db : BdPersonal

    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            BdPersonal::class.java,
            "personal"
        ).build()
    }
}
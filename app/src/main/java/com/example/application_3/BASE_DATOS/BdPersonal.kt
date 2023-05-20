package com.example.application_3.BASE_DATOS

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.application_3.DAO.PersonalDao
import com.example.application_3.TABLAS.Personal

@Database(
    entities = [Personal::class],
    version = 1
)
abstract class BdPersonal:RoomDatabase() {
    abstract fun personalDao():PersonalDao
}
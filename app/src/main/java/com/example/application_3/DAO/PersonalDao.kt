package com.example.application_3.DAO

import androidx.room.*
import com.example.application_3.TABLAS.Personal

@Dao

interface PersonalDao {
    @Query("SELECT * FROM Personal")
    suspend fun getAll():List<Personal>

    @Insert
    suspend fun insert(personas:List<Personal>):List<String>

    @Update
    suspend fun update(personal: Personal):Int

    @Delete
    suspend fun delete(personal: Personal):Int
    fun insert(personas: List<Personal>, continuation: error.NonExistentClass): Any

}
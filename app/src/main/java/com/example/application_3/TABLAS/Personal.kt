package com.example.application_3.TABLAS

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  Personal(
    @PrimaryKey()
    val iddni: String,
    var nombre:String,
    var email:String,
    var lenguajes:String
)
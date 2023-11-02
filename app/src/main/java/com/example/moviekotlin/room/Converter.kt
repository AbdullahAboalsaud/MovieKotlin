package com.example.moviekotlin.room

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {


    @TypeConverter
    fun toJson(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @SuppressLint("SuspiciousIndentation")
    @TypeConverter
    fun fromJson(json: String): List<Int> {
        val list = object : TypeToken<List<Int>>(){}.type
            return Gson().fromJson(json,list)
    }



}
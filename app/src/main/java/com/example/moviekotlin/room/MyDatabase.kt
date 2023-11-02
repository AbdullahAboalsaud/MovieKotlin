package com.example.moviekotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviekotlin.models.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(Converter::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getDao(): MyDao

    companion object {
        private lateinit var myDatabase: MyDatabase


        fun initDatabase(context: Context) {
            myDatabase = Room.databaseBuilder(
                context,
                MyDatabase::class.java, "movies_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        fun getMyDatabase(): MyDatabase {
            return myDatabase
        }
    }

}
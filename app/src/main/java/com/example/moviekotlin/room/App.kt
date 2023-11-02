package com.example.moviekotlin.room

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyDatabase.initDatabase(this)
    }
}
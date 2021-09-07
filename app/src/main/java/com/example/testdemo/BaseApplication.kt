package com.example.testdemo

import android.app.Application

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

       // MediaResizerGlobal.initializeApplication(this)
    }
}
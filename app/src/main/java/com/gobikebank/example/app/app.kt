package com.gobikebank.example.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class app : Application() {
    override fun onCreate() {
        super.onCreate()

//        NaverMapSdk.getInstance(this).client =
//            NaverMapSdk.NaverCloudPlatformClient(NAVER_MAP_CLIENT_ID)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
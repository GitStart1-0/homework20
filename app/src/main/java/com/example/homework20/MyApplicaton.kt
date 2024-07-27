package com.example.homework20

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication : Application() {

	var sharedPrefs: SharedPreferences? = null

	override fun onCreate() {
		super.onCreate()
		instance = this
		sharedPrefs = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE)
	}

	companion object {
		private lateinit var instance: MyApplication

		fun getApplication() = instance

		const val MY_SHARED_PREFS = "myPrefs"
	}
}

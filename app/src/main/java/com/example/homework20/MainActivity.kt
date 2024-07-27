package com.example.homework20

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	private lateinit var valueTextView: TextView
	private lateinit var incrementButton: Button
	private var count: Int = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		valueTextView = findViewById(R.id.valueTextView)
		incrementButton = findViewById(R.id.incrementButton)

		// Відновлення значення з SharedPreferences
		count = MyApplication.getApplication().sharedPrefs?.getInt(COUNT_KEY, 0) ?: 0
		updateValueTextView()

		incrementButton.setOnClickListener {
			count++
			updateValueTextView()
			// Збереження значення в SharedPreferences
			MyApplication.getApplication().sharedPrefs?.edit()?.putInt(COUNT_KEY, count)?.apply()
		}
	}

	private fun updateValueTextView() {
		valueTextView.text = count.toString()
	}

	companion object {
		private const val COUNT_KEY = "countKey"
	}
}

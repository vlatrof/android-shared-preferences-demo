package com.example.androidsharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidsharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(App.APP_PREFERENCES, Context.MODE_PRIVATE)
        renderSharedPreferencesData()
        binding.btnSaveData.setOnClickListener { onClickSaveDataButton() }
        sharedPreferences.registerOnSharedPreferenceChangeListener

    }

    private fun renderSharedPreferencesData() {
        val data = sharedPreferences.getString(App.PREFERENCES_VALUE, "")
        binding.tvSharedPreferencesData.text = data
    }

    private fun onClickSaveDataButton() {

        val value = binding.etData.text.toString()

        sharedPreferences
            .edit()
            .putString(App.PREFERENCES_VALUE, value)
            .commit()

    }

}
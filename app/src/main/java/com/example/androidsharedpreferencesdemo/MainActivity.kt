package com.example.androidsharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androidsharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(App.APP_PREFERENCES, Context.MODE_PRIVATE)
        loadDataFromSharedPreferences()
        binding.btnSaveData.setOnClickListener { onClickSaveDataButton() }

    }

    private fun loadDataFromSharedPreferences() {
        binding.etData.setText(
            sharedPreferences.getString(App.PREF_EDIT_TEXT_VALUE, "[default]"))
    }

    private fun onClickSaveDataButton() {

        val value = binding.etData.text.toString()

        sharedPreferences
            .edit()
            .putString(App.PREF_EDIT_TEXT_VALUE, value)
            .apply()

    }

}
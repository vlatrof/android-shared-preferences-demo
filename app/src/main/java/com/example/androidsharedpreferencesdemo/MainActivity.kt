package com.example.androidsharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidsharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPreferencesChangeListener = initSharedPreferencesListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(App.APP_PREFERENCES, Context.MODE_PRIVATE)
        renderSharedPreferencesData()
        binding.btnSaveData.setOnClickListener { onClickSaveDataButton() }
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesChangeListener)

    }

    override fun onDestroy() {
        super.onDestroy()

        sharedPreferences.unregisterOnSharedPreferenceChangeListener(sharedPreferencesChangeListener)
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
            .apply()

    }

    private fun initSharedPreferencesListener(): SharedPreferences.OnSharedPreferenceChangeListener {

        val listener = SharedPreferences.OnSharedPreferenceChangeListener {
                _, _ ->
            // it this case we will ignore key because we have only one sharedPreferences key
            onSharedPreferencesDataChange()
        }

        return listener

    }

    private fun onSharedPreferencesDataChange() {

        Toast.makeText(
            this,
            getString(R.string.toast_message_shared_preferences_data_changed),
            Toast.LENGTH_SHORT
        ).show()

        renderSharedPreferencesData()

    }

}
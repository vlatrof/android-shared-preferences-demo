package com.example.androidsharedpreferencesdemo

import android.app.Application

class App : Application() {

    companion object {

        const val APP_PREFERENCES = "APP_PREFERENCES"
        const val PREF_EDIT_TEXT_VALUE = "PREF_EDIT_TEXT_VALUE"

    }

}
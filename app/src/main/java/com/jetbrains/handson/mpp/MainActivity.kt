package com.jetbrains.handson.mpp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jetbrains.handson.mpp.mobile.ApplicationApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationApi = ApplicationApi()

        applicationApi.about { about: String ->
            findViewById<TextView>(R.id.main_text).text = about
        }
    }
}

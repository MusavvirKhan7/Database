package com.example.database

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class welcomeactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcomeactivity)

        val email = intent.getStringExtra(Signin.KEY1)
        val name = intent.getStringExtra(Signin.KEY2)
        val password = intent.getStringExtra(Signin.KEY3)

        val welcometext = findViewById<TextView>(R.id.welcome2)
        val infobtn = findViewById<Button>(R.id.btnmail)
        val infobtn2 = findViewById<Button>(R.id.btnname)

        welcometext.text = "Welcome : $name"
        infobtn.text = "Mail : $email"
        infobtn2.text = "Password : $password"


    }
}
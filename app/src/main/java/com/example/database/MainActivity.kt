package com.example.database

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    lateinit var Database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val signupbtn= findViewById<Button>(R.id.SignUPbtn)
        val etname= findViewById<TextInputEditText>(R.id.name)
        val etmail= findViewById<TextInputEditText>(R.id.etmail)
        val etpass= findViewById<TextInputEditText>(R.id.etpassword)

        signupbtn.setOnClickListener{
            val name = etname.text.toString()
            val mail = etmail.text.toString()
            val pass = etpass.text.toString()

            val user = Users(name, mail, pass)
            Database = FirebaseDatabase.getInstance().getReference("Users")

            Database.child(name).setValue(user).addOnSuccessListener {

            Toast.makeText(this,"user registered", Toast.LENGTH_SHORT).show()
            }


        }
        val signintext = findViewById<TextView>(R.id.signinex)
        signintext.setOnClickListener{
            val Signin = Intent(this, Signin::class.java)
            startActivity(Signin)


        }
    }
}
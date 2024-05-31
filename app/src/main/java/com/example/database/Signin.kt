package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1 = "com.example.database.Signin.email"
        const val KEY2 = "com.example.database.Signin.name"
        const val KEY3 = "com.example.database.Signin.password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)

        val signInButton = findViewById<Button>(R.id.SignINbtn)
        val username = findViewById<TextInputEditText>(R.id.name2)
        val password = findViewById<TextInputEditText>(R.id.etpassword2)

        signInButton.setOnClickListener {
            val usernameString = username.text.toString()
            if (usernameString.isNotEmpty()) {
                readData(usernameString)
            } else {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
            }
            val passwordString = password.text.toString()
            if (passwordString.isNotEmpty()) {
                readData(passwordString)
            }
            else{
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
            }
        }
    }//on create end
    private fun readData(usernamenpass: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(usernamenpass).get().addOnSuccessListener {
            if(it.exists()) {
                // wwlcome user in app, with intent and pass
                val email = it.child("email").value
                val name = it.child("name").value
                val password = it.child("password").value

                val intentWelcome = Intent(this, welcomeactivity::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, password.toString())
                startActivity(intentWelcome)
            }
            else {
                Toast.makeText(this, "User Does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "sign in failed", Toast.LENGTH_SHORT).show()
        }

    }

}


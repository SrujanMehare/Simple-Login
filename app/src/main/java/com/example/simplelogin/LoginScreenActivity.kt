package com.example.simplelogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginScreenActivity : AppCompatActivity() {
    private val userName = "admin"
    private val password = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)


        val userN: TextView = findViewById(R.id.editTextTextPersonName)
        val button: Button = findViewById(R.id.button)
        val pass: TextView = findViewById(R.id.editTextTextPassword)
        button.setOnClickListener {
            if (userN.text.toString() == userName && pass.text.toString() == password) {
                val intent = Intent(this@LoginScreenActivity,HomeScreenActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Enter Valid Credentials", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }



//                val intent = Intent(this, HomeScreenActivity::class.java)
//                Toast.makeText(this@MainActivity, "Login Successfull", Toast.LENGTH_SHORT).show()
//                startActivity(intent)

    }




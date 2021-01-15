package com.example.week6softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etusername=findViewById(R.id.etusername)
        etpassword=findViewById(R.id.etpassword)
        btnlogin=findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            if (etusername.text.toString() == "softwarica" && etpassword.text.toString() == "coventry"){
                Toast.makeText(this,"Login Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java));
            }
            else
            {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
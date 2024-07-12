package com.example.assignment1_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1_app.data.User

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

            val etName = findViewById<EditText>(R.id.etName)
            val etAge = findViewById<EditText>(R.id.etAge)
            val etSex = findViewById<EditText>(R.id.etSex)
            val etPhone = findViewById<EditText>(R.id.etPhone)
            val etEmail = findViewById<EditText>(R.id.etEmail)

            val name = etName.text.toString()
            val age = etAge.text.toString().toIntOrNull() ?: 0
            val sex = etSex.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()

            val user = User(name, age, sex, phone, email)

            val resultIntent = Intent()
            resultIntent.putExtra("user", user)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
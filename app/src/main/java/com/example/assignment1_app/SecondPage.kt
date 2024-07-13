package com.example.assignment1_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            callActivity()
        }
    }

    private fun callActivity() {
        val name = findViewById<EditText>(R.id.etName).text.toString()
        val age = findViewById<EditText>(R.id.etAge).text.toString()
        val sex = findViewById<EditText>(R.id.etSex).text.toString()
        val phone = findViewById<EditText>(R.id.etPhone).text.toString()
        val email = findViewById<EditText>(R.id.etEmail).text.toString()

        val resultIntent = Intent().apply {
            putExtra("Passed_Name", name)
            putExtra("Passed_Age", age)
            putExtra("Passed_Sex", sex)
            putExtra("Passed_Phone", phone)
            putExtra("Passed_Email", email)
        }

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}

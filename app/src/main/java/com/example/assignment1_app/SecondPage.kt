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
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etSex = findViewById<EditText>(R.id.etSex)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etEmail = findViewById<EditText>(R.id.etEmail)

        val name = etName.text.toString()
        val age = etAge.text.toString()
        val sex = etSex.text.toString()
        val phone = etPhone.text.toString()
        val email = etEmail.text.toString()

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

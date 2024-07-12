package com.example.assignment1_app

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondPage : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etJob: EditText
    private lateinit var etSex: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etSex = findViewById(R.id.etSex)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)

        val submitButton: Button = findViewById(R.id.btnSubmit)
        submitButton.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()
            val job = etJob.text.toString()
            val sex = etSex.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()

            val intent = Intent()
            intent.putExtra("userName", name)
            intent.putExtra("userAge", age)
            intent.putExtra("userJob", job)
            intent.putExtra("userSex", sex)
            intent.putExtra("userPhone", phone)
            intent.putExtra("userEmail", email)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
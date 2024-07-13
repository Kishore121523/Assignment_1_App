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

        // When Submit button is clicked, using setOnClickListener getDataFromUser is called
        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            getDataFromUser()
        }
    }

    // This function gets the data from each of the EditText and pass it to the MainActivity.kt
    private fun getDataFromUser() {
        val name = findViewById<EditText>(R.id.editName).text.toString()
        val age = findViewById<EditText>(R.id.editAge).text.toString()
        val sex = findViewById<EditText>(R.id.editSex).text.toString()
        val phone = findViewById<EditText>(R.id.editPhone).text.toString()
        val email = findViewById<EditText>(R.id.editEmail).text.toString()

        val resultIntent = Intent().apply {
            putExtra("Passed_Name", name)
            putExtra("Passed_Age", age)
            putExtra("Passed_Sex", sex)
            putExtra("Passed_Phone", phone)
            putExtra("Passed_Email", email)
        }

        // The result status is checked in the MainActivity.kt
        setResult(Activity.RESULT_OK, resultIntent)

        // Returns to the first activity after all the process are completed
        finish()
    }
}

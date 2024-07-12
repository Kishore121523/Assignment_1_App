package com.example.assignment1_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: ViewGroup
    private val SECOND_PAGE_REQUEST_CODE = 1 // Define your request code here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.containerView)

        val addUserButton: Button = findViewById(R.id.btn1)
        addUserButton.setOnClickListener {
            val intent = Intent(this, SecondPage::class.java)
            startActivityForResult(intent, SECOND_PAGE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECOND_PAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Retrieve user details from intent data
            val name = data?.getStringExtra("userName") ?: ""
            val age = data?.getStringExtra("userAge") ?: ""
            val job = data?.getStringExtra("userJob") ?: ""
            val sex = data?.getStringExtra("userSex") ?: ""
            val phone = data?.getStringExtra("userPhone") ?: ""
            val email = data?.getStringExtra("userEmail") ?: ""

            // Create and add a card view with user details
            val userCard = createCardView(name, age, job, sex, phone, email)
            containerView.addView(userCard)
        }
    }

    private fun createCardView(name: String, age: String, job: String, sex: String, phone: String, email: String): CardView {
        val cardView = CardView(this)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        cardView.layoutParams = layoutParams

        val textView = TextView(this)
        textView.text = "Name: $name\nAge: $age\nJob: $job\nSex: $sex\nPhone: $phone\nEmail: $email"
        textView.setPadding(16, 16, 16, 16)

        cardView.addView(textView)
        return cardView
    }
}

package com.example.assignment1_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1_app.data.User

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: LinearLayout

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val user: User? = result.data?.getParcelableExtra("user")
                user?.let { addCard(it) }
            } else {
                Log.d("MainActivity", "Activity result not OK")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.containerView)

        findViewById<Button>(R.id.btnAddUser).setOnClickListener { onAddUserClick(it) }
    }

    private fun onAddUserClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startForResult.launch(intent)
    }

    private fun addCard(user: User) {
        val inflater = LayoutInflater.from(this)
        val cardView = inflater.inflate(R.layout.user_card, containerView, false)

        cardView.findViewById<TextView>(R.id.tvName).text = "Name: ${user.name}"
        cardView.findViewById<TextView>(R.id.tvAge).text = "Age: ${user.age}"
        cardView.findViewById<TextView>(R.id.tvSex).text = "Sex: ${user.sex}"
        cardView.findViewById<TextView>(R.id.tvPhone).text = "Phone: ${user.phone}"
        cardView.findViewById<TextView>(R.id.tvEmail).text = "Email: ${user.email}"


        containerView.addView(cardView)
    }
}
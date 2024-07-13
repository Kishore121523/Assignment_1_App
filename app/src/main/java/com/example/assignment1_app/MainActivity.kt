package com.example.assignment1_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: LinearLayout

    private val addUserLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { data ->
                addCard(data)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.containerView)

        val btnAddUser = findViewById<Button>(R.id.btnAddUser)
        btnAddUser.setOnClickListener { onAddUserClick(it) }

        val spinnerBtn: Spinner = findViewById(R.id.spinnerCtrl)
        val options = arrayOf("Enabled", "Disabled")

        spinnerBtn.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinnerBtn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = options[position]
                updateAddUserButton(selectedOption)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Do nothing in this case
            }

            private fun updateAddUserButton(selectedOption: String) {
                when (selectedOption) {
                    "Disabled" -> {
                        btnAddUser.isEnabled = false
                        btnAddUser.setTextColor(getColor(R.color.bgColor)) // Set text color to white
                    }
                    "Enabled" -> {
                        btnAddUser.isEnabled = true
                        btnAddUser.setTextColor(getColor(R.color.accentColor)) // Set text color to accent color
                    }
                }
            }
        }
    }

    private fun onAddUserClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        addUserLauncher.launch(intent)
    }

    private fun addCard(data: Intent) {
        val inflater = LayoutInflater.from(this)
        val cardView = inflater.inflate(R.layout.user_card, containerView, false)

        val name = data.getStringExtra("Passed_Name")
        val age = data.getStringExtra("Passed_Age")
        val sex = data.getStringExtra("Passed_Sex")
        val phone = data.getStringExtra("Passed_Phone")
        val email = data.getStringExtra("Passed_Email")

        cardView.findViewById<TextView>(R.id.tvName).text = "Name: ${name}"
        cardView.findViewById<TextView>(R.id.tvAge).text = "Age: ${age}"
        cardView.findViewById<TextView>(R.id.tvSex).text = "Sex: ${sex}"
        cardView.findViewById<TextView>(R.id.tvPhone).text = "Phone: ${phone}"
        cardView.findViewById<TextView>(R.id.tvEmail).text = "Email: ${email}"

        containerView.addView(cardView)
    }
}

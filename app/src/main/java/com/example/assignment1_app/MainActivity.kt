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

    // Initialise a variable to store the reference for the linear layout that has been created.
    private lateinit var containerView: LinearLayout

    // registerForActivityResult is used to launch the second activity and get result from it back.
    // Normal startActivity function will only launch the next activity but not wait for result
    private val startSecondActivityAndWaitForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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

        // When Add User button is clicked, using setOnClickListener onMainActivityBtnClick is called
        val btnAddUser = findViewById<Button>(R.id.btnAddUser)
        btnAddUser.setOnClickListener { onMainActivityBtnClick(it) }

        // Creating a spinner which disables or enables the Add User button which listens to onItemSelectedListener
        val spinnerBtn: Spinner = findViewById(R.id.spinnerCtrl)
        val options = arrayOf("Enabled", "Disabled")

        spinnerBtn.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinnerBtn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = options[position]
                updateAddUserButton(selectedOption)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                btnAddUser.isEnabled = true //When nothing is selected, make it enabled
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

    // Function called when Add User Button is clicked
    private fun onMainActivityBtnClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startSecondActivityAndWaitForResult.launch(intent) // Launches the second activity and gets the result
    }

    // When the result is obtained from the second activity and if it is not null, then this function is called.
    // This function creates dynamic cards once the user submits their information in the second activity
    private fun addCard(data: Intent) {
        val inflater = LayoutInflater.from(this)
        val cardView = inflater.inflate(R.layout.user_card, containerView, false)

        // The Passes_Name etc, are the names defined for each data in the second activity
        val name = data.getStringExtra("Passed_Name")
        val age = data.getStringExtra("Passed_Age")
        val sex = data.getStringExtra("Passed_Sex")
        val phone = data.getStringExtra("Passed_Phone")
        val email = data.getStringExtra("Passed_Email")

        cardView.findViewById<TextView>(R.id.textName).text = "Name: ${name}"
        cardView.findViewById<TextView>(R.id.textAge).text = "Age: ${age}"
        cardView.findViewById<TextView>(R.id.textSex).text = "Sex: ${sex}"
        cardView.findViewById<TextView>(R.id.textPhone).text = "Phone: ${phone}"
        cardView.findViewById<TextView>(R.id.textEmail).text = "Email: ${email}"

        // The linear layout is selected and the cardView(which is a separate xml file) is added each time
        containerView.addView(cardView)
    }
}

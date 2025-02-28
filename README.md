
# Assignment 1 - "Add Users" App (Refer Output Screenshot PDF in the repository to see the functionality of the app)

A simple android application developed using Kotlin to add user details and display it in a minimal and a consistent UI.


## UI Components used:
 - TextView
 - Spinner - (onItemSelectedListener)
 - EditText
 - Button - (setOnClickListener)
 - LinearLayout
 - ScrollView

## How the app works:
- When the spinner is kept to "Enabled", the "Add User" button will be enabled and the user can click it (setOnClickListener is fired).
- It will take to a different page(activity), and allows user to enter their details in a EditText view. 
- Once user has entered all the details, when "Submit" button is clicked (setOnClickListener is fired) the user is taken back to the previous page automatically and can add more user details if needed.
- The spinner has two options "Enabled" and "Disabled". Upon changing the option (onItemSelectedListener is fired), the "Add User" button is either enabled or disabled (and the color of the button changes accordingly, for a better user experience).
- Used colors.xml and themes.xml files to declare colors and themes to maintain design consistency in the app.


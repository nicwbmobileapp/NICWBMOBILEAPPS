package com.example.icds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.icds.ui.theme.ICDSTheme

/*class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      enableEdgeToEdge()
      setContent {
          ICDSTheme {
              Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  Greeting(
                      name = "Android",
                      modifier = Modifier.padding(innerPadding)
                  )
              }
          }
      }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
      text = "Hello $name!",
      modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ICDSTheme {
      Greeting("Android")
  }*/



    import android.content.Context
    import android.content.Intent
    import android.content.SharedPreferences
    import android.text.TextUtils
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

        // on below line we are creating
        // variable for email and password edit text.
        lateinit var emailEdt: EditText
        lateinit var pwdEdt: EditText

        // on below line we are creating
        // a variable for our button.
        lateinit var loginBtn: Button

        // on below line we are creating
        // a variable for shared preferences.
        lateinit var sharedPreferences: SharedPreferences

        // on below line we are creating a variable
        // for prefs key and email key and pwd key.
        var PREFS_KEY = "prefs"
        var EMAIL_KEY = "email"
        var PWD_KEY = "pwd"

        // on below line we are creating a
        // variable for email and password.
        var email = ""
        var pwd = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.icds_inspection_form)
            val submitButton: Button = findViewById(R.id.submitButton)
            submitButton.setOnClickListener {
                // Handle button click
            }
        }


            // on below line we are initializing
            // our email and pwd edit text
           /* emailEdt = findViewById(R.id.idEdtEmail)
            pwdEdt = findViewById(R.id.idEdtPassword)*-/

            // on below line we are initializing
            // our login button with id.
            loginBtn = findViewById(R.id.idBtnLogin)

            // on below line we are initializing our shared preferences.
            sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

            // on below line we are getting data from
            // our shared prefs and setting it to email.
            email = sharedPreferences.getString(EMAIL_KEY, "").toString()

            // on below line we are getting data from
            // shared prefs and setting it to pwd.
            pwd = sharedPreferences.getString(PWD_KEY, "").toString()

            // on below line we are adding on click listener for our login button.
            loginBtn.setOnClickListener {
                // on below line we are checking if email and pwd txt is empty or not.
                if (TextUtils.isEmpty(emailEdt.text.toString()) && TextUtils.isEmpty(pwdEdt.text.toString())) {

                    // if email and pwd edit text is empty we are displaying a toast message
                    Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();

                } else {
                    // on below line we are creating variable for editor
                    // of shared prefs and initializing it.
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()

                    // on below line we are adding our email and
                    // pwd to shared prefs to save them.
                    editor.putString(EMAIL_KEY, emailEdt.text.toString())
                    editor.putString(PWD_KEY, pwdEdt.text.toString())

                    // on below line we are applying
                    // changes to our shared prefs.
                    editor.apply()

                    // on below line we are opening our intent as main activity 2
                    val i = Intent(this@MainActivity, MainActivity::class.java)

                    // on below line we are
                    // starting our activity.
                    startActivity(i)

                    // on below line we are calling
                    // finish to close our activity.
                    finish()
                }
            }
        }*/

        // on below line we are calling on start method.
        override fun onStart() {
            super.onStart()
            // in this method we are checking if email and pwd are not empty.
           /* if (!email.equals("") && !pwd.equals("")) {
                // if email and pwd is not empty we
                // are opening our main 2 activity on below line.
                val i = Intent(this@MainActivity, MainActivity::class.java)

                // on below line we are calling start
                // activity method to start our activity.
                startActivity(i)

                // on below line we are calling
                // finish to finish our main activity.
                finish()
            }*/
            val i = Intent(this@MainActivity, icds_inspection_form::class.java)
            startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
            finish()
        }
    }


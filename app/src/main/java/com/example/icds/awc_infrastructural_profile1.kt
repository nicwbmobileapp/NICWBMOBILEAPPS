package com.example.icds;

// File: src/main/java/com/example/myapp/forms/icds_inspection_form.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class awc_infrastructural_profile1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.awc_infrastructural_profile1)

        val myButton: Button = findViewById(R.id.btnSubmit)
        myButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile1, "Button Clicked!", Toast.LENGTH_SHORT)
                .show()
        }

        val myNextButton: Button = findViewById(R.id.btnNext)
        myNextButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile1, "Button Next!", Toast.LENGTH_SHORT)
                .show()

            // traversing next activity
            val intent = Intent(this, awc_infrastructural_profile2::class.java)
            startActivity(intent)


        }

    }
}


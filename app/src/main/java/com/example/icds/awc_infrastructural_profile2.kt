package com.example.icds;

// File: src/main/java/com/example/myapp/forms/icds_inspection_form.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class awc_infrastructural_profile2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.awc_infrastructural_profile2)

        val myButton: Button = findViewById(R.id.btnSubmit)
        myButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile2, "Button Submit!", Toast.LENGTH_SHORT)
                .show()
        }

        val myNextButton: Button = findViewById(R.id.btnBack)
        myNextButton.setOnClickListener {
            // Your action code here
            // For example, you could show a toast message
            Toast.makeText(this@awc_infrastructural_profile2, "Button Back!", Toast.LENGTH_SHORT)
                .show()

            // traversing next activity
            val intent = Intent(this, awc_infrastructural_profile1::class.java)
            startActivity(intent)


        }

    }
}


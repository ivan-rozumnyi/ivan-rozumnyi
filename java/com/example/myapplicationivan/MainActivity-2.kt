package com.example.myapplicationivan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val phoneField = findViewById<EditText>(R.id.phoneField)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val buttonMain = findViewById<Button>(R.id.buttonMain)

        buttonRight.setOnClickListener {
            val phone = phoneField.text.toString()

            Toast.makeText(
                this,
                "Телефон: $phone",
                Toast.LENGTH_SHORT
            ).show()
        }

        buttonMain.setOnClickListener {
            Toast.makeText(
                this,
                "Була натиснута кнопка",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
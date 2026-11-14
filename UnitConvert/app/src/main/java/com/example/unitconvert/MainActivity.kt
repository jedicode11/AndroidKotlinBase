package com.example.unitconvert

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var enterInches: EditText
    private lateinit var convertButton: Button
    private lateinit var textViewCentimeters: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterInches = findViewById(R.id.editTextInches)
        convertButton = findViewById(R.id.buttonConvert)
        textViewCentimeters = findViewById(R.id.textViewConvert)

        convertButton.setOnClickListener {
            val centimeters = inchesToCentimeters(enterInches.text.toString(), enterInches.textLocale)
            textViewCentimeters.text = centimeters?.toString() ?: getString(R.string.invalid_inches)
        }
    }
}

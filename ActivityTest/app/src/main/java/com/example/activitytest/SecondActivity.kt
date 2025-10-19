package com.example.activitytest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var goToStartButton: Button
    private lateinit var textViewDataIntent: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewDataIntent = findViewById(R.id.secondText)
        goToStartButton = findViewById(R.id.buttonToBegin)

        goToStartButton.setOnClickListener {
            val rentIntent = intent
            rentIntent.putExtra(Constants.INTENT_MESSAGETWO_KEY, "I am from the second activity watchdogs")
            setResult(Constants.RESULT_CODE,intent)
            finish()
        }


        val data = intent.extras

        data?.let {
            val message = data.getString(Constants.INTENT_MESSAGE_KEY)
            val messageTwo = data.getString(Constants.INTENT_MESSAGETWO_KEY)
            val number = data.getDouble(Constants.INTENT_DATA_NUMBER)

            textViewDataIntent.text = message + "\n" + messageTwo + "\n" + number
        }
    }
}
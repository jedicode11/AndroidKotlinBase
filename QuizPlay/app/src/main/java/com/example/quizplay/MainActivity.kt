package com.example.quizplay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizplay.ui.QuestionsActivity
import com.example.quizplay.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goButton: Button = findViewById(R.id.go_button)
        val enterName: EditText = findViewById(R.id.name)

        goButton.setOnClickListener {
            if (!enterName.text.isEmpty()) {
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, enterName.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "Please add a name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
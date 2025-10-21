package com.example.quizplay.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizplay.MainActivity
import com.example.quizplay.R
import com.example.quizplay.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewScore: TextView
    private lateinit var textViewName: TextView
    private lateinit var finishButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewName = findViewById(R.id.tv_name)
        textViewScore = findViewById(R.id.tv_result)
        finishButton = findViewById(R.id.btn_finish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        "Your score is $score out of $totalQuestions".also { textViewScore.text = it }
        textViewName.text = name
        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
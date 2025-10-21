package com.example.quizplay.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizplay.R
import com.example.quizplay.model.Question
import com.example.quizplay.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProcess: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private lateinit var checkButton: Button

    private var questionCounter = 0
    private lateinit var questionsList: MutableList<Question>
    private var selectedAnswer = 0
    private var answered = false
    private lateinit var currentQuestion: Question

    private lateinit var name: String
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        progressBar = findViewById(R.id.progressBar)
        textViewProcess = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.image_flag)
        checkButton = findViewById(R.id.button_check)

        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionsList.size}")
        setQuestion()

        if (intent.hasExtra(Constants.USER_NAME)) {
            name = intent.getStringExtra(Constants.USER_NAME)!!
        }
    }

    private fun setQuestion() {
        if (questionCounter < questionsList.size) {
            currentQuestion = questionsList[questionCounter]

            clearOptions()
            flagImage.setImageResource(currentQuestion.image)
            progressBar.progress = questionCounter + 1
            textViewProcess.text = "${questionCounter + 1}/${questionsList.size}"
            textViewQuestion.text = currentQuestion.question
            textViewOptionOne.text = currentQuestion.optionOne
            textViewOptionTwo.text = currentQuestion.optionTwo
            textViewOptionThree.text = currentQuestion.optionThree
            textViewOptionFour.text = currentQuestion.optionFour

            checkButton.text = if (questionCounter == questionsList.size - 1) "FINISH" else "CHECK"

//            checkButton.isEnabled = false
//            checkButton.alpha = 0.5f
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, name)
            intent.putExtra(Constants.SCORE, score)
            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)

            startActivity(intent)
            finish()
        }
        questionCounter++
        answered = false
    }

    private fun clearOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
            option.scaleX = 1f
            option.scaleY = 1f
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }
            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }
            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }
            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }
            R.id.button_check -> {
                if (!answered) {
                    checkAnswer()
                } else {
                    setQuestion()
                }
                selectedAnswer = 0
            }
        }
    }

    private fun selectedOption(textView: TextView, selectOptionNumber: Int) {
        clearOptions()
        selectedAnswer = selectOptionNumber
        // Highlight background and text
        textView.setBackgroundColor(Color.parseColor("#FFD700")) // gold color
        textView.setTextColor(Color.BLACK)
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.animate().scaleX(1.10f).scaleY(1.10f).setDuration(250).start()

//        checkButton.isEnabled = true
//        checkButton.alpha = 1f
    }


    private fun checkAnswer() {
        if (selectedAnswer == 0) {
            // no option selected
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
            return
        }

        answered = true

        if (selectedAnswer == currentQuestion.correctAnswer) {
            score++
            markedAnswer(selectedAnswer)
        } else {
            // mark the wrong option
            when (selectedAnswer) {
                1 -> textViewOptionOne.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                2 -> textViewOptionTwo.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                3 -> textViewOptionThree.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                4 -> textViewOptionFour.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            // show the correct answer
            markedAnswer(currentQuestion.correctAnswer)
        }
        checkButton.text = "NEXT"
        showSolution()
    }

    private fun showSolution() {
        markedAnswer(currentQuestion.correctAnswer)
    }

    //    private fun markedAnswer(answer: Int) {
//        when (answer) {
//            1 -> {
//                textViewOptionOne.background = ContextCompat.getDrawable(
//                    this, R.drawable.correct_option_border_bg)
//            }
//            2 -> {
//                textViewOptionTwo.background = ContextCompat.getDrawable(
//                    this, R.drawable.correct_option_border_bg)
//            }
//            3 -> {
//                textViewOptionThree.background = ContextCompat.getDrawable(
//                    this, R.drawable.correct_option_border_bg)
//            }
//            4 -> {
//                textViewOptionFour.background = ContextCompat.getDrawable(
//                    this, R.drawable.correct_option_border_bg)
//            }
//        }
//    }
    private fun markedAnswer(answer: Int) {
        val selectedTextView: TextView = when (answer) {
            1 -> textViewOptionOne
            2 -> textViewOptionTwo
            3 -> textViewOptionThree
            4 -> textViewOptionFour
            else -> return
        }

        // Set the correct or wrong background
        selectedTextView.background = ContextCompat.getDrawable(
            this,
            if (answer == currentQuestion.correctAnswer)
                R.drawable.correct_option_border_bg
            else
                R.drawable.wrong_option_border_bg
        )

        // Animate a small “pop” effect
        selectedTextView.animate()
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(150)
            .withEndAction {
                selectedTextView.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(150)
                    .start()
            }.start()
    }
}
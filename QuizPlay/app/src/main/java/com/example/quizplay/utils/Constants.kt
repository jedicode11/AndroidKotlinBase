package com.example.quizplay.utils

import com.example.quizplay.R
import com.example.quizplay.model.Question

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val questOne = Question(
            1, "Which country does this flag belong to?",R.drawable.flag_of_italy,
            "Italy",
            "India",
            "Iran",
            "Ireland",
            1)
        questions.add(questOne)

        val questTwo = Question(2, "Which country does this flag belong to?",R.drawable.flag_of_ndia,
            "Iceland",
            "Ireland",
            "India",
            "Italy",
            3)
        questions.add(questTwo)

        val questThree = Question(3, "Which country does this flag belong to?",R.drawable.flag_of_japan,
            "Jordan",
            "Jamaica",
            "Japan",
            "Bangladesh",
            3)
        questions.add(questThree)

        val questFour = Question(4, "Which country does this flag belong to?",R.drawable.flag_of_france,
            "Netherlands",
            "France",
            "Italy",
            "Russia",
            2)
        questions.add(questFour)

        val questFive = Question(5, "Which country does this flag belong to?",R.drawable.flag_of_spain,
            "Spain",
            "Belgium",
            "Venezuela",
            "Ecuador",
            1)
        questions.add(questFive)

        val questSix = Question(6, "Which country does this flag belong to?",R.drawable.flag_of_romania,
            "Colombia",
            "Germany",
            "Romania",
            "Ecuador",
            3)
        questions.add(questSix)

        val questSeven = Question(7, "Which country does this flag belong to?",R.drawable.flag_of_argentina,
            "Argentina",
            "Honduras",
            "El Salvador",
            "Nicaragua",
            1)
        questions.add(questSeven)

        val questEight = Question(8, "Which country does this flag belong to?",R.drawable.flag_of_finland,
            "Denmark",
            "Finland",
            "Iceland",
            "Norway",
            2)
        questions.add(questEight)

        val questNine = Question(9, "Which country does this flag belong to?",R.drawable.flag_of_brazil,
            "Kuwait",
            "Brazil",
            "Sao Paulo",
            "Portugal",
            2)
        questions.add(questNine)

        val questTen = Question(10, "Which country does this flag belong to?",R.drawable.flag_of_united_arab_emirates,
            "Sudan",
            "Jordan",
            "Kuwait",
            "UAE",
            4)
        questions.add(questTen)

        val questEleven = Question(11, "Which country does this flag belong to?",R.drawable.flag_of_portugal,
            "Portugal",
            "Paraguay",
            "Spain",
            "Netherlands",
            1)
        questions.add(questEleven)

        val questTwelve = Question(12, "Which country does this flag belong to?",R.drawable.flag_of_bulgaria,
            "France",
            "Bulgaria",
            "Estonia",
            "Hungary",
            2)
        questions.add(questTwelve)

        val questThirteen = Question(13, "Which country does this flag belong to?",R.drawable.flag_of_hungary,
            "Latvia",
            "Croatia",
            "Bulgaria",
            "Hungary",
            4)
        questions.add(questThirteen)

        val questFourteen = Question(14, "Which country does this flag belong to?",R.drawable.flag_of_netherlands,
            "Netherlands",
            "Czech Republic",
            "Slovenia",
            "Croatia",
            1)
        questions.add(questFourteen)

        val questFifteen = Question(15, "Which country does this flag belong to?",R.drawable.flag_of_czech_republic,
            "Paraguay",
            "Czech Republic",
            "Serbia",
            "Slovakia",
            2)
        questions.add(questFifteen)

        return questions
    }
}
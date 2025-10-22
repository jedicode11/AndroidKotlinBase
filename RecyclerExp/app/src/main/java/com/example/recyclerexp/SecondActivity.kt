package com.example.recyclerexp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerexp.utils.Constants

class SecondActivity : AppCompatActivity() {

    private lateinit var titeTextView: TextView
    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        titeTextView = findViewById(R.id.secondActivityView)
        descriptionTextView = findViewById(R.id.secondActivityViewTwo)

        val data = intent.extras
        data?.let {
            titeTextView.text = it.getString(Constants.KEY_TITLE)
            descriptionTextView.text = it.getString(Constants.KEY_DESCRIPTION)
        }
    }
}
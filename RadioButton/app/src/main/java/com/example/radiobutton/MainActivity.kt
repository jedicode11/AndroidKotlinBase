package com.example.radiobutton

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.format.TextStyle

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton: RadioButton
    private lateinit var seekBar: SeekBar
    private lateinit var textViewSeek: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        textViewSeek = findViewById(R.id.textViewSeek)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Toast.makeText(this@MainActivity,"onProgressChanged", Toast.LENGTH_SHORT).show()
                textViewSeek.text = seekBar.progress.toString()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity,"onStartTrackingTouch", Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@MainActivity,"onStopTrackingTouch", Toast.LENGTH_SHORT).show()
                textViewSeek.text = "Final rate =" + p0!!.progress.toString()
            }
        })

        radioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radioButton = findViewById(checkedId)

            when (checkedId) {
                R.id.yesButton -> {
                    Toast.makeText(this@MainActivity, "Yes button clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.noButton -> {
                    Toast.makeText(this@MainActivity, "No button clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.maybeButton -> {
                    Toast.makeText(this@MainActivity, "Maybe button clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
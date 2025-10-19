package com.example.activitytest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var goToButton: Button
    private lateinit var textViewData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Constants.RESULT_CODE) {
                val message = it.data!!.getStringExtra(Constants.INTENT_MESSAGETWO_KEY)
                textViewData.text = message
            }
        }

        textViewData = findViewById(R.id.mainTextViewText)
        goToButton = findViewById(R.id.buttonGoNext)
        goToButton.setOnClickListener {
            val next = Intent(this@MainActivity, SecondActivity::class.java)
            next.putExtra(Constants.INTENT_MESSAGE_KEY, "I am watchdog of another activity")
            next.putExtra(Constants.INTENT_MESSAGETWO_KEY, "Sub How it is there?")
            next.putExtra(Constants.INTENT_DATA_NUMBER, 1.6)
            getResult.launch(next)
        }
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(this@MainActivity, "onStart called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this@MainActivity, "onResume called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this@MainActivity, "onPause called", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this@MainActivity, "onStop called", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this@MainActivity, "onDestroy called", Toast.LENGTH_SHORT).show()
    }
}

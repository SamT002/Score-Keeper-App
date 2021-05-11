package com.example.test_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var redName: EditText
    lateinit var blueName:EditText
    lateinit var start:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        redName = findViewById(R.id.redTeamName)
        blueName = findViewById(R.id.blueTeamName)
        start = findViewById(R.id.start)


        start.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            val red = redName.text.toString()
            val blue = blueName.text.toString()
            intent.putExtra("redTeam", red)
            intent.putExtra("blueTeam", blue)
            startActivity(intent)
        }

    }


}

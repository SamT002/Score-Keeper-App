package com.example.test_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    lateinit var toast: Toast
    lateinit var blueScore: TextView
    lateinit var redScore: TextView
    lateinit var blueTeamName: TextView
    lateinit var redTeamName: TextView

    lateinit var btbPlusRed: Button
    lateinit var btbMinusRed: Button

    lateinit var btbPlusBlue: Button
    lateinit var btbMinusBlue: Button

    lateinit var finish: Button
    lateinit var reset: Button

    lateinit var blueTeamScore:String
    lateinit var redTeamScore:String


    @SuppressLint("ShowToast")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        blueScore = findViewById(R.id.blue)
        redScore = findViewById(R.id.red)
        btbPlusRed = findViewById(R.id.redPlus)
        btbMinusRed = findViewById(R.id.redMinus)
        btbPlusBlue = findViewById(R.id.bluePlus)
        btbMinusBlue = findViewById(R.id.blueMinus)
        finish = findViewById(R.id.finish)
        reset = findViewById(R.id.reset)
        blueTeamName = findViewById(R.id.bTeamName)
        redTeamName = findViewById(R.id.rTeamName)

        if (savedInstanceState != null){ // check Bundle and take data
            blueScore.text = savedInstanceState.getString("BlueTeamScore")
            redScore.text = savedInstanceState.getString("RedTeamScore")
        }


        var redTeam: String? = intent.getStringExtra("redTeam")
        var blueTeam: String? = intent.getStringExtra("blueTeam")

        blueTeamName.setText(blueTeam)
        redTeamName.setText(redTeam)


        reset.setOnClickListener {
            blueScore.text = "0"
            redScore.text = "0"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // save data in Bundle if screen change orientation
        super.onSaveInstanceState(outState)
        outState.putString("BlueTeamScore", blueScore.text.toString())
        outState.putString("RedTeamScore", redScore.text.toString())
    }


    fun plus(view: View) {
        if (view == btbPlusBlue) { // check what button was clicked
            val a = blueScore.text.toString().toInt() + 1 //convert TextView to String and parse to Int(I could find how to convert TextView to Int)
            blueScore.text = a.toString()
        } else if (view == btbPlusRed) {
            val a = redScore.text.toString().toInt() + 1
            redScore.text = a.toString()
        }
    }


    fun minus(view: View) {
        if (view == btbMinusBlue) {
            val a = blueScore.text.toString().toInt() - 1
            blueScore.text = a.toString()
        } else if (view == btbMinusRed) {
            val a = redScore.text.toString().toInt() - 1
            redScore.text = a.toString()
        }
    }

    @SuppressLint("ShowToast")
    fun finish(view: View){ // show which team win with Toast
        val bScore = blueScore.text.toString()
        val rScore = redScore.text.toString()

        if (bScore.toInt() > rScore.toInt()) { // Checking which team win
            toast = Toast.makeText(applicationContext, "Blue Team Win!!!", Toast.LENGTH_LONG)
        } else if (rScore.toInt() > bScore.toInt()) {
            toast = Toast.makeText(applicationContext, "Red Team Win!!!", Toast.LENGTH_LONG)
        } else {
            toast = Toast.makeText(applicationContext, "Draw", Toast.LENGTH_LONG)
        }

        toast.show()
    }


    }
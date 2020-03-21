package com.example.level1_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    private var diceNumber = arrayOf(R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }
    private fun initViews() {
        updateUI()

        lower.setOnClickListener {
            onLowerClick()
        }
        equals.setOnClickListener {
            onEqualClick()
        }
        higher.setOnClickListener {
            onHigherClick()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if(currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }
    private fun onEqualClick() {
        rollDice()
        if(lastThrow == currentThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }
    private fun onHigherClick() {
        rollDice()
        if(currentThrow > lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun updateUI() {
        lastanswer.text = getString(R.string.last_throw, lastThrow)
        Dice.setImageResource(diceNumber[currentThrow-1])
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }
    private fun onAnswerCorrect() {
        Toast.makeText(this, R.string.correct, Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, R.string.incorrect, Toast.LENGTH_LONG).show()
    }

}

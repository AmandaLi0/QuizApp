package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    lateinit var question : TextView
    lateinit var trueB : Button
    lateinit var falseB : Button
    lateinit var points : TextView


    companion object{
        val TAG = "MainActivity"
    }

    private lateinit var quiz: Quiz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()
        loadQuestions()


        trueB.setOnClickListener {
            quiz.checkAnswer(true)
        }
        falseB.setOnClickListener {
            quiz.checkAnswer(false)
        }

    }

    private fun loadQuestions() {
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }


        Log.d(TAG, "onCreate: $jsonString")

        val gson = Gson()

        val type = object : TypeToken<List<Question>>() { }.type
        val questions = gson.fromJson<List<Question>>(jsonString, type)

        Log.d(TAG, "conCreate: $questions")
        quiz = Quiz(questions)
    }
    val scoreText = getString(R.string.main_points)
    points.text = "$scoreText: ${quiz.points}"

    private fun wireWidgets() {
        question = findViewById(R.id.textView_MainActivity_questions)
        trueB = findViewById(R.id.button_MainActivity_True)
        falseB = findViewById(R.id.button2_MainActivity_False)
        points = findViewById(R.id.textView2_MainActivity_Points)
    }
}
//Quiz.checkAnswer(true)
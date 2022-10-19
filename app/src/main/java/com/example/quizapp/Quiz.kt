package com.example.quizapp

class Quiz(val questions: List<Question>) {
    var points = 0
    //variables to track current score, current question
    var questionNum = 0
    var currentQuestion = questions[questionNum].question



    //function to check if there's another question, give the next question, check the answer
    //give the final score, reset the quiz?, shuffle questions?

    fun checkAnswer(answer: Boolean): Unit {
        if(answer == questions[questionNum].answer){
            points +=1

        }
        else{

        }


    }
     fun moreQuestion(): Boolean {
         return questionNum<10
     }

    fun advanceQuestion(): String {
        questionNum++
        currentQuestion = questions[questionNum].question
        return currentQuestion

    }


}
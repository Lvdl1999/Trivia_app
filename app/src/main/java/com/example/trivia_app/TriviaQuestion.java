package com.example.trivia_app;

import java.io.Serializable;
import java.util.ArrayList;

public class TriviaQuestion implements Serializable {

    private String category, type, difficulty, question, correct_answer;
    private ArrayList incorrect_answers;

    TriviaQuestion(String category, String type, String difficulty, String question,
                   String correct_answer, ArrayList incorrect_answers) {

        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

        //    getters
        public String getCategory() {
        return category;
        }

        public String getType(){
        return type;
        }

        public String getDifficulty(){
        return difficulty;
        }

        public String getQuestion(){
        return question;
        }

        public String getCorrect_answer(){
        return correct_answer;
        }

        public ArrayList getIncorrect_answers(){
        return incorrect_answers;
        }
}


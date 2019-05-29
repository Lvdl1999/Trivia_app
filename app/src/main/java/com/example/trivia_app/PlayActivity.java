package com.example.trivia_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity implements TriviaRequest.Callback {

    private ArrayList questions;
    private String correctanswer;
    private String difficulty;
    private int points = 0;
    private int counter = 0;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        TriviaRequest triviaRequest = new TriviaRequest(this);
        triviaRequest.getTrivia(this);
    }

    @Override
    public void gotTrivia(ArrayList<TriviaQuestion> question) {
        this.questions = question;
    }

    @Override
    public void gotTriviaError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    public void nextclicked(View view) {
        Button  awnser = (Button) view;
        awnser.setText("NEXT");
        score = findViewById(R.id.points);
        score.setText("Score :" + String.valueOf(this.points));

        if (this.counter == this.questions.size()){
            Intent intent = new Intent(PlayActivity.this, ScoresActivity.class);
            intent.putExtra("score", this.points);
            startActivity(intent);
            finish();

        }
        else {
            // Get data that has to fill the textviews
            TriviaQuestion question = (TriviaQuestion) this.questions.get(this.counter);
            String type = (String) question.getType();
            String string_question = (String) question.getQuestion();
            this.correctanswer = (String) question.getCorrect_answer();
            this.difficulty = (String) question.getDifficulty();

            // Set the textviews with belonging text
            TextView difficulty = findViewById(R.id.difficulty);
            TextView question_text = findViewById(R.id.question);
            difficulty.setText(question.getDifficulty());
            question_text.setText(question.getQuestion());

            enableButtons();

            if (type.equals("boolean")){
                Boolean(question);
            }
            else {
                Multiple(question);
            }
            this.counter++;
        }

    }

    private void Boolean(TriviaQuestion question) {

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        // Don't show first and last answer anymore
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);
        answer4.setVisibility(View.GONE);

        // Get correct answer
        String correct_answer = question.getCorrect_answer();

        // Get incorrect answers
        ArrayList incorrect_answers = question.getIncorrect_answers();
        String incorrect_answer = (String) incorrect_answers.get(0);

        // Get random number from 0 to 1
        Random number = new Random();
        int random_answer = number.nextInt(1);

        // Choose answers to a button by random number

        switch (random_answer) {
            case 0:
                answer3.setText(correct_answer);
                answer2.setText(incorrect_answer);
                break;
            case 1:
                answer2.setText(incorrect_answer);
                answer3.setText(correct_answer);
                break;
        }
    }

    private void Multiple(TriviaQuestion question){

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4 );

        // Show all possible answers on the button
        answer1.setVisibility(View.VISIBLE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);
        answer4.setVisibility(View.VISIBLE);

        // Get correct answer
        String correct_answer = question.getCorrect_answer();

        // Get incorrect answers
        ArrayList incorrect_answers = question.getIncorrect_answers();
        String incorrect_answer1 = (String) incorrect_answers.get(0);
        String incorrect_answer2 = (String) incorrect_answers.get(1);
        String incorrect_answer3 = (String) incorrect_answers.get(2);

        // Get random number from 0 to 3
        Random number = new Random();
        int random_answer = number.nextInt(4);

        // Choose answers to a button by random number

        switch(random_answer){
            case 0:
                answer1.setText(correct_answer);
                answer2.setText(incorrect_answer1);
                answer3.setText(incorrect_answer2);
                answer4.setText(incorrect_answer3);
                break;
            case 1:
                answer2.setText(incorrect_answer1);
                answer3.setText(incorrect_answer2);
                answer4.setText(incorrect_answer3);
                answer1.setText(correct_answer);
                break;
            case 2:
                answer3.setText(incorrect_answer2);
                answer4.setText(incorrect_answer3);
                answer1.setText(correct_answer);
                answer2.setText(incorrect_answer1);
                break;
            case 3:
                answer4.setText(incorrect_answer3);
                answer1.setText(correct_answer);
                answer2.setText(incorrect_answer1);
                answer3.setText(incorrect_answer2);
                break;
        }
    }
    public void awnser1(View view){
        Button  awnser = (Button) view;
        String text = (String) awnser.getText();
        if(text.equals(this.correctanswer)){
            addScore();
        }
        else{
            Toast.makeText(this,"The answer is incorrect", Toast.LENGTH_LONG).show();
        }
        dissableButtons();
    }
    public void awnser2(View view){
        Button  awnser = (Button) view;
        String text = (String) awnser.getText();
        if(text.equals(this.correctanswer)){
            addScore();
        }
        else{
            Toast.makeText(this,"The answer is incorrect", Toast.LENGTH_LONG).show();
        }
        dissableButtons();
    }
    public void awnser3(View view){
        Button  awnser = (Button) view;
        String text = (String) awnser.getText();
        if(text.equals(this.correctanswer)){
            addScore();
        }
        else{
            Toast.makeText(this,"The answer is incorrect", Toast.LENGTH_LONG).show();
        }
        dissableButtons();
    }
    public void awnser4(View view){
        Button  awnser = (Button) view;
        String text = (String) awnser.getText();
        if(text.equals(this.correctanswer)){
            addScore();
        }
        else{
            Toast.makeText(this,"The answer is incorrect", Toast.LENGTH_LONG).show();
        }
        dissableButtons();
    }

    private void dissableButtons(){
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        answer1.setClickable(false);
        answer2.setClickable(false);
        answer3.setClickable(false);
        answer4.setClickable(false);
    }

    private void enableButtons(){
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        answer1.setClickable(true);
        answer2.setClickable(true);
        answer3.setClickable(true);
        answer4.setClickable(true);
    }
    public void addScore(){
        Toast.makeText(this,"The answer is correct", Toast.LENGTH_LONG).show();

        if (this.difficulty.equals("easy")){
            this.points += 1;
        }
        else if (this.difficulty.equals("medium")){
            this.points += 2;
        }
        else if (this.difficulty.equals("hard")){
            this.points += 4;
        }

        score = findViewById(R.id.points);
        score.setText("Score : " + String.valueOf(this.points));
    }
}

package com.example.trivia_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity implements HighScoreRequest.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        HighScoreRequest request = new HighScoreRequest(HighScoreActivity.this);
        request.getHighScore(HighScoreActivity.this);

    }

    @Override
    public void gotHighScore(ArrayList<String> HighScore) {

        HighScoreAdapter adapter = new HighScoreAdapter(HighScoreActivity.this, R.layout.highscore_adapter, HighScore);
        ListView scores_list = findViewById(R.id.scores_listview);
        scores_list.setAdapter(adapter);
    }

    @Override
    public void gotHighScoreError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    public void goToMenu(View view) {
        Intent intent = new Intent(HighScoreActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

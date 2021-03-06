package com.example.trivia_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playclicked(View view) {
        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
        startActivity(intent);
        finish();
    }

    public void scoresclicked(View view) {
        Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
        startActivity(intent);
        finish();
    }
}

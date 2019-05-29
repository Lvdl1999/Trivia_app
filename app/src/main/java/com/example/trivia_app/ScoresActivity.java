package com.example.trivia_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ScoresActivity extends AppCompatActivity {
    private int score;
    private String name;

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Intent intent = getIntent();
        this.score = (int)intent.getSerializableExtra("score");
        textView = findViewById(R.id.points);
        textView.setText("Your score is: " + score);
    }

    public void submit(View view){
        textView = findViewById(R.id.points);
        editText = findViewById(R.id.name);

        this.name = editText.getText().toString();

        if(name.equals("") || name == null){
            Toast.makeText(this, "Fill in your name", Toast.LENGTH_LONG).show();
        }
        else{
            setScore(this.score, this.name);
            Intent intent = new Intent(ScoresActivity.this, HighScoreActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void setScore(final int score, final String name){
        String url = "https://ide.legacy.cs50.io/lvanderlinde/ide50";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Success
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Success
                    }
                }) {
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<>();
                MyData.put("Score: ", String.valueOf(score));
                MyData.put("Name", name);
                return MyData;
            }
        };
        // Make request
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}

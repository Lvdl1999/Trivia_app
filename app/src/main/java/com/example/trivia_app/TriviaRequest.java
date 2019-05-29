package com.example.trivia_app;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class TriviaRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Callback callback;
    private Context context;


    public interface Callback{
        void gotTrivia(ArrayList<TriviaQuestion> question);
        void gotTriviaError (String message);
    }


    TriviaRequest(Context context) {
        this.context = context;
    }

    void getTrivia(Callback callback){

        String url = "https://opentdb.com/api.php?amount=10";
        this.callback = callback;

        RequestQueue requestTrivia = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        requestTrivia.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotTriviaError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {

        ArrayList arrayList = new ArrayList();
        JSONArray jsonArray;

        try{
            jsonArray = response.getJSONArray("results");
            JSONObject jsonObject;

            for(int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                String question = jsonObject.getString("question");
                String type = jsonObject.getString("type");
                String difficulty = jsonObject.getString("difficulty");
                String correct_answer = jsonObject.getString("correct_answer");
                String category = jsonObject.getString("category");
                ArrayList incorrect_arraylist = new ArrayList();

                JSONArray incorrect_jsonArray = jsonObject.getJSONArray("incorrect_answers");

                for(int j = 0; j < incorrect_jsonArray.length(); j++) {
                    incorrect_arraylist.add(incorrect_jsonArray.getString(j));
                }
                TriviaQuestion trivia = new TriviaQuestion(category, type, difficulty, question, correct_answer, incorrect_arraylist);
                arrayList.add(trivia);
            }
            callback.gotTrivia(arrayList);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }









}

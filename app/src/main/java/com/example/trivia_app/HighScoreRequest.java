package com.example.trivia_app;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class HighScoreRequest implements Response.Listener<JSONArray>, Response.ErrorListener {
    private Context context;
    private Callback callback;

    public HighScoreRequest(Context context){
        this.context = context;
    }

    public interface Callback{
        void gotHighScore (ArrayList<String> HighScore);
        void gotHighScoreError (String message);
    }

    public void getHighScore(Callback callback) {
        this.callback = callback;
        String url = "https://ide.legacy.cs50.io/lvanderlinde/ide50";
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, this, this);
        queue.add(jsonArrayRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotHighScoreError(error.getMessage());
    }

    @Override
    public void onResponse(JSONArray response) {
        ArrayList arrayList = new ArrayList();
        try {
            for (int i =0; i < response.length(); i++){
                arrayList.add(response.getString(i));
            // iets zelf mee geven arraylist
//            // in de vorm van een string
//                arrayList.add("Naam = Levy en score = 5");

            }
            callback.gotHighScore(arrayList);

        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
}


package com.example.trivia_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter {

    ArrayList<String> highscores_list;

    public HighScoreAdapter(Context context, int resource, ArrayList<String> highscores_list) {

        super(context, resource, highscores_list);
        this.highscores_list = highscores_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Setting highs score adapter layout to high score adapter
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.highscore_adapter, parent, false);
        }

        // Putting the scores in the textviews
        String highscore = highscores_list.get(position);
        TextView score_text = convertView.findViewById(R.id.score_textview);
        score_text.setText(highscore);

        return convertView;

    }




}

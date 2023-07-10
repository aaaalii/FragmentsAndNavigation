package com.example.fragmentsandnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends Fragment {

    private TextView letterTextView, answerTextView;
    private char[] skyLetters = {'b', 'd', 'f', 'h', 'k', 'l', 't'};
    private char[] rootLetters = {'g', 'j', 'p', 'q', 'y'};
    private char[] grassLetters = {'a', 'c', 'e', 'i', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'w', 'x', 'z'};
    private String answerString = "";

    public Quiz() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quiz, container, false);

        letterTextView = view.findViewById(R.id.letter_text_view);
        letterTextView.setText(getRandomLetter());

        answerTextView = view.findViewById(R.id.answer_text_view);

        Button skyButton = view.findViewById(R.id.sky_button);
        skyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString == "Sky Letter") {
                    answerTextView.setText("Awesome your answer is right");
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }

                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });

        Button grassButton = view.findViewById(R.id.grass_button);
        grassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString == "Grass Letter") {
                    answerTextView.setText("Awesome your answer is right");
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }
                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });

        Button rootButton = view.findViewById(R.id.root_button);
        rootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerString == "Root Letter") {
                    answerTextView.setText("Awesome your answer is right");
                } else {
                    answerTextView.setText("Incorrect! the answer is " + answerString);
                }
                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        });

        return view;
    }

    private String getRandomLetter() {
        Random random = new Random();
        int category = random.nextInt(3);
        char letter;
        switch (category) {
            case 0:
                letter = skyLetters[random.nextInt(skyLetters.length)];
                answerString = "Sky Letter";
                break;
            case 1:
                letter = grassLetters[random.nextInt(grassLetters.length)];
                answerString = "Grass Letter";
                break;
            default:
                letter = rootLetters[random.nextInt(rootLetters.length)];
                answerString = "Root Letter";
                break;
        }
        return String.valueOf(letter);
    }
}
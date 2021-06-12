package com.example.quiz_time2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button,button9,play_nor1;
    TextView Scoreview,High_Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int Score23 = getIntent().getIntExtra("Score13", 0);
        int Score24 = getIntent().getIntExtra("Score14", 0);
        button = findViewById(R.id.play);
        button9 = findViewById(R.id.exit);
        play_nor1 = findViewById(R.id.play_nor);
        High_Score = findViewById(R.id.High_Score);
        Scoreview = findViewById(R.id.Score98);
        if(Score23!=0){
            Scoreview.setText("Score:" + Integer.toString(Score23));
        }
        else {
            Scoreview.setText("Score:" + Integer.toString(Score24));
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        play_nor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuizNorActivity.class);
                startActivity(intent);
            }
        });
        SharedPreferences settings=getSharedPreferences("Quiz_DATA", Context.MODE_PRIVATE);
        int highscore2=settings.getInt("HIGH_SCORE",0);
        if(Score23>highscore2){
            High_Score.setText(Integer.toString(Score23));
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH_SCORE",Score23);
            editor.commit();
        }
        else  if (Score24>highscore2){
            High_Score.setText(Integer.toString(Score24));
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH_SCORE",Score24);
            editor.commit();
        }
        else {
            High_Score.setText(Integer.toString(highscore2));
        }
    }

    public void openQuizActivity(){
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
    }




}
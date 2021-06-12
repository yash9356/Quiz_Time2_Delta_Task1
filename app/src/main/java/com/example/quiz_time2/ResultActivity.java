package com.example.quiz_time2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView Score21;
    Button button54,button56;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int Score13 =getIntent().getIntExtra("Score",0);
        int Totalq=getIntent().getIntExtra("indo",0);
        int Totalq1=getIntent().getIntExtra("indus",0);
        int Score14=getIntent().getIntExtra("Sorus",0);
        Score21=findViewById(R.id.Score21);

        button54=findViewById(R.id.Restart);
        button56=findViewById(R.id.Home2);
        if(Score13!=0){
            Score21.setText(String.format("%d/%d",Score13,Totalq));
            button56.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                    intent.putExtra("Score13",Score13);
                    startActivity(intent);
                }
            });
            button54.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ResultActivity.this,QuizActivity.class);
                    startActivity(intent);
                }
            });

        }
        else {
            Score21.setText(String.format("%d/%d",Score14,Totalq1));
            button54.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ResultActivity.this,QuizNorActivity.class);
                    startActivity(intent);
                }
            });
            button56.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                    intent.putExtra("Score14",Score14);
                    startActivity(intent);
                }
            });
        }


    }
}
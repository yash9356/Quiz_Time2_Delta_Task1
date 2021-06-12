package com.example.quiz_time2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizNorActivity extends AppCompatActivity {
    int qn=0;
    int ans7;
    private TextView optionA1,optionB1,optionC1,optionD1;
    private TextView question1,questionnumber1,Score999;
    Vibrator vibrator1;
    String []Day={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_nor);
        vibrator1=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        optionA1=findViewById(R.id.optionA1);
        optionB1=findViewById(R.id.optionB1);
        optionC1=findViewById(R.id.optionC1);
        optionD1=findViewById(R.id.optionD1);
        question1=findViewById(R.id.Question1);
        Score999=findViewById(R.id.Score999);
        questionnumber1=findViewById(R.id.question_num1);


        Random random1=new Random();
        int MM1=random1.nextInt(13-1)+1;
        int YY1=random1.nextInt(2023-2019)+2019;
        int DD1=Knull1(MM1,YY1);
        question1.setText("Guess the Day on:"+Integer.toString(DD1)+"/"+Integer.toString(MM1)+"/"+Integer.toString(YY1));
        int ans7 = Symboid1(DD1,MM1,YY1);
        int [] option102=optionX1(ans7);
        optionA1.setText(Day[option102[0]]);
        optionB1.setText(Day[option102[1]]);
        optionC1.setText(Day[option102[2]]);
        optionD1.setText(Day[option102[3]]);

        questionnumber1.setText("Question"+Integer.toString(qn+1));
        optionA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[0]==ans7){
                    SetNextQ();
                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
        optionB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[1]==ans7){
                    SetNextQ();
                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
        optionC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[2]==ans7){
                    SetNextQ();
                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);
                }
            }
        });
        optionD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[3]==ans7){
                    SetNextQ();
                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
    }
    public void SetNextQ(){
        qn++;
        Score999.setText("Score"+Integer.toString(qn));
        Random random2=new Random();
        int MM=random2.nextInt(13-1)+1;
        int YY=random2.nextInt(2023-2019)+2019;
        int DD=Knull1(MM,YY);
        question1.setText("Guess the Day on:"+Integer.toString(DD)+"/"+Integer.toString(MM)+"/"+Integer.toString(YY));
        int ans7 = Symboid1(DD,MM,YY);
        int [] option102=optionX1(ans7);
        optionA1.setText(Day[option102[0]]);
        optionB1.setText(Day[option102[1]]);
        optionC1.setText(Day[option102[2]]);
        optionD1.setText(Day[option102[3]]);
        questionnumber1.setText("Question"+Integer.toString(qn+1));
        optionA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[0]==ans7){
                    SetNextQ();

                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
        optionB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[1]==ans7){
                    SetNextQ();

                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
        optionC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[2]==ans7){
                    SetNextQ();

                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);

                }
            }
        });
        optionD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator1.vibrate(500);
                if(option102[3]==ans7){
                    SetNextQ();
                }
                else {
                    Intent intent=new Intent(QuizNorActivity.this,ResultActivity.class);
                    intent.putExtra("Sorus",qn);
                    intent.putExtra("indus",qn+1);
                    startActivity(intent);
                }
            }
        });

    }
    public int Knull1(int MM,int YY){
        Random rant=new Random();
        int DD;
        if(MM==4 || MM==6 ||MM==9 || MM==11){
            DD= rant.nextInt(31-1)+1;
        }
        else if(MM==2){
            if(YY==2020){
                DD=rant.nextInt(30-1)+1;
            }
            else {
                DD=rant.nextInt(29-1)+1;
            }
        }
        else {
            DD= rant.nextInt(32-1)+1;
        }
        return DD;
    }
    public int[] optionX1(int ans7){
        Random random1=new Random();
        List<String> l1=new ArrayList<>();
        for(int k=0;k<=6;k++){
            l1.add(Integer.toString(k));
        }
        String option_p=l1.get(random1.nextInt(7));
        l1.remove(option_p);
        String option_q= l1.get(random1.nextInt(6));
        l1.remove(option_q);
        String option_r= l1.get(random1.nextInt(5));
        l1.remove(option_r);
        String option_s;
        if(Integer.valueOf(option_p)==ans7 || Integer.valueOf(option_q)==ans7 ||Integer.valueOf(option_r)==ans7){
            option_s=l1.get(random1.nextInt(4));}
        else {
            option_s=Integer.toString(ans7);
        }
        int[] optionz={Integer.valueOf(option_p),Integer.valueOf(option_q),Integer.valueOf(option_r),Integer.valueOf(option_s)};
        return optionz;

    }
    public int Symboid1(int DD,int MM,int YY){
        int M1;
        if(MM==1||MM==10){
            M1=0;
        }
        else if(MM==5){
            M1=1;
        }
        else if(MM==8){
            M1=2;
        }
        else if(MM==6){
            M1=4;
        }
        else if (MM==9 ||MM==12){
            M1=5;
        }
        else if (MM==4 ||MM==7){
            M1=6;
        }
        else {
            M1=3;
        }
        int Y1=YY-1900;
        int LY1=Y1/4;
        int index=(DD+Y1+LY1+M1)%7;
        return index;
    }

}
package com.example.quiz_time2;


import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {
    int index6 =0;
    private TextView optionA,optionB,optionC,optionD,textclock;
    private TextView question,score,questionnumber;
    public int mscore=0;
    Vibrator vibrator;
    String []Day={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        textclock=findViewById(R.id.textclock);
        long duration= TimeUnit.MINUTES.toMillis(2);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH,"%02d :%02d",
                TimeUnit.MILLISECONDS.toMinutes(l),
                TimeUnit.MILLISECONDS.toSeconds(l) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                textclock.setText(sDuration);
            }

            @Override
            public void onFinish() {
                textclock.setVisibility(View.GONE);
                Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                intent.putExtra("Score",mscore);
                intent.putExtra("indo",index6+1);
                startActivity(intent);

            }
        }.start();
        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question=findViewById(R.id.Question);
        score=findViewById(R.id.Score);
        questionnumber=findViewById(R.id.question_num);
        Random random1=new Random();
        int MM=random1.nextInt(13-1)+1;
        int YY=random1.nextInt(2023-2019)+2019;
        int DD=Knull(MM,YY);
        question.setText("Guess the Day on:"+Integer.toString(DD)+"/"+Integer.toString(MM)+"/"+Integer.toString(YY));
        int index6 = Symboid(DD,MM,YY);
        int [] option101=optionX(index6);
        optionA.setText(Day[option101[0]]);
        optionB.setText(Day[option101[1]]);
        optionC.setText(Day[option101[2]]);
        optionD.setText(Day[option101[3]]);
        questionnumber.setText("Question"+Integer.toString(1));
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option101[0],optionA,mscore);
                vibrator.vibrate(500);
            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option101[1],optionB,mscore);
                vibrator.vibrate(500);
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option101[2],optionC,mscore);
                vibrator.vibrate(500);
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mscore=checkans(index6,option101[3],optionD,mscore);
                vibrator.vibrate(500);
            }
        });
    }
    public void reset(){
        optionA.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        optionB.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        optionC.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        optionD.setBackground(getResources().getDrawable(R.drawable.option_unselected));
    }
    public int checkans(int index,int opt,TextView textView,int mscore){
        if(opt==index){
            mscore=mscore+1;
            textView.setBackground(getResources().getDrawable(R.drawable.correct_answer));
        }
        else {
            textView.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
            mscore=mscore-1;
        }
        return mscore;
    }
    void SetNextQuestion(){
        Random random1=new Random();
        int MM=random1.nextInt(13-1)+1;
        int YY=random1.nextInt(2023-2019)+2019;
        int DD=Knull(MM,YY);
        question.setText("Guess the Day on:"+Integer.toString(DD)+"/"+Integer.toString(MM)+"/"+Integer.toString(YY));
        int index6 = Symboid(DD,MM,YY);
        int [] option10=optionX(index6);
        optionA.setText(Day[option10[0]]);
        optionB.setText(Day[option10[1]]);
        optionC.setText(Day[option10[2]]);
        optionD.setText(Day[option10[3]]);
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option10[0],optionA,mscore);
                vibrator.vibrate(500);
            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option10[1],optionB,mscore);
                vibrator.vibrate(500);
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option10[2],optionC,mscore);
                vibrator.vibrate(500);
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mscore=checkans(index6,option10[3],optionD,mscore);
                vibrator.vibrate(500);
            }
        });

    }
    public void onclick1(View view){
        if(index6<=48){
            index6=index6+1;
            reset();
            questionnumber.setText(("Question "+Integer.toString(index6+1)));
            score.setText("Score "+Integer.toString(mscore));
            SetNextQuestion();
        }
        else{
           Toast.makeText(this,"Quiz Finished.", Toast.LENGTH_SHORT).show();
        }

    }


    public int Knull(int MM,int YY){
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
    public int[] optionX(int index6){
        Random random1=new Random();
        List<String> l1=new ArrayList<>();
        for(int j=0;j<=6;j++){
            l1.add(Integer.toString(j));
        }
        String option_p=l1.get(random1.nextInt(7));
        l1.remove(option_p);
        String option_q= l1.get(random1.nextInt(6));
        l1.remove(option_q);
        String option_r= l1.get(random1.nextInt(5));
        l1.remove(option_r);
        String option_s;
        if(Integer.valueOf(option_p)==index6 || Integer.valueOf(option_q)==index6 ||Integer.valueOf(option_r)==index6){
            option_s=l1.get(random1.nextInt(4));}
        else {
            option_s=Integer.toString(index6);
        }
        int[] optionz={Integer.valueOf(option_p),Integer.valueOf(option_q),Integer.valueOf(option_r),Integer.valueOf(option_s)};
        return optionz;

        }
    public int Symboid(int DD,int MM,int YY){
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
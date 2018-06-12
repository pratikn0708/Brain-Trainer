package com.pratik.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvscore,tvtimer,tvques ,textView3;
    Button b0,b1,b2,b3 ,pabutton;
    ArrayList<Integer>answers=new ArrayList<Integer>();
    int locofcorrectans,score=0,noofques=0;

    public void playAgain(final View v){
        score=0;
        noofques=0;
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        tvtimer.setText("30s");
        tvscore.setText("0/0");
        textView3.setText("");
        pabutton.setVisibility(v.INVISIBLE);
        generateQues();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {

                tvtimer.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                pabutton.setVisibility(v.VISIBLE);
                b0.setEnabled(false);
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                tvtimer.setText("0s");
                textView3.setText("Your Score: " + Integer.toString(score) + "/" + Integer.toString(noofques));

            }
        }.start();


    }


    public void generateQues(){
        Random rand=new Random();
        int a=rand.nextInt(400);
        int b=rand.nextInt(400);
        tvques.setText(Integer.toString(a) + "+" + Integer.toString(b));
        locofcorrectans=rand.nextInt(4);
        answers.clear();

        int incorrect;
        for (int i=0;i<4;i++){
            if(i==locofcorrectans){
                answers.add(a + b);
            }else{
                incorrect=rand.nextInt(850);
                while (incorrect==a + b){
                    incorrect=rand.nextInt(850);

                }
                answers.add(incorrect);
            }
        }
        b0.setText(Integer.toString(answers.get(0)));
        b1.setText(Integer.toString(answers.get(1)));
        b2.setText(Integer.toString(answers.get(2)));
        b3.setText(Integer.toString(answers.get(3)));

    }

    public void chooseAns(View view){
        if(view.getTag().toString().equals(Integer.toString(locofcorrectans))){
            score++;
            textView3.setText("Correct!");

        }else{
            textView3.setText("Wrong!!");
        }
        noofques++;
        tvscore.setText(Integer.toString(score) + "/" + Integer.toString(noofques));
        generateQues();

     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvscore=(TextView)findViewById(R.id.scoretv);
        tvtimer=(TextView)findViewById(R.id.timertv);
        tvques=(TextView)findViewById(R.id.questv);
        textView3=(TextView)findViewById(R.id.textView3);
        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        pabutton=(Button)findViewById(R.id.buttonpa);


        playAgain(findViewById(R.id.buttonpa));


    }
}

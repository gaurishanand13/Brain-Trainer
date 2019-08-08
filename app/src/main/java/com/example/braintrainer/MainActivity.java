package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int LocationOfCorrectAnswer;
    int score=0;
    int TotalQuestions=0;
    public void set()
    {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();

        TextView sumtextView=(TextView)findViewById(R.id.sumtextView);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);

        Random random=new Random();
        int a=random.nextInt(21);
        int b=random.nextInt(21);
        sumtextView.setText(Integer.toString(a)+" + "+Integer.toString(b));
        LocationOfCorrectAnswer=random.nextInt(4);
        for(int i=0;i<4;i++)
        {
            if(i==LocationOfCorrectAnswer)
            {
                arrayList.add(a+b);
            }
            else
            {
                int c=random.nextInt(41);
                while(c==a+b)
                {
                    c=random.nextInt(41);
                }
                arrayList.add(c);
            }
        }

        button2.setText(Integer.toString(arrayList.get(0)));
        button3.setText(Integer.toString(arrayList.get(1)));
        button4.setText(Integer.toString(arrayList.get(2)));
        button5.setText(Integer.toString(arrayList.get(3)));
    }
    public void go(View view)
    {
        set();
        view.setVisibility(View.INVISIBLE);

        TextView sumtextView=(TextView)findViewById(R.id.sumtextView);
        sumtextView.setVisibility(View.VISIBLE);
        TextView TimertextView=(TextView)findViewById(R.id.TimertextView);
        TimertextView.setVisibility(View.VISIBLE);
        TextView AnswerTextView=(TextView)findViewById(R.id.AnswerTextView);
        AnswerTextView.setVisibility(View.VISIBLE);
        TextView ScoretextView=(TextView)findViewById(R.id.ScoretextView);
        ScoretextView.setVisibility(View.VISIBLE);
        ScoretextView.setText("0/0");

        Button button2=(Button)findViewById(R.id.button2);
        button2.setVisibility(View.VISIBLE);
        Button button3=(Button)findViewById(R.id.button3);
        button3.setVisibility(View.VISIBLE);
        Button button4=(Button)findViewById(R.id.button4);
        button4.setVisibility(View.VISIBLE);
        Button button5=(Button)findViewById(R.id.button5);
        button5.setVisibility(View.VISIBLE);

        onTimer();
    }
    public void onTimer()
    {
        CountDownTimer start=new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView TimertextView=(TextView)findViewById(R.id.TimertextView);
                TimertextView.setText(Integer.toString((int)millisUntilFinished/1000));
            }
            public void onFinish() {
                TextView sumtextView=(TextView)findViewById(R.id.sumtextView);
                sumtextView.setVisibility(View.INVISIBLE);
                TextView TimertextView=(TextView)findViewById(R.id.TimertextView);
                TimertextView.setVisibility(View.INVISIBLE);
                TextView AnswerTextView=(TextView)findViewById(R.id.AnswerTextView);
                AnswerTextView.setVisibility(View.INVISIBLE);
                TextView ScoretextView=(TextView)findViewById(R.id.ScoretextView);
                ScoretextView.setVisibility(View.INVISIBLE);
                Button button2=(Button)findViewById(R.id.button2);
                button2.setVisibility(View.INVISIBLE);
                Button button3=(Button)findViewById(R.id.button3);
                button3.setVisibility(View.INVISIBLE);
                Button button4=(Button)findViewById(R.id.button4);
                button4.setVisibility(View.INVISIBLE);
                Button button5=(Button)findViewById(R.id.button5);
                button5.setVisibility(View.INVISIBLE);

                TextView textView5=(TextView)findViewById(R.id.textView5);
                textView5.setText("SCORE "+Integer.toString(score)+"/"+Integer.toString(TotalQuestions));
                Button button6=(Button)findViewById(R.id.button6);
                button6.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void playAgain(View view)
    {
        score=0;
        TotalQuestions=0;
        TextView textView5=(TextView)findViewById(R.id.textView5);
        textView5.setVisibility(View.INVISIBLE);
        Button button6=(Button)findViewById(R.id.button6);
        button6.setVisibility(View.INVISIBLE);
       go(view);
    }
    public void chooseAnswer(View view)
    {
         if(view.getTag().toString().equals(Integer.toString(LocationOfCorrectAnswer)))
         {
             TextView AnswerTextView=(TextView)findViewById(R.id.AnswerTextView);
             AnswerTextView.setText("CORRECT");
             score++;
         }
         else
         {
             TextView AnswerTextView=(TextView)findViewById(R.id.AnswerTextView);
             AnswerTextView.setText("WRONG");
         }
         TotalQuestions++;
        TextView ScoreTextView=(TextView)findViewById(R.id.ScoretextView);
        ScoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(TotalQuestions));
        set();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

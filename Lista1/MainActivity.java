package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ProgressBar;
import android.widget.Button;



public class MainActivity extends AppCompatActivity
     {
        private TextView questionTextView;
        private Button nextButton;
        private ProgressBar progressBar;
        private RadioGroup radioGroup;
        private RadioButton radioButton1;
         private RadioButton radioButton2;
         private RadioButton radioButton3;
         private RadioButton radioButton4;
         private TextView result;
         private TextView questionNumber;


        private int points = 0;
        private int currentQuestionIndex = 0;
        private int currentAns = -1;

        private Question[] questionBank = new Question[] {
            new Question(R.string.question1, 0, R.string.q1_ans1, R.string.q1_ans2, R.string.q1_ans3, R.string.q1_ans4),
                new Question(R.string.question2, 1, R.string.q2_ans1, R.string.q2_ans2, R.string.q2_ans3, R.string.q2_ans4),
                new Question(R.string.question3, 1, R.string.q3_ans1, R.string.q3_ans2, R.string.q3_ans3, R.string.q3_ans4),
                new Question(R.string.question4, 2, R.string.q4_ans1, R.string.q4_ans2, R.string.q4_ans3, R.string.q4_ans4),
                new Question(R.string.question5, 3, R.string.q5_ans1, R.string.q5_ans2, R.string.q5_ans3, R.string.q5_ans4),
                new Question(R.string.question6, 0, R.string.q6_ans1, R.string.q6_ans2, R.string.q6_ans3, R.string.q6_ans4),
                new Question(R.string.question7, 0, R.string.q7_ans1, R.string.q7_ans2, R.string.q7_ans3, R.string.q7_ans4),
                new Question(R.string.question8, 1, R.string.q8_ans1, R.string.q8_ans2, R.string.q8_ans3, R.string.q8_ans4),
                new Question(R.string.question9, 2, R.string.q9_ans1, R.string.q9_ans2, R.string.q9_ans3, R.string.q9_ans4),
                new Question(R.string.question10, 2, R.string.q10_ans1, R.string.q10_ans2, R.string.q10_ans3, R.string.q10_ans4),
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.button2);
        result = findViewById(R.id.textView5);
        questionTextView = findViewById(R.id.textView4);
        questionNumber = findViewById(R.id.textView3);
        radioGroup = findViewById(R.id.radioGroup1);
        radioButton1 = findViewById(R.id.radioButton2);
        radioButton2 = findViewById(R.id.radioButton3);
        radioButton3 = findViewById(R.id.radioButton4);
        radioButton4 = findViewById(R.id.radioButton5);
        radioButton1.setOnClickListener(view -> currentAns = 0);
        radioButton2.setOnClickListener(view -> currentAns = 1);
        radioButton3.setOnClickListener(view -> currentAns = 2);
        radioButton4.setOnClickListener(view -> currentAns = 3);
        progressBar = findViewById(R.id.progressBar2);



        nextButton.setOnClickListener(view ->
        {
            if(radioGroup.getCheckedRadioButtonId() != -1)
            {
                addPoints();
                if(currentQuestionIndex < 9 )
                {
                    displayQuestion();
                }
                else {
                    showResult();
                }
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void displayQuestion()
    {
        currentQuestionIndex++;
        questionNumber.setText("Pytanie " + currentQuestionIndex + "/10");
        progressBar.setProgress(currentQuestionIndex * 10);
        questionTextView.setText(questionBank[currentQuestionIndex].getQuestionId());
        radioButton1.setText(questionBank[currentQuestionIndex].getAnswers().get(0));
        radioButton2.setText(questionBank[currentQuestionIndex].getAnswers().get(1));
        radioButton3.setText(questionBank[currentQuestionIndex].getAnswers().get(2));
        radioButton4.setText(questionBank[currentQuestionIndex].getAnswers().get(3));
        radioGroup.clearCheck();

    }

    private void addPoints()
    {
        if(questionBank[currentQuestionIndex].checkCorrAns(currentAns))
        {
            points += 10;
        }
    }

    @SuppressLint("SetTextI18n")
    private void showResult()
    {
        result.setText("Zdobył*ś " + points + " punktów");
        result.setVisibility(View.VISIBLE);

    }



}

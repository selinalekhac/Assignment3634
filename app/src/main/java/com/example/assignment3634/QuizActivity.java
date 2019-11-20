package com.example.assignment3634;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;


    private ColorStateList textColorDefaultRb;


    private List<Questions> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;

    private int score;
    // decides what happens after the question. Answered or not answered
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_counter);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        //save default color in variable
        textColorDefaultRb = rb1.getTextColors();

        QuestionsAndAnswersDatabase dbHelper = new QuestionsAndAnswersDatabase();
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();
        //lock button

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if answer is not answered yet
                if(!answered){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    } else{
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_LONG).show();
                    }
                } else{
                    showNextQuestion();
                }

            }
        });
    }

    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        //checks if we have reached the max. number of questions
        if(questionCounter< questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getWrongAnswer1());
            rb2.setText(currentQuestion.getWrongAnswer2());
            rb3.setText(currentQuestion.getWrongAnswer3());
            rb4.setText(currentQuestion.getCorrectAnswer());

            questionCounter++;
            textViewQuestionCount.setText("Question: "+ questionCounter + "/" + questionCountTotal);
            // lock answer instead of moving to next question
            answered = false;
            buttonConfirmNext.setText("Confirm");

        } else{
            finishQuiz();
        }

    }
    private void checkAnswer(){
        answered = true;
        //return the id of the button in variable 'rbSelected'
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        //turn index of radiobutton into an integer
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        //check if the selected answer is correct by matching it with the correct index value
        if(answerNr ==currentQuestion.getQuestionID()){
            score++;
            textViewScore.setText("Score: " + score);

        }
        //outside as you always want to show solution
        showSolution();
    }
    //changing the colour of the buttons according to what is correct and what is wrong
    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        //change the correct button to Green to signify correct answer

        switch(currentQuestion.getQuestionID()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;

            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;

            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;

            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 4 is correct");
        }

        // Now we need to change the button back to default colour for next question
        if(questionCounter<questionCountTotal){
            buttonConfirmNext.setText("Next");

        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz(){
        finish();
    }
    }




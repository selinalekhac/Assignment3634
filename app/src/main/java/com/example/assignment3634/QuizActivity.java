package com.example.assignment3634;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment3634.Fragments.HomepageFragment;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    //Timer Variables
    //for each question we set 10 minutes
    private static final long COUNTDOWN_IN_MILLIS = 30000;


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

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliSeconds;


    private List<Questions> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;


    public int score;
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


        QuestionsAndAnswersDatabase questionsDatabase = new QuestionsAndAnswersDatabase();
        questionList = questionsDatabase.getAllQuestions();
        questionCountTotal = questionList.size();
        //Collections.shuffle(questionList);

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


        //setting questions to the assigned variables on screen
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getAnswer1());
            rb2.setText(currentQuestion.getAnswer2());
            rb3.setText(currentQuestion.getAnswer3());
            rb4.setText(currentQuestion.getAnswer4());

            questionCounter++;
            textViewQuestionCount.setText("Question: "+ questionCounter + "/" + questionCountTotal);
            // lock answer instead of moving to next question
            answered = false;
            buttonConfirmNext.setText("Confirm");

            //start countdown when we show first question

            //setting timer to 30 seconds
            timeLeftInMilliSeconds = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else{
            finishQuiz();
        }

    }
    //method to start count down timer
    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            timeLeftInMilliSeconds = millisUntilFinished;
            updateCountDownText();
            }

            @Override
            public void onFinish() {
                //To make sure 0:00 seconds is displayed on timer when it runs out
                timeLeftInMilliSeconds =0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    //update count down text method. Will be called everytime onTick method is called which is 1 every second
    private void updateCountDownText(){
        // need to get seconds
        int minutes = (int)(timeLeftInMilliSeconds/1000) / 60;
        // we only get what is left after dividing by 60
        int seconds = (int)(timeLeftInMilliSeconds/1000)% 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);


    }
    private void checkAnswer(){
        answered = true;
        //if user answers the question correctly, the timer needs to stop
        countDownTimer.cancel();
        //return the id of the button in variable 'rbSelected'
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        //turn index of radiobutton into an integer
        int answerNr = rbGroup.indexOfChild(rbSelected)+1;
        //check if the selected answer is correct by matching it with the correct index value
        if(answerNr == currentQuestion.getAnswerNr()){

            score++;
            textViewScore.setText("Quiz Score: " + score);
//
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

        switch(currentQuestion.getAnswerNr()){
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

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }

    }

//    public void sendData(){
//        Bundle bundle = new Bundle();
//        bundle.putInt("SCORE_KEY", Integer.valueOf(score) );
//
//        HomepageFragment myFragment = new HomepageFragment();
//        myFragment.setArguments(bundle);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).commit();
//    }

    }





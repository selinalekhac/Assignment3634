package com.example.assignment3634;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    private TextView QuestionTV;
    private TextView ScoreTV;
    private TextView QuestionCountTV;
    private TextView CountDownTV;

    private RadioGroup radioGroup1;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    private Button buttonConfirmNext;

    private ColorStateList radioButtonDefaultColour;

    private List<Questions> questionList;

    private CountDownTimer countDownTimer;
    private long timeLeft;
    //Timer Variables - for each question we set timer to 45 seconds each
    private static final long countDownTime = 45000;
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

        //Assigning variables to what is on the layout
        QuestionTV = findViewById(R.id.text_view_question);
        ScoreTV = findViewById(R.id.text_view_score);
        QuestionCountTV = findViewById(R.id.text_view_question_count);
        CountDownTV = findViewById(R.id.text_view_counter);
        radioGroup1 = findViewById(R.id.radio_group);
        radioButton1 = findViewById(R.id.radio_button1);
        radioButton2 = findViewById(R.id.radio_button2);
        radioButton3 = findViewById(R.id.radio_button3);
        radioButton4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        //Set up questionsDatabase which will get all the questions from DB
        QuestionsAndAnswersDatabase questionsDatabase = new QuestionsAndAnswersDatabase();
        questionList = questionsDatabase.getAllQuestions();

        //Maximum number of questions in the quiz
        questionCountTotal = 5;

        //save default color in variable
        radioButtonDefaultColour = radioButton1.getTextColors();

        //will randomly shuffle questions so that each time a quiz is taken, user will get different questions
        Collections.shuffle(questionList);

        //lock button
        showNextQuestion();


        //set toast message when user clicks next without selecting an answer
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if answer is not answered yet
                if(!answered){
                    if (radioButton4.isChecked() || radioButton3.isChecked() || radioButton2.isChecked() || radioButton1.isChecked()){
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
            //set the default colours of the button prior to clicking
            radioButton1.setTextColor(radioButtonDefaultColour);
            radioButton2.setTextColor(radioButtonDefaultColour);
            radioButton3.setTextColor(radioButtonDefaultColour);
            radioButton4.setTextColor(radioButtonDefaultColour);

             //Need to change it back once it has been clicked for next question
             radioGroup1.clearCheck();

             //checks if we have reached the max. number of questions
             if(questionCounter< questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

             //setting questions to the assigned variables on screen
            QuestionTV.setText(currentQuestion.getQuestion());
            radioButton1.setText(currentQuestion.getAnswer1());
            radioButton2.setText(currentQuestion.getAnswer2());
            radioButton3.setText(currentQuestion.getAnswer3());
            radioButton4.setText(currentQuestion.getAnswer4());


            questionCounter++;
            QuestionCountTV.setText("Question: "+ questionCounter + "/" + questionCountTotal);

            // lock answer instead of moving to next question
            answered = false;
            buttonConfirmNext.setText("Confirm");

            //start countdown when we show first question - setting timer to 45 seconds
            timeLeft = countDownTime;
            startCountDown();
            } else{
            finishQuiz();
          }
          }

        //method to start count down timer
        private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeft, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
        timeLeft = millisUntilFinished;
        updateCountDownText();
        }

        @Override
        public void onFinish() {

        //To make sure 0:00 seconds is displayed on timer when it runs out
        timeLeft =0;
        updateCountDownText();
         checkAnswer();
            }
        }.start();
    }

    //Code Referencing: https://stackoverflow.com/questions/56636105/how-can-i-create-a-time-counter-in-android-studio - used to help set up counter timer
    //Code Referencing: https://www.youtube.com/watch?v=bLUXfWkZMD8&t=486 - used to help set up counter timer

        //update count down text method. Will be called every time onTick method is called which is 1 every second
    private void updateCountDownText(){

        // need to get seconds
        int minutes = (int)(timeLeft/1000) / 60;

        // we only get what is left after dividing by 60
        int seconds = (int)(timeLeft/1000)% 60;

        String formattedTime = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        CountDownTV.setText(formattedTime);
    }


    private void checkAnswer(){
        answered = true;

        //if user answers the question correctly, the timer needs to stop
        countDownTimer.cancel();

        //return the id of the button in variable 'rbSelected'
        RadioButton buttonSelected = findViewById(radioGroup1.getCheckedRadioButtonId());

        //turn index of radiobutton into an integer
        int answerNumber = radioGroup1.indexOfChild(buttonSelected)+1;

        //check if the selected answer is correct by matching it with the correct index value
        if(answerNumber == currentQuestion.getAnswerNumber()){
            score++;
            ScoreTV.setText("Quiz Score: " + score);
//
        }

       //outside as you always want to show solution
        showSolution();

    }
    //changing the colour of the buttons according to what is correct and what is wrong
    //Code Referencing: https://www.youtube.com/watch?v=tlgrX3HF6AI&t=614 - set up changes in radiobuttons when clicked
    private void showSolution(){
        radioButton1.setTextColor(Color.RED);
        radioButton2.setTextColor(Color.RED);
        radioButton3.setTextColor(Color.RED);
        radioButton4.setTextColor(Color.RED);

        //change only the correct answer to Green to signify correct answer
        switch(currentQuestion.getAnswerNumber()){
            case 1:
                radioButton1.setTextColor(Color.GREEN);
                QuestionTV.setText("Answer 1 is correct");
                break;

            case 2:
                radioButton2.setTextColor(Color.GREEN);
                QuestionTV.setText("Answer 2 is correct");
                break;

            case 3:
                radioButton3.setTextColor(Color.GREEN);
                QuestionTV.setText("Answer 3 is correct");
                break;

            case 4:
                radioButton4.setTextColor(Color.GREEN);
                QuestionTV.setText("Answer 4 is correct");
        }

        // Now we need to change the button back to default text for next question
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





package com.example.assignment3634;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    private int questionID;  //unique identifier for questions
    private String contextPassage; // Paragraph of context
    private String question; // question they will be answering
    private String answer1; //correct answer
    private String answer2; //an incorrect answer
    private String answer3; // another incorrect answer
    private String answer4; // another incorrect answer
    private int answerNumber;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;

    public Questions() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

//        radioGroup = findViewById(R.id.radioGroup);
//        textView = findViewById(R.id.results_id);
//
//        Button buttonCheckAnswer = findViewById(R.id.checkanswer_id);
//        buttonCheckAnswer.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                int radioID = radioGroup.getCheckedRadioButtonId();
//                radioButton = findViewById(radioID);
//
//                textView.setText(R.string.youranswer);
//            }
//        });

    } // onCreate method bracket

//    public void checkAnswer(){
//        int radioID = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioID);
//        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
//    }



    public Questions (int questionID, String contextPassage, String question, String answer1, String answer2, String answer3, String answer4, int answerNr){
        this.questionID = questionID;
//        this.contextPassage = contextPassage;
        this.question = question;
        this.answer1= answer1;
        this.answer2= answer2;
        this.answer3= answer3;
        this.answer4= answer4;
        this.answerNumber = answerNr;

    }

    // getter and setters
    public int getQuestionID(){
        return questionID;
    }
    public void setQuestionID(int questionID){
        this.questionID = questionID;
    }

//    public String getContextPassage(){
//        return contextPassage;
//    }
//    public void setContextPassage(String contextPassage){
//        this.contextPassage = contextPassage;
//    }

    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }

//    public String getCorrectAnswer(){
//        return correctAnswer;
//    }
//    public void setCorrectAnswer(String correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }


    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void checkAnswer(View view) {
//
//        int radioID = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioID);
        Toast.makeText(this, "You have selected: ", Toast.LENGTH_SHORT).show();
    }

}// this curly bracket is for the public class Questions extends App Compat

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
    private String correctAnswer; //correct answer
    private String wrongAnswer1; //an incorrect answer
    private String wrongAnswer2; // another incorrect answer
    private int actualAnswer;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;



    private String wrongAnswer3; // another incorrect answer
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



    public Questions (int questionID, String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, int actualAnswer){
        this.questionID = questionID;
//        this.contextPassage = contextPassage;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.actualAnswer = actualAnswer;
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

    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }
    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }
    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }
    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public int getActualAnswer() {
        return actualAnswer;
    }

    public void setActualAnswer(int actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public void OnClickCheckAnswer(View view) {
        //button

    }

    public void checkAnswer(View view) {
        boolean checked = ((RadioButton)view).isChecked();

if (checked){
    Toast.makeText(view.getContext(), "You have chosen an Answer", Toast.LENGTH_LONG).show(); // toast to have selected this answer
}

//        rb1 = view.findViewById(R.id.correctAnswer_id);
//        rb2 = view.findViewById(R.id.wronganswer1_id);
//        rb3 = view.findViewById(R.id.wronganswer2_id);
//        rb4 = view.findViewById(R.id.wronganswer3_id);
//        radioGroup = view.findViewById(R.id.radioGroup);
//
//
//        //radio button
//        boolean checked = ((RadioButton)view).isChecked();
//        switch (radioGroup.getCheckedRadioButtonId()){
//            case R.id.correctAnswer_id:
//                if (checked)
//                Toast.makeText(view.getContext(), "You have chosen Answer 1", Toast.LENGTH_LONG).show(); // toast to have selected this answer
//                break;
//            case R.id.wronganswer1_id:
//                if (checked)
//                    Toa rb1 = view.findViewById(R.id.correctAnswer_id);
////        rb2 = view.findViewById(R.id.wronganswer1_id);
////        rb3 = view.findViewById(R.id.wronganswer2_id);
////        rb4 = view.findViewById(R.id.wronganswer3_id);
////        radioGroup = view.findViewById(R.id.radioGroup);
////
////
////        //radio button
////        boolean checked = ((RadioButton)view).isChecked();
////        switch (radioGroup.getCheckedRadioButtonId()){
////            case R.id.correctAnswer_id:
////                if (checked)
////                Toast.makeText(view.getContext(), "You have chosen Answer 1", Toast.LENGTH_LONG).show(); // toast to have selected this answer
////                break;
////            case R.id.wronganswer1_id:
////                if (checked)
////                    Toast.makeText(view.getContext(), "You have chosen Answer 2", Toast.LENGTH_LONG).show(); // toast to have selected this answer
////                break;
////            case R.id.wronganswer2_id:
////                if (checked)
////                    Toast.makeText(view.getContext(), "You have chosen Answer 3", Toast.LENGTH_LONG).show(); // toast to have selected this answer
////                break;
////            case R.id.wronganswer3_id:
////                if (checked)
////                    Toast.makeText(view.getContext(), "You have chosen Answer 4", Toast.LENGTH_LONG).show(); // toast to have selected this answer
////                break;
////        }// switch bracketst.makeText(view.getContext(), "You have chosen Answer 2", Toast.LENGTH_LONG).show(); // toast to have selected this answer
//                break;
//            case R.id.wronganswer2_id:
//                if (checked)
//                    Toast.makeText(view.getContext(), "You have chosen Answer 3", Toast.LENGTH_LONG).show(); // toast to have selected this answer
//                break;
//            case R.id.wronganswer3_id:
//                if (checked)
//                    Toast.makeText(view.getContext(), "You have chosen Answer 4", Toast.LENGTH_LONG).show(); // toast to have selected this answer
//                break;
//        }// switch bracket
    }// checkAnswer method bracket
}// this curly bracket is for the public class Questions extends App Compat

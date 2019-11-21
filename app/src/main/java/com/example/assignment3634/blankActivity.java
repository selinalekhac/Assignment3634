package com.example.assignment3634;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class blankActivity extends AppCompatActivity {

   private TextView words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_activity);

        Intent intent = getIntent();

//        int answer1 = intent.getIntExtra("answer1", 0);
        String answer1 = getIntent().getStringExtra("answer1");

//        Questions questions = new Questions();

//        int x = QuestionsAndAnswersDatabase.getQuestionsById(0); // the 0 should be the question id
//        switch (x){
//            case 1:
//                words = findViewById(R.id.textView);
//                words.setText(QuestionsAndAnswersDatabase.getQuestionsById(x));
//        }
//
//        if (int a = 1){
//            Questions questions = QuestionsAndAnswersDatabase.getQuestionsById(a);
//            words = findViewById(R.id.textView);
//            words.setText(questions.getAnswer1());
//        } else (int a = 2){
//            Questions questions = QuestionsAndAnswersDatabase.getQuestionsById(a);
//            words = findViewById(R.id.textView);
//            words.setText(questions.getAnswer1());
//        } else (int c = 3){
//            Questions questions = QuestionsAndAnswersDatabase.getQuestionsById(c);
//            words = findViewById(R.id.textView);
//            words.setText(questions.getAnswer1());
//        }



//        for (int x =1;x<5;x++)
//        {
//            Questions questions = QuestionsAndAnswersDatabase.getQuestionsById(x);
//            words = findViewById(R.id.textView);
//
//            words.setText(questions.getAnswer1());
//        }


        ;





    }
    



}


package com.example.assignment3634.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.assignment3634.Questions;
import com.example.assignment3634.QuestionsAdapter;
import com.example.assignment3634.QuestionsAndAnswersDatabase;
import com.example.assignment3634.R;


public class FragmentQuestionRecycler extends Fragment {

    private RecyclerView recyclerView;

    public FragmentQuestionRecycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_fragment_question_recycler, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_questions_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        QuestionsAdapter questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setData(QuestionsAndAnswersDatabase.getAllQuestions());
        recyclerView.setAdapter(questionsAdapter);

        Button checkAnswerButton = (Button) view.findViewById(R.id.checkanswer_id);

//        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // checkAnswer();
////                Intent intent = new Intent(getActivity(), QuizActivity.class);
////                intent.putExtra("questionID",1);
////                startActivity(intent);
//                Toast.makeText(getActivity(), "Text!", Toast.LENGTH_SHORT).show();
//            }
//        });


        return view;
    } // this curly bracket is for the onCreateView

//    public void checkAnswer() {
//        RadioButton rbSelected = v.findViewById(radioGroup.getCheckedRadioButtonId());
//        int answerNr = radioGroup.indexOfChild(rbSelected) + 1;
//        //check if the selected answer is correct by matching it with the correct index value
//        if (answerNr == Questions.getQuestionID) {
//
//
//        }


    }


package com.example.assignment3634;

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

        return view;
    } // this curly bracket is for the onCreateView




}

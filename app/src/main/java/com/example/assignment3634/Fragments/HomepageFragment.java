package com.example.assignment3634.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment3634.QuizActivity;
import com.example.assignment3634.R;

public class HomepageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage, container, false);


        Button playButton = (Button) view.findViewById(R.id.start_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNext();
//                Intent intent = new Intent(getActivity(), QuizActivity.class);
//                intent.putExtra("questionID",1);
//                startActivity(intent);
                Toast.makeText(getActivity(), "Quiz has started", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void moveToNext() {
        Intent intent = new Intent(getContext(), QuizActivity.class);
        startActivity(intent);
    }

//    public void onClickToQuiz(View v) {
//
//
//    }




}

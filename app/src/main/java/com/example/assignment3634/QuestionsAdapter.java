package com.example.assignment3634;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//if this doesnt work
public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder> {

     private ArrayList<Questions> questionsToAdapt;
    public void setData(ArrayList<Questions> questionsToAdapt){
        this.questionsToAdapt = questionsToAdapt;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_questions, parent, false);
        QuestionsViewHolder questionsViewHolder = new QuestionsViewHolder(view);
        final Button checkAnswerButton = view.findViewById(R.id.checkanswer_id);

//        checkAnswerButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "You have chosen the correct answer",Toast.LENGTH_LONG).show();
//            }

        return questionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {

        final Questions questionsAtPosition = questionsToAdapt.get(position);
        holder.questionIDTextView.setText(Integer.toString(questionsAtPosition.getQuestionID()));
       // holder.contextPassageTextView.setText(questionsAtPosition.getContextPassage());
        holder.questionTextView.setText(questionsAtPosition.getQuestion());
        holder.correctAnswerRadioButton.setText(questionsAtPosition.getAnswer4());
        holder.wrongAnswer1RadioButton.setText(questionsAtPosition.getAnswer1());
        holder.wrongAnswer2RadioButton.setText(questionsAtPosition.getAnswer2());
        holder.wrongAnswer3RadioButton.setText(questionsAtPosition.getAnswer3());
        holder.checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, blankActivity.class );
               intent.putExtra("answer1", questionsAtPosition.getAnswer1());
                context.startActivity(intent);
            }
        });

    } // onBindViewHolder bracket

    @Override
    public int getItemCount() {
        return questionsToAdapt.size();
    }

    public class QuestionsViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView questionIDTextView;
//        public TextView contextPassageTextView;
        public TextView questionTextView;
        public RadioButton correctAnswerRadioButton;
        public RadioButton wrongAnswer1RadioButton;
        public RadioButton wrongAnswer2RadioButton;
        public RadioButton wrongAnswer3RadioButton;
        public Button checkAnswerButton;


        public QuestionsViewHolder( View v) {
            super(v);
            view = v;
            questionIDTextView = v.findViewById(R.id.questionID_id);
//            contextPassageTextView = v.findViewById(R.id.contextPassage_id);
            questionTextView = v.findViewById(R.id.question_id);
            correctAnswerRadioButton = v.findViewById(R.id.correctAnswer_id);
            wrongAnswer1RadioButton = v.findViewById(R.id.wronganswer1_id);
            wrongAnswer2RadioButton = v.findViewById(R.id.wronganswer2_id);
            wrongAnswer3RadioButton = v.findViewById(R.id.wronganswer3_id);
            checkAnswerButton = v.findViewById(R.id.checkanswer_id);



        }
    }


} // curly bracket for public class QuestinonsAdapter extends RecyclerView

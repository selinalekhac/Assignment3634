package com.example.assignment3634;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
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

        }
    }


} // curly bracket for public class QuestinonsAdapter extends RecyclerView

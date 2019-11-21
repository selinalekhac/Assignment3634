package com.example.assignment3634;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private boolean answered;
    public TextView questionIDTextView;



    public void setData(ArrayList<Questions> questionsToAdapt){
        this.questionsToAdapt = questionsToAdapt;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_questions, parent, false);
        QuestionsViewHolder questionsViewHolder = new QuestionsViewHolder(view);
        final Button checkAnswerButton = view.findViewById(R.id.checkanswer_id);

        rb1 = view.findViewById(R.id.correctAnswer_id);
        rb2 = view.findViewById(R.id.wronganswer1_id);
        rb3 = view.findViewById(R.id.wronganswer2_id);
        rb4 = view.findViewById(R.id.wronganswer3_id);
        radioGroup = view.findViewById(R.id.radioGroup);


        rb1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You have chosen answer 1", Toast.LENGTH_LONG).show(); // toast to have selected this answer

            }
        });

        rb2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You have chosen answer 2", Toast.LENGTH_LONG).show(); // toast to have selected this answer

            }
        });

        rb3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You have chosen answer 3", Toast.LENGTH_LONG).show(); // toast to have selected this answer

            }
        });

        rb4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You have chosen answer 4", Toast.LENGTH_LONG).show(); // toast to have selected this answer

            }
        });


        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(radioGroup.getCheckedRadioButtonId()== -1){
//                    Toast.makeText(v.getContext(), "Please Select an Answer", Toast.LENGTH_LONG).show();
//                }  else if (rb1.isChecked()){
////                    int selectID = radioGroup.getCheckedRadioButtonId();
////                    RadioButton selectedRB = v.findViewById(selectID);
//                    Toast.makeText(v.getContext(), "Answer 1 is selected", Toast.LENGTH_LONG).show();
//                } else if (rb2.isChecked()) {
//                    Toast.makeText(v.getContext(), "Answer 2 is selected", Toast.LENGTH_LONG).show();
//                } else if (rb3.isChecked()){
//                    Toast.makeText(v.getContext(), "Answer 3 is selected", Toast.LENGTH_LONG).show();
//                } else if (rb4.isChecked()){
//                    Toast.makeText(v.getContext(), "Answer 4 is selected", Toast.LENGTH_LONG).show();
//                }




//                if (answered){
//                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
//                        Toast.makeText(v.getContext(), "You have chosen the correct answer", Toast.LENGTH_LONG).show(); // toast to have selected this answer
//                    }
//
//                }

                Toast.makeText(v.getContext(), "You have chosen the correct answer", Toast.LENGTH_LONG).show(); // toast to have selected this answer

            }

        }); // for onClickListener


        return questionsViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {

        final Questions questionsAtPosition = questionsToAdapt.get(position);
        holder.questionIDTextView.setText(Integer.toString(questionsAtPosition.getQuestionID()));
       // holder.contextPassageTextView.setText(questionsAtPosition.getContextPassage());
        holder.questionTextView.setText(questionsAtPosition.getQuestion());
        holder.correctAnswerRadioButton.setText(questionsAtPosition.getCorrectAnswer());
        holder.wrongAnswer1RadioButton.setText(questionsAtPosition.getWrongAnswer1());
        holder.wrongAnswer2RadioButton.setText(questionsAtPosition.getWrongAnswer2());
        holder.wrongAnswer3RadioButton.setText(questionsAtPosition.getWrongAnswer3());

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
        public RadioGroup radioGroup;
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
            radioGroup = v.findViewById(R.id.radioGroup);

        }
    } // question view holder




} // curly bracket for public class QuestinonsAdapter extends RecyclerView

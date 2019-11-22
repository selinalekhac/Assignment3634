package com.example.assignment3634;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class DictionaryFragment extends Fragment {
    private TextView defineWord;
    private TextView showDefinition;
    String url;
    private ImageView sharebutton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_definition_item, container, false);


        showDefinition = view.findViewById(R.id.definitionIs);
        defineWord =  view.findViewById(R.id.defineWord);
        url = retrieveDefinition();

        Button defineButton = (Button) view.findViewById(R.id.button);

        //when the button is clicked, it retrieves definition from Oxford API
        defineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DictionaryRequest dictionaryRequest = new DictionaryRequest(getActivity(), showDefinition);

                url = retrieveDefinition();
                dictionaryRequest.execute(url);
            }
        });


        sharebutton = view.findViewById(R.id.shareButton);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Look at this new cool word I learnt today! ");
                startActivity(intent);
            }
        });

        return view;

    }

    //Code Referencing: https://developer.oxforddictionaries.com/documentation/getting_started - used to set up and send GET request to API
        private String retrieveDefinition() {
            final String language = "en-gb";
            String word = defineWord.getText().toString();
            String fields = "definitions";
            final String word_id = word.toLowerCase();
            final String strictMatch = "false";

            return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;

    }


}

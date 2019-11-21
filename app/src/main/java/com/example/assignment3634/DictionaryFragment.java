package com.example.assignment3634;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.StringRequest;
import com.example.assignment3634.R;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFragment extends Fragment {
    private TextView enterWord;
    private TextView showDef;
    private ConstraintLayout definitions;
    String url;
    private ImageView sharebutton;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_definition_item, container, false);

        showDef = view.findViewById(R.id.textView2);
        enterWord =  view.findViewById(R.id.editText);
        url = dictionaryEntries();

        Button defineButton = (Button) view.findViewById(R.id.button);

        defineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DictionaryRequest dictionaryRequest = new DictionaryRequest(getActivity(), showDef);

                url = dictionaryEntries();
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

    private String dictionaryEntries() {
    final String language = "en-gb";
    String word = enterWord.getText().toString();
    String fields = "definitions";
    final String word_id = word.toLowerCase();
    final String strictMatch = "false";
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;



    }


}

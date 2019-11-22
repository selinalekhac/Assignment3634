package com.example.assignment3634;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>{

    private ArrayList<FavouriteDefinitions> definitionsToAdapt;

    public void setData(ArrayList<FavouriteDefinitions> definitionsToAdapt){
        this.definitionsToAdapt = definitionsToAdapt;
    }

    @NonNull
    @Override
    public FavouritesAdapter.FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_definition, parent, false);
        FavouritesAdapter.FavouritesViewHolder favouritesViewHolder = new FavouritesViewHolder(view);

        return favouritesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesAdapter.FavouritesViewHolder holder, int position) {

        final FavouriteDefinitions definitionAtPosition = definitionsToAdapt.get(position);
        holder.favouriteWord.setText(definitionAtPosition.getWord());
        holder.wordDefinition.setText(definitionAtPosition.getDefinition());

    }

    @Override
    public int getItemCount() {
        return definitionsToAdapt.size();
    }

    public interface onItemClickListener {
    }


    public class FavouritesViewHolder extends RecyclerView.ViewHolder {
        public TextView favouriteWord;
        public TextView wordDefinition;


        public FavouritesViewHolder(@NonNull View itemView) {
            super(itemView);

            favouriteWord = itemView.findViewById(R.id.favourite_word);
            wordDefinition = itemView.findViewById(R.id.word_definition);

        }
    }
}

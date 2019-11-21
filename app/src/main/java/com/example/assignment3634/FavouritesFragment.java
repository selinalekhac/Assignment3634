package com.example.assignment3634;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    private RecyclerView favouritesRecyclerView;
    private FavouritesAdapter favouritesAdapter;
    private ArrayList<FavouriteDefinitions> definitions;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.favourites_fragment, container, false);
        favouritesRecyclerView = view.findViewById(R.id.favourites_recyclerView);


        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        favouritesRecyclerView.setLayoutManager(layoutManager);

        FavouritesAdapter favouritesAdapter = new FavouritesAdapter();
        favouritesAdapter.setData(FavouritesDB.getAllDefinitions());
        favouritesRecyclerView.setAdapter(favouritesAdapter);


        return view;
    }

}

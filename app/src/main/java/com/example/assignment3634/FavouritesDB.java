package com.example.assignment3634;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FavouritesDB {

    private static final ArrayList<FavouriteDefinitions> favouriteWords = new ArrayList<>();
    private static final ArrayList<FavouriteDefinitions> favouriteDefinition = new ArrayList<>();

   public static ArrayList<FavouriteDefinitions> getAllDefinitions (){
       return favouriteWords;

    }

}

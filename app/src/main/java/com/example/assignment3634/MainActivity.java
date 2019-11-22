package com.example.assignment3634;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment3634.Fragments.FragmentQuestionRecycler;
import com.example.assignment3634.Fragments.HomepageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new HomepageFragment();

        swapFragment(fragment);

        //Navigation Bar Setup
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.home_page) {
                    Fragment fragment = new HomepageFragment();
                    swapFragment(fragment);
                    return true;

                } else if (menuItem.getItemId() == R.id.activities_page) {
                    Fragment fragment = new FragmentQuestionRecycler();
                    swapFragment(fragment);
                    return true;

                } else if (menuItem.getItemId() ==R.id.dictionary_page){
                    Fragment fragment = new DictionaryFragment();
                    swapFragment(fragment);
                    return true;
                }

                return false;
            }
        });
    }

        private void swapFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_homepage, fragment);
            fragmentTransaction.commit();

        }

    }


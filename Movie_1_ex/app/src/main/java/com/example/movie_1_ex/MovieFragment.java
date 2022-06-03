package com.example.movie_1_ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MovieFragment extends Fragment {



    public MovieFragment() {
        // Required empty public constructor
    }


    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return null;
    }


}
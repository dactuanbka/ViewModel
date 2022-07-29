package com.example.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;

public class StudentDetailFragment extends Fragment {

    public StudentDetailFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static StudentDetailFragment newInstance(String param1, String param2) {
        StudentDetailFragment fragment = new StudentDetailFragment();
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
        View view= inflater.inflate(R.layout.fragment_student_detail, container, false);
        return view;
    }
}
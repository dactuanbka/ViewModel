package com.example.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ViewModelFactory.AddViewModelFactory;
import com.example.baseproject.databinding.FragmentAddStudentBinding;
import com.example.database_dao.Student;
import com.example.viewModel.AddViewModel;

import java.util.List;

public class AddStudentFragment extends Fragment {

    public AddStudentFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAddStudentBinding fragmentAddStudentBinding= FragmentAddStudentBinding.inflate(inflater);
        AddViewModel addViewModel= new ViewModelProvider(requireActivity(),
                new AddViewModelFactory(requireContext())).get(AddViewModel.class);
        fragmentAddStudentBinding.setAddViewModel(addViewModel);
        fragmentAddStudentBinding.setLifecycleOwner(this);

        fragmentAddStudentBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViewModel.updateStudents();
            }
        });
        addViewModel.updateStudents().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
                    @Override
                    public void onChanged(List<Student> students) {
                        Log.i("AddViewModelList",""+students.size());
                    }
                }
        );

        return fragmentAddStudentBinding.getRoot();
    }
}
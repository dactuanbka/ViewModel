package com.example.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ViewModelFactory.ListViewModelFactory;
import com.example.adapter.StudentAdapter;
import com.example.baseproject.R;

import com.example.baseproject.databinding.FragmentListStudentsBinding;
import com.example.database_dao.Student;
import com.example.viewModel.ListStudentViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListStudentsFragment extends Fragment implements StudentAdapter.PassData {
    List<Student> studentList;
    FragmentListStudentsBinding fragmentListStudentBinding;
    ListStudentViewModel listStudentViewModel;

    public ListStudentsFragment() {
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
        fragmentListStudentBinding = FragmentListStudentsBinding.inflate(inflater);
        listStudentViewModel = new ViewModelProvider(requireActivity(),
                new ListViewModelFactory(requireContext().getApplicationContext())).
                get(ListStudentViewModel.class);

        studentList = new ArrayList<>();
        StudentAdapter studentAdapter = new StudentAdapter(studentList, this);
        // observer list.
        listStudentViewModel.getStudents().observe(getViewLifecycleOwner(), // lifecycle
                new Observer<List<Student>>() {
                    @Override
                    public void onChanged(List<Student> students) {
                        Log.d("log", "onChanged: " + students.size());
                        studentAdapter.setData(students);
                    }
                });
        fragmentListStudentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        fragmentListStudentBinding.recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(),
                1));
        fragmentListStudentBinding.recyclerView.setAdapter(studentAdapter);
// Nav to Add fragment
        fragmentListStudentBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(fragmentListStudentBinding.getRoot());
                navController.navigate(R.id.action_listStudents_to_addStudent);
            }
        });
        return fragmentListStudentBinding.getRoot();
    }
// Nav to Detail Fragment
    @Override
    public void onItemClick(Student student) {
        listStudentViewModel.setData(student);
        NavController navController = Navigation.findNavController(fragmentListStudentBinding.getRoot());
        navController.navigate(R.id.action_listStudents_to_studentDetail);
    }
}
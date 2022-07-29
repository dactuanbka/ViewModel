package com.example.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ViewModelFactory.ListViewModelFactory;
import com.example.baseproject.R;
import com.example.baseproject.databinding.FragmentListStudentsBinding;
import com.example.baseproject.databinding.FragmentStudentDetailBinding;
import com.example.database_dao.Student;
import com.example.viewModel.DetailViewModel;
import com.example.viewModel.ListStudentViewModel;

public class StudentDetailFragment extends Fragment {
    FragmentStudentDetailBinding fragmentStudentDetailBinding;
    Student student= new Student();
    DetailViewModel detailViewModel;
    ListStudentViewModel listStudentViewModel;
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
        fragmentStudentDetailBinding= FragmentStudentDetailBinding.inflate(inflater);
        detailViewModel= new ViewModelProvider(requireActivity()).get(DetailViewModel.class);
        listStudentViewModel= new ViewModelProvider(requireActivity(),
                new ListViewModelFactory(requireContext().getApplicationContext())).get(ListStudentViewModel.class);
        student=listStudentViewModel.getDetailData();
        fragmentStudentDetailBinding.setModel(student);
        // Inflate the layout for this fragment
        return fragmentStudentDetailBinding.getRoot();
    }
}
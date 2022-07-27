package com.example.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseproject.R;
import com.example.baseproject.databinding.ItemStudentBinding;

import java.util.List;

import com.example.database_dao.Student;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemStudentBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_student,
                parent, false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (studentList != null) {
            return studentList.size();
        }
        return 0;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        private final ItemStudentBinding mBinding;
        public StudentViewHolder(@NonNull ItemStudentBinding binding) {
            super(binding.getRoot());
            mBinding = binding;

        }
    }
}

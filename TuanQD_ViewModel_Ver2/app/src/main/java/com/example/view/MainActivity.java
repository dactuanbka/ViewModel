package com.example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.baseproject.R;

import java.util.ArrayList;
import java.util.List;

import com.example.database_dao.Student;
import com.example.database_dao.StudentDao;
import com.example.database_dao.StudentDatabase;

public class MainActivity extends AppCompatActivity {
    StudentDatabase studentDatabase;
    List<Student> listStudent;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = new Student("tuan", 24);
        listStudent = new ArrayList<>();

    }
}
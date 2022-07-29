package com.example.viewModel;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.database_dao.Student;
import com.example.database_dao.StudentDao;
import com.example.database_dao.StudentDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListStudentViewModel extends ViewModel {
    Context mContext;
    private StudentDatabase studentDatabase;
    private MutableLiveData<List<Student>> listStudents;

    public ListStudentViewModel(Context Context) {
        this.mContext = Context;
    }

    // load data
    public LiveData<List<Student>> getStudents() {
        studentDatabase = StudentDatabase.getInstance(mContext);
        StudentDao studentDao = studentDatabase.studentDao();

        return studentDao.getAll();
    }

    private void loadStudents() {
        studentDatabase = StudentDatabase.getInstance(mContext);
        StudentDao studentDao = studentDatabase.studentDao();

        studentDao.getAll();
    }


}

package com.example.viewModel;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.database_dao.Student;
import com.example.database_dao.StudentDao;
import com.example.database_dao.StudentDatabase;

import java.util.List;
import java.util.Objects;

public class AddViewModel extends ViewModel {

    private static final String TAG = "AddViewModel";
    public MutableLiveData<String> nameNewStudent = new MutableLiveData<>();
    public MutableLiveData<String> ageNewStudent = new MutableLiveData<>();
    private StudentDatabase studentDatabase;
    private MutableLiveData<List<Student>> listStudents = new MutableLiveData<List<Student>>();
    Context mContext;
    public Student newStudent = new Student();

    public AddViewModel(Context context) {
        this.mContext = context;
    }

    public MutableLiveData<String> getNameNewStudent() {
        if (nameNewStudent.hasActiveObservers()) {
            newStudent.setName(nameNewStudent.getValue());
        }
        return nameNewStudent;
    }
    public MutableLiveData<String> getAgeNewStudent() {
        if (ageNewStudent.hasActiveObservers()) {
            if (ageNewStudent.getValue() != null) {
                newStudent.setAge(Integer.parseInt(ageNewStudent.getValue()));
            }
        }
        return ageNewStudent;
    }
    public void updateStudents() {
        insertStudent();
    }

    private void insertStudent() {

        if (newStudent.getName() != null && newStudent.getAge() > 0) {
            studentDatabase = StudentDatabase.getInstance(mContext);
            StudentDao studentDao = studentDatabase.studentDao();
            StudentDatabase.mExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    studentDao.insertAll(newStudent);
                    Log.i("INSERT DATA", "DONE");
                }
            });
        } else {
            Toast.makeText(mContext, "Nhap lai thong tin", Toast.LENGTH_SHORT).show();
        }

    }


}

package com.example.viewModel;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.database_dao.Student;
import com.example.database_dao.StudentDao;
import com.example.database_dao.StudentDatabase;
import com.example.view.AddStudent;
import com.example.view.ListStudents;

import java.util.List;

public class MyViewModel extends ViewModel {
    Context mContext;
   private StudentDatabase studentDatabase;
    private MutableLiveData<List<Student>> listStudents;
    public LiveData<List<Student>> getUsers() {
        if (listStudents == null) {
            listStudents = new MutableLiveData<List<Student>>();
            loadStudents();
        }
        return listStudents;
    }

    private void loadStudents() {
        // query data
        studentDatabase = StudentDatabase.getInstance(mContext);
        StudentDao studentDao = studentDatabase.studentDao();
        StudentDatabase.mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                listStudents = (MutableLiveData<List<Student>>) studentDao.getAll();
            }
        });
        StudentDatabase.mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                studentDao.insertAll();
            }
        });
        // Do an asynchronous operation to fetch users.
    }

//public MyViewModel(Context context){
//    mContext=context;
//}
@BindingAdapter("bindName:text")
    public static void setName(TextView textView,String name){
        if (name == null) {
            textView.setText(null);
        } else {
            textView.setText(name);
            Log.i("TEXT", "" + name);
        }
    }
    @BindingAdapter("bindAge:text")
    public static void setAge(TextView textView, String age) {
        if (age == null) {
            textView.setText(null);
        } else {
            textView.setText(age);
        }
    }
    // 2 ways dataBinding




//    @BindingAdapter("android:onClick")
//   public static void clickItem(){
//// chuyển hướng tơi fragment addStudent;
//
//    }
}

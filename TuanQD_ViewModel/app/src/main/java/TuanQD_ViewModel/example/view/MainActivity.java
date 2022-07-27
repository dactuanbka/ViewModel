package TuanQD_ViewModel.example.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.baseproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import TuanQD_ViewModel.example.database_dao.Student;
import TuanQD_ViewModel.example.database_dao.StudentDao;
import TuanQD_ViewModel.example.database_dao.StudentDatabase;

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
        studentDatabase = StudentDatabase.getInstance(getApplicationContext());
        StudentDao studentDao = studentDatabase.studentDao();
        StudentDatabase.mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                listStudent = studentDao.getAll();
            }
        });
        StudentDatabase.mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                studentDao.insertAll(student);
            }
        });
    }
}
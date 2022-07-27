package TuanQD_ViewModel.example.database_dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import TuanQD_ViewModel.example.view.MainActivity;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    public static Executor mExecutorService=Executors.newFixedThreadPool(3);

    public abstract StudentDao studentDao();
    private static StudentDatabase stuDataInstance;
    private StudentDatabase() {};

    public static StudentDatabase getInstance(Context context) {
        if (stuDataInstance == null) {
            stuDataInstance = Room.databaseBuilder(context,
                    StudentDatabase.class, "students").build();
        }
        return stuDataInstance;
    }
}

package com.example.database_dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    public static Executor mExecutorService=Executors.newFixedThreadPool(3);

    public abstract StudentDao studentDao();
    private static StudentDatabase stuDataInstance;
    public StudentDatabase() {};

    public static StudentDatabase getInstance(Context context) {
        if (stuDataInstance == null) {
            synchronized (StudentDatabase.class){
            stuDataInstance = Room.databaseBuilder(context,
                    StudentDatabase.class, "students").build();
            }
        }
        return stuDataInstance;
    }
}

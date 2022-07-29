package com.example.database_dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM students")
    LiveData<List<Student>> getAll();

    @Insert
    void insertAll(Student student);

    @Delete
    void delete(Student student);
}

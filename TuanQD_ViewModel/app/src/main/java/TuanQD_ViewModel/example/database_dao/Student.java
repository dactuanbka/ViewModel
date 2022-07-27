package TuanQD_ViewModel.example.database_dao;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students", primaryKeys = {"name", "age"})
public class Student {
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(  name = "age")
    @NonNull
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

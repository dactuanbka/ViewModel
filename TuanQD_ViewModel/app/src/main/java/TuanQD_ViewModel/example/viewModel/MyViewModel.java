package TuanQD_ViewModel.example.viewModel;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.baseproject.R;

import TuanQD_ViewModel.example.database_dao.Student;
import TuanQD_ViewModel.example.view.AddStudent;
import TuanQD_ViewModel.example.view.ListStudents;
import TuanQD_ViewModel.example.view.StudentDetail;

public class MyViewModel extends ViewModel {
    Context mContext;
    AddStudent addStudent= new AddStudent();
   static ListStudents listStudents= new ListStudents();
public MyViewModel(Context context){
    mContext=context;
}
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
    public static void setPrice(TextView textView, String age) {
        if (age == null) {
            textView.setText(null);
        } else {
            textView.setText(age);
        }
    }
    @BindingAdapter("android:onClick")
   public static void clickItem(){
// chuyển hướng tơi fragment addStudent;

    }
}

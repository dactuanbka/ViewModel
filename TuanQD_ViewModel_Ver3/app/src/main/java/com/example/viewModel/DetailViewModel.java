package com.example.viewModel;

import android.util.Log;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    @BindingAdapter("bindName:text")
    public static void setName(TextView textView, String name){
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
}

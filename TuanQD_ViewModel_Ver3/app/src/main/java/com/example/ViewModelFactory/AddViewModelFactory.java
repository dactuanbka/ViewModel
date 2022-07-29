package com.example.ViewModelFactory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewModel.AddViewModel;
import com.example.viewModel.ListStudentViewModel;

public class AddViewModelFactory implements ViewModelProvider.Factory {
    Context context;
    public AddViewModelFactory(Context context){
        this.context =context;
    }
    @NonNull
    @Override
    public <T extends ViewModel>T create(@NonNull Class<T> modelClass){
        if(modelClass== AddViewModel.class){
            return (T) new AddViewModel(context);
        }
        return null;
    }
}

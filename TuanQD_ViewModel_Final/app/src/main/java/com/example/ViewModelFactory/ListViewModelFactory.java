package com.example.ViewModelFactory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewModel.ListStudentViewModel;

public class ListViewModelFactory implements ViewModelProvider.Factory {
    Context context;

    public ListViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ListStudentViewModel.class) {
            return (T) new ListStudentViewModel(context);
        }
        return null;
    }
}

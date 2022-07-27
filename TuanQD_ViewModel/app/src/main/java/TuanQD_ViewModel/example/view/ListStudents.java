package TuanQD_ViewModel.example.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;
import com.example.baseproject.databinding.FragmentListStudentsBinding;

import TuanQD_ViewModel.example.viewModel.MyViewModel;

public class ListStudents extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListStudents() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListStudents newInstance(String param1, String param2) {
        ListStudents fragment = new ListStudents();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentListStudentsBinding fragmentListStudentBinding= FragmentListStudentsBinding.inflate(inflater);
        MyViewModel myViewModel= new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        fragmentListStudentBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController= Navigation.findNavController(fragmentListStudentBinding.getRoot());
                navController.navigate(R.id.action_listStudents_to_addStudent);
            }
        });
        return fragmentListStudentBinding.getRoot();
    }
}
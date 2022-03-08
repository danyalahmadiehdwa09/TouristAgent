package com.example.touristagent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }

    public void savetoDatabase(TextView name, TextView email, TextView pass) {



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Button btn = (Button) view.findViewById(R.id.btn_register);
        TextView email = view.findViewById(R.id.et_email);
        TextView pass = view.findViewById(R.id.et_firstname);
        TextView username = view.findViewById(R.id.et_email);
        TextView pass2 = view.findViewById(R.id.et_repassword);
        TextView error = view.findViewById(R.id.et_error);
        btn.setOnClickListener(v -> {
            if (pass2 != pass)
            { error.setText("passwords are not matching"); }
            else {
                savetoDatabase(username,email,pass);
            }
    });
                return view;

    }}

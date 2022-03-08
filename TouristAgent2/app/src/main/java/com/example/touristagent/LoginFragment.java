package com.example.touristagent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        Button btn = (Button) view.findViewById(R.id.btn_register);
        TextView username = view.findViewById(R.id.et_name);
        TextView pass = view.findViewById(R.id.et_password);
        TextView error = view.findViewById(R.id.et_error);
        btn.setOnClickListener(v -> {
            OkHttpClient client = new OkHttpClient();

            RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("username", String.valueOf(username))
                        .addFormDataPart("password", String.valueOf(pass))
                        .build();

                Request request = new Request.Builder()
                        .url("http:127.0.0.1:5000/")
                        .post(requestBody)
                        .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) try {
                    throw new IOException("Unexpected code " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        return view;
    }

}
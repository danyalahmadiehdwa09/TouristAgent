package com.example.touristagent;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ViewPager2 myViewPager2;
    ViewPagerFragmentAdapter myAdapter;
    private ArrayList<Fragment> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager2 = findViewById(R.id.view_pager);

        // add Fragments in your ViewPagerFragmentAdapter class
        arrayList.add(new LoginFragment());
        arrayList.add(new RegisterFragment());

        myAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        // set Orientation in your ViewPager2
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        myViewPager2.setAdapter(myAdapter);

        myViewPager2.setPageTransformer(new MarginPageTransformer(1500));


    }
}
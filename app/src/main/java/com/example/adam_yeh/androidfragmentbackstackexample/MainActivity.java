package com.example.adam_yeh.androidfragmentbackstackexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        super.setTitle("dev2qa.com - Fragment Back Stack Example.");

        String fragmentName = "Fragment One";

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_back_stack_frame_layout, new FragmentOne(), fragmentName);
        transaction.addToBackStack(null);
        transaction.commit();

        FragmentUtil.printActivityFragmentList(fragmentManager);
    }

}

package com.example.ch_e00587.diabetes2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView=(TextView) findViewById(R.id.tv);
        textView.setText("Welcome to Diabetes Advisor");


    }

}

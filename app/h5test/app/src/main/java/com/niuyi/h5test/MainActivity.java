package com.niuyi.h5test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doTest(View view){
        Intent in = new Intent();
        in.setClass(this, WebActivity.class);
        startActivity(in);
    }
}

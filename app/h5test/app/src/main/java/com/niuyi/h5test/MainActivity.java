package com.niuyi.h5test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://192.168.31.208:8000/";
    private EditText mET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mET = (EditText)findViewById(R.id.id_et);

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String path = defaultSharedPreferences.getString("path", URL);

        mET.setText(path);
    }

    public void doTest(View view){
        Intent in = new Intent();
        in.setClass(this, WebActivity.class);
        in.putExtra("path", mET.getText().toString());
        startActivity(in);

        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString("path", mET.getText().toString());

        edit.apply();
    }
}

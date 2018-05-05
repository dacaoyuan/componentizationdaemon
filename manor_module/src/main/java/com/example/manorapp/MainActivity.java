package com.example.manorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.manorapp.application.ManorApplication;


@Route(path = "/manor_/MainActivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";


    private Button mManorButton;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manor_activity_main);


        //LogUtil.println(TAG, " 庄园模块打印");


        ManorApplication instance = ManorApplication.getInstance();

        Toast.makeText(instance.getApplication(), "ddd", Toast.LENGTH_SHORT).show();

        mManorButton = (Button) findViewById(R.id.manor_button);
        button2 = (Button) findViewById(R.id.button2);
        mManorButton.setOnClickListener(this);
        button2.setOnClickListener(this);


       /* mManorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });*/


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.manor_button) {
             startActivity(new Intent(MainActivity.this, AboutActivity.class));
        } else if (id == R.id.button2) {
            Log.i(TAG, "onClick: ");
        }

    }


}

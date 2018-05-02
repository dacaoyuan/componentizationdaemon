package com.example.componentizationdaemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.utils.DensityUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = DensityUtils.dp2px(this, 20f);
        Log.i(TAG, "onCreate: i=" + i);

        findViewById(R.id.manor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ddd");
                ARouter.getInstance().build("/manor_/MainActivity").navigation();


            }
        });


    }
}

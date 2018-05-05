package com.example.componentizationdaemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.utils.DensityUtils;
import com.example.mylibrary.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.manor)
    Button mManor;
    @BindView(R.id.backstage)
    Button mBackstage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        int i = DensityUtils.dp2px(this, 20f);
        Log.i(TAG, "onCreate: i=" + i);


        mManor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.println(TAG, " manor");
                ARouter.getInstance().build("/manor_/MainActivity").navigation();


            }
        });

        findViewById(R.id.backstage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.println(TAG, " backstage");
                ARouter.getInstance().build("/backstage_/MainActivity").navigation();

            }
        });


    }
}

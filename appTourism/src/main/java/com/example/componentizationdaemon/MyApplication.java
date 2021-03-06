package com.example.componentizationdaemon;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mylibrary.utils.LogUtil;

/**
 * Created by yuanpk on 2018/5/2  9:52
 * <p>
 * Description:TODO
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    public static Context mContext = null;

    private static MyApplication INSTANCE = null;

    public static MyApplication getInstance() {
        return INSTANCE;
    }

   /* @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();

        if (true) {  //isDebug()  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        INSTANCE = this;
        mContext = getApplicationContext();
        LogUtil.initXlog(true);//初始化日志打印，true：打印；false：不打印


    }
}

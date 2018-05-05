package com.example.manorapp.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.application.ApplicationService;
import com.example.mylibrary.utils.LogUtil;

/**
 * Created by yuanpk on 2018/5/2  14:38
 * <p>
 * Description:TODO
 */

public class ManorDebugApplication extends Application implements ApplicationService {

    private static final String TAG = "ManorDebugApplication";
    private static ManorDebugApplication INSTANCE = null;

    private static Context mContext = null;

    public static ManorDebugApplication getInstance() {
        Log.d(TAG, "get ShopDebugApplication");
        return INSTANCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
        mContext=this;
    }


    @Override
    public void loadModuleApplicationService() {

    }

    @Override
    public Application getApplication() {
        return getInstance();
    }



    @Override
    public void onCreate() {
        super.onCreate();

        if (true) {  //isDebug()  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        LogUtil.initXlog(true);//初始化日志打印，true：打印；false：不打印


    }
}

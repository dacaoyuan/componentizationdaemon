package com.example.manorapp.application;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.application.ApplicationService;
import com.example.manorapp.BuildConfig;
import com.example.mylibrary.utils.LogUtil;

/**
 * Created by yuanpk on 2018/5/2  14:38
 * <p>
 * Description:TODO
 */

public class ManorApplication implements ApplicationService {
    private static final String TAG = "ManorApplication";

    private ManorApplication() {
    }

    private static class ManorApplicationHolder {
        private static final ManorApplication INSTANCE = new ManorApplication();
    }

    public static final ManorApplication getInstance() {
        return ManorApplicationHolder.INSTANCE;
    }

    @Override
    public void loadModuleApplicationService() {
        if (BuildConfig.isDebug) {
            ManorDebugApplication.getInstance().loadModuleApplicationService();
        } else {
            ManorReleaseApplication.getInstance().loadModuleApplicationService();
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.isDebug) {
            return ManorDebugApplication.getInstance().getApplication();
        } else {
            return ManorReleaseApplication.getInstance().getApplication();
        }
    }
}

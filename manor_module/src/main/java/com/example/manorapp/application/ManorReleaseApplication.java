package com.example.manorapp.application;

import android.app.Application;
import android.util.Log;

import com.example.application.ApplicationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yuanpk on 2018/5/2  14:38
 * <p>
 * Description:TODO
 */

public class ManorReleaseApplication implements ApplicationService {

    private static final String TAG = "ManorReleaseApplication";
    private static Application application;

    private ManorReleaseApplication() {
    }

    private static class ManorReleaseApplicationHolder {
        private static final ManorReleaseApplication INSTANCE = new ManorReleaseApplication();
    }

    public static final ManorReleaseApplication getInstance() {
        return ManorReleaseApplicationHolder.INSTANCE;
    }


    @Override
    public void loadModuleApplicationService() {

    }

    @Override
    public Application getApplication() {
        Log.d(TAG, "get ShopReleaseApplication");
        if (null == application) {
            try {
                Class clazz = Class.forName("com.example.componentizationdaemon.MyApplication");
                Method method = clazz.getMethod("getInstance");
                application = (Application) method.invoke(null);
                return application;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return application;
    }
}

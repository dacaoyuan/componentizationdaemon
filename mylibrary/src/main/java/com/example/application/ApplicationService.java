package com.example.application;

import android.app.Application;

/**
 * Created by yuanpk on 2018/5/2  15:40
 * <p>
 * Description:TODO
 */

public interface ApplicationService {
    void loadModuleApplicationService(); //初始化一些第三方SDK服务
    Application getApplication(); //获取主APP的Application或者module在debug时自己的application
}

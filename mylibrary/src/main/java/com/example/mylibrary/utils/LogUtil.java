package com.example.mylibrary.utils;


import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.Logger;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.flattener.Flattener;
import com.elvishew.xlog.printer.AndroidPrinter;
import com.elvishew.xlog.printer.Printer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogUtil {

    public static void println(String key, String value) {
        Logger logger = XLog.tag("XLog")
                //  .st(3)   // 允许打印深度为3的调用栈信息
                .build();

        logger.i(key + " " + value);
    }


    public static void i(String key, String value) {
        Logger logger = XLog.tag("XLog")
                //  .st(3)   // 允许打印深度为3的调用栈信息
                .build();

        logger.i(key + " " + value);
    }

    public static void d(String key, String value) {
        Logger logger = XLog.tag("XLog")
                //  .st(3)   // 允许打印深度为3的调用栈信息
                .build();

        logger.d(key + " " + value);
    }

    public static void e(String key, String value) {
        Logger logger = XLog.tag("XLog")
                //  .st(3)   // 允许打印深度为3的调用栈信息
                .build();

        logger.e(key + " " + value);
    }


    public static void initXlog(boolean isPrint) {
        // FIXME: 2017/6/16 正式发布，把 日志打印屏蔽掉 false
        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(isPrint ? LogLevel.ALL : LogLevel.NONE)
                //.tag("MY_TAG")                                         // 指定 TAG，默认为 "X-LOG"
                //.t()                                                   // 允许打印线程信息，默认禁止
                // .st(2)                                                 // 允许打印深度为2的调用栈信息，默认禁止
                // .b()                                                   // 允许打印日志边框，默认禁止
                // .jsonFormatter(new MyJsonFormatter())                  // 指定 JSON 格式化器，默认为 DefaultJsonFormatter
                // .xmlFormatter(new MyXmlFormatter())                    // 指定 XML 格式化器，默认为 DefaultXmlFormatter
                //  .throwableFormatter(new MyThrowableFormatter())        // 指定可抛出异常格式化器，默认为 DefaultThrowableFormatter
                //  .threadFormatter(new MyThreadFormatter())              // 指定线程信息格式化器，默认为 DefaultThreadFormatter
                //  .stackTraceFormatter(new MyStackTraceFormatter())      // 指定调用栈信息格式化器，默认为 DefaultStackTraceFormatter
                //  .borderFormatter(new MyBoardFormatter())               // 指定边框格式化器，默认为 DefaultBorderFormatter
                // .addInterceptor(new MyInterceptor())                   // 添加一个日志拦截器
                .build();

        Printer androidPrinter = new AndroidPrinter();             // 通过 android.util.Log 打印日志的打印器
        //Printer consolePrinter = new ConsolePrinter();             // 通过 System.out 打印日志到控制台的打印器
        /*Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
                .Builder(Environment.getExternalStorageDirectory().getPath() + "/XLog")  // 指定保存日志文件的路径
                .fileNameGenerator(new DateFileNameGenerator())        // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")
                //.fileNameGenerator(new LevelFileNameGenerator())
                .backupStrategy(new NeverBackupStrategy())            // 指定日志文件备份策略，默认为 FileSizeBackupStrategy(1024 * 1024)
                //.backupStrategy(new FileSizeBackupStrategy(10 * 1024 * 1024))//将文件大小指定为 9M=1024B*1024KB * 9=9437184B
                .logFlattener(new MyLogFlattener())                  // 指定日志平铺器，默认为 DefaultFlattener
                .build();*/

        XLog.init(config, androidPrinter);
    }


    private static class MyLogFlattener implements Flattener {

        private ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {

            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            }
        };

        @Override
        public CharSequence flatten(int logLevel, String tag, String message) {
            return formatter.get().format(new Date())
                    + '|' + LogLevel.getShortLevelName(logLevel)
                    + '|' + tag
                    + '|' + message;
        }
    }

}

package com.example.FiveReel.utils;

import android.util.Log;

public class LogUtils {
    public static final String LOG_TAG = "FiveReel";
    public static final boolean IS_SHOW_LOG = true;

    public static void d(String msg) {
        if (IS_SHOW_LOG) {
            Log.d(LOG_TAG, msg);
        }
    }

    public static void d(String msg, Throwable tr) {
        if (IS_SHOW_LOG) {
            Log.d(LOG_TAG, msg, tr);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (IS_SHOW_LOG) {
            Log.e(LOG_TAG, msg, tr);
        }
    }
}
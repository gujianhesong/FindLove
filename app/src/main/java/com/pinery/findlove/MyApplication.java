package com.pinery.findlove;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Application的代理类
 *
 * Created by Administrator on 2017/4/26 0026.
 */

public class MyApplication extends Application {

  private static Application sContext;

  public static Handler mHandler = new Handler(Looper.getMainLooper());

  @Override public void onCreate() {
    super.onCreate();

    sContext = this;
  }

  public static Context getInstance() {
    return sContext;
  }
}

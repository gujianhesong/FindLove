package com.pinery.findlove.util;

import android.util.Log;

/**
 * Created by gujian on 2018-08-05.
 */

public class TimeUtil {

  private static long lastTime;

  public static void printTime(){

    long time = System.currentTimeMillis();
    long delta = time - lastTime;

    Log.i("TimeUtil", "耗时：" + delta);
  }

  public static void printTimeWithUpdate(){

    long time = System.currentTimeMillis();
    long delta = time - lastTime;
    lastTime = time;

    Log.i("TimeUtil", "耗时：" + delta);
  }

  public static void updateTime(){
    Log.i("TimeUtil", "更新时间");
    lastTime = System.currentTimeMillis();
  }


}

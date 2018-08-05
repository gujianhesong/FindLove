package com.pinery.findlove.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.pinery.findlove.MyApplication;

public class ScreenUtil {
	private static Point sPoint;

	/**
	 * 获取屏幕尺寸，包含状态栏的高度
	 * @return
     */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static Point getScreenSize() {

		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager
        windowManager = (WindowManager) MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
		final int width = displayMetrics.widthPixels;
		final int height = displayMetrics.heightPixels;
		return new Point(width, height);
	}
	
	/** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dp2px(float dpValue) {  
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dp(float pxValue) {  
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 *
	 * @param spValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(float spValue) {
		final float fontScale = MyApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 *
	 * @param pxValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(float pxValue) {
		final float fontScale = MyApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
     * 是否横屏
     * @return
     */
    public static boolean checkIsLandScape(){
		Configuration configuration = MyApplication.getInstance().getResources().getConfiguration();
		return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE;
	}

	/**
	 * 获取当前横竖屏
	 * @return
     */
	public static int getCurrentOrientation(){
		Configuration configuration = MyApplication.getInstance().getResources().getConfiguration();
		return configuration.orientation;
	}

	/**
	 * 状态栏高度
	 * @return
     */
	public static int getStatusBarHeight() {
		int result = 0;
		int resourceId = MyApplication.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = MyApplication.getInstance().getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	public static int getNavigationBarHeight() {
		Resources resources = MyApplication.getInstance().getResources();
		int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
		//获取NavigationBar的高度
		int height = resources.getDimensionPixelSize(resourceId);
		return height;
	}

	public static boolean checkDeviceHasNavigationBar(Context activity) {

		//通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
		boolean hasMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
		boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
		if (!hasMenuKey && !hasBackKey) {
			// 做任何你需要做的,这个设备有一个导航栏
			return true;
		}
		return false;
	}
}

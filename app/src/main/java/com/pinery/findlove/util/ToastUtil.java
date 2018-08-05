package com.pinery.findlove.util;

import android.widget.Toast;
import com.pinery.findlove.MyApplication;

public class ToastUtil {

	/**
	 * 系统Toast
	 * @param text
     */
	public static void showToast(final String text){
		MyApplication.mHandler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
			}
		});
	}

	/**
	 * 系统Toast
	 * @param textId
     */
	public static void showToast(final int textId){
		MyApplication.mHandler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MyApplication.getInstance(), MyApplication.getInstance().getString(textId), Toast.LENGTH_SHORT).show();
			}
		});
	}

}

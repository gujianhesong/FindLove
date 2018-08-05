package com.pinery.findlove.common.loading;

import android.app.Activity;
import android.content.Context;
import com.pinery.findlove.R;

public class LoadingView{

    private Context mContext;
    private LoadingDialog mLoadingDialog;
    private int taskCount;

    public LoadingView(Activity activity) {
        mContext = activity;
        mLoadingDialog = new LoadingDialog(mContext, R.style.Loading_Dialog);
        taskCount = 0;
    }

    public void showLoading(boolean cancelable) {
        if (mLoadingDialog != null) {
            if (!mLoadingDialog.isShowing()) {
                mLoadingDialog.setCancelable(cancelable);
                mLoadingDialog.show();
            }
            taskCount++;
        }
    }

    public void hideLoading() {
        if (mLoadingDialog != null) {
            taskCount--;
            if (mLoadingDialog.isShowing() && taskCount <= 0) {
                mLoadingDialog.dismiss();
            }
        }
    }

    public boolean isShowing() {
        return mLoadingDialog != null && mLoadingDialog.isShowing();
    }

}

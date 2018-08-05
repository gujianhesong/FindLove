package com.pinery.findlove.base;

import android.support.v7.app.AppCompatActivity;
import com.pinery.findlove.common.loading.LoadingView;

/**
 * Created by gujian on 2018-08-05.
 */

public class BaseActivity extends AppCompatActivity {

  private LoadingView mLoadingView;


  public void showLoadingDialog(boolean cancelable) {
    createLoadingView();
    if (!isFinishing() ) {
      mLoadingView.showLoading(cancelable);
    }
  }

  public void hideLoadingDialog() {
    if (!isFinishing() && mLoadingView != null) {
      mLoadingView.hideLoading();
    }
  }

  private void createLoadingView(){
    if(mLoadingView == null){
      mLoadingView = new LoadingView(this);
    }
  }

}

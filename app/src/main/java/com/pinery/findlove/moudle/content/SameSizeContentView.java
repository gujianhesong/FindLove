package com.pinery.findlove.moudle.content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.ui.adapter.SourceAdapter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public class SameSizeContentView extends BaseContentView {

  private ArrayList<OCResultBean.Source> mDatas;

  private OCResultBean mOCResultBean;

  public SameSizeContentView(Context context) {
    super(context);

    mRecyclerView.setPullRefreshEnabled(false);
    mRecyclerView.setLoadMoreEnabled(false);

    initData();
  }

  private void initData() {
  }

  @Override protected RecyclerView.Adapter generateAdapter() {
    mDatas = new ArrayList<>();
    return new SourceAdapter(mContext, mDatas);
  }

  @Override protected void onLoadMore() {

  }

  @Override protected void onRefresh() {

  }

  @Override public View getView() {
    return mView;
  }

  @Override public void fillData(OCResultBean bean) {
    mOCResultBean = bean;

    mDatas.clear();

    if (mOCResultBean != null && mOCResultBean.sameSizeList != null) {
      mDatas.addAll(mOCResultBean.sameSizeList);
    }
    notifyCompleteRefresh(0);
  }
}
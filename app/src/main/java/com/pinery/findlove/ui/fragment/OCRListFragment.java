package com.pinery.findlove.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.pinery.findlove.R;
import com.pinery.findlove.base.BaseFragment;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.moudle.content.IContent;
import com.pinery.findlove.moudle.content.OCRListContent;

public class OCRListFragment extends BaseFragment implements IContent {

  private OCRListContent contentView;

  public OCRListFragment() {
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_base;
  }

  @Override protected void initViews(View view, Bundle savedInstanceState) {
    contentView = new OCRListContent(view.getContext());

    RelativeLayout root = (RelativeLayout) view;
    root.removeAllViews();
    root.addView(contentView.getView());
  }

  @Override public void fillData(OCResultBean bean) {

  }

}

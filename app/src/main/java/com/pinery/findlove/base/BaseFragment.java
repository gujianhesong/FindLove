package com.pinery.findlove.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

  protected View rootView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    if (rootView == null) {
      rootView = inflater.inflate(getLayoutId(), container, false);
    }

    ViewGroup parent = (ViewGroup) rootView.getParent();
    if (parent != null) {
      parent.removeView(rootView);
    }

    initViews(rootView, savedInstanceState);

    return rootView;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
  }

  public BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  protected abstract int getLayoutId();

  protected abstract void initViews(View view, Bundle savedInstanceState);

}

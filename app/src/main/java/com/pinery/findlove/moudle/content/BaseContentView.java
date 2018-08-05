package com.pinery.findlove.moudle.content;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.pinery.findlove.R;
import com.pinery.findlove.ui.widget.RecycleViewDivider;
import com.pinery.findlove.util.ToastUtil;
import com.pinery.findlove.util.ViewUtil;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public abstract class BaseContentView implements IContent {

  protected LRecyclerView mRecyclerView;
  protected ProgressBar mProgressBar;

  protected RecyclerView.Adapter mAdapter;
  protected LRecyclerViewAdapter mLRecyclerViewAdapter;

  private LinearLayoutManager mLinearLayoutManager;
  protected RecycleViewDivider recycleViewDivider;

  protected View mView;

  protected Context mContext;


  public BaseContentView(Context context) {

    mContext = context;

    initViews();

  }

  public void onDestroyView() {
  }

  protected void initViews() {

    mView = LayoutInflater.from(mContext).inflate(R.layout.layout_reader_list, null);

    mRecyclerView = ViewUtil.findViewById(mView, R.id.swipe_target);
    mProgressBar = ViewUtil.findViewById(mView, R.id.progressBar);

    mLinearLayoutManager = new LinearLayoutManager(mContext);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    mRecyclerView.setHasFixedSize(true);

    mAdapter = generateAdapter();
    mLRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
    mRecyclerView.setAdapter(mLRecyclerViewAdapter);
    recycleViewDivider = new RecycleViewDivider(mContext);
    mRecyclerView.addItemDecoration(recycleViewDivider);

    mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
      @Override public void onRefresh() {
        BaseContentView.this.onRefresh();
      }
    });

    mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
      @Override public void onLoadMore() {
        BaseContentView.this.onLoadMore();
      }
    });


  }

  public void notifyCompleteRefresh(int refreshCount) {
    mRecyclerView.refreshComplete(refreshCount);
    mLRecyclerViewAdapter.notifyDataSetChanged();
  }

  public void showErrorMessage(boolean isRefresh, String message) {
    if(mContext instanceof Activity){
      ToastUtil.showToast(message);
    }

    if(isRefresh){
      mRecyclerView.refreshComplete(0);
    }else{
      mRecyclerView.refreshComplete(0);
      mRecyclerView.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
        @Override
        public void reload() {
          onLoadMore();
        }
      });
    }
  }

  protected abstract RecyclerView.Adapter generateAdapter();

  protected abstract void onLoadMore();

  protected abstract void onRefresh();

}

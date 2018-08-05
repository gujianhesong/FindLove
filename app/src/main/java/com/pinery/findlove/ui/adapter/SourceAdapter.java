package com.pinery.findlove.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.pinery.findlove.R;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.util.HtmlUtil;
import com.pinery.findlove.util.ViewUtil;
import java.util.ArrayList;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.ViewHolder> {
  private ArrayList<OCResultBean.Source> mList;
  private Context mContext;

  public SourceAdapter(Context context, ArrayList<OCResultBean.Source> infoList) {
    this.mList = infoList;
    this.mContext = context;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false));
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {

    final OCResultBean.Source itemInfo = mList.get(position);

    holder.tvTitle.setText(itemInfo.fromPageTitle);
    holder.tvSource.setText(itemInfo.textHost);
    //holder.tvTime.setText(itemInfo.getPtime());

    Glide.with(mContext).load(itemInfo.objURL).into(holder.ivImage);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        //打开内容页面
        HtmlUtil.openUrl(mContext, itemInfo.fromURL);
      }
    });
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    ImageView ivImage;
    TextView tvTitle;
    TextView tvSource;

    ViewHolder(View itemView) {
      super(itemView);

      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
      tvTitle = ViewUtil.findViewById(itemView, R.id.tv_title);
      tvSource = ViewUtil.findViewById(itemView, R.id.tv_source);
    }
  }
}

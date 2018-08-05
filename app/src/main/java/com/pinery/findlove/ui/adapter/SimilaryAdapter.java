package com.pinery.findlove.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.pinery.findlove.R;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.util.HtmlUtil;
import com.pinery.findlove.util.ViewUtil;
import java.util.ArrayList;

public class SimilaryAdapter extends RecyclerView.Adapter<SimilaryAdapter.ViewHolder> {
  private ArrayList<OCResultBean.Similary> mList;
  private Context mContext;

  public SimilaryAdapter(Context context, ArrayList<OCResultBean.Similary> infoList) {
    this.mList = infoList;
    this.mContext = context;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.similary_item, parent, false));
  }

  @Override public void onBindViewHolder(final ViewHolder holder, int position) {

    final OCResultBean.Similary itemInfo = mList.get(position);

    //Glide.with(mContext).load(itemInfo.getThumbnailURL()).into(holder.ivImage);
    Glide.with(mContext).load(itemInfo.getObjURL()).into(holder.ivImage);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //打开内容页面
        HtmlUtil.openUrl(mContext, itemInfo.getFromURL());
      }
    });
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    ImageView ivImage;

    ViewHolder(View itemView) {
      super(itemView);

      ivImage = ViewUtil.findViewById(itemView, R.id.iv_image);
    }
  }
}

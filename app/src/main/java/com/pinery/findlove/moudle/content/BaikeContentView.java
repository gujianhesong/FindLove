package com.pinery.findlove.moudle.content;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.pinery.findlove.R;
import com.pinery.findlove.bean.BaikeBean;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.bean.PlantInfo;
import com.pinery.findlove.bean.SimpleOCResultBean;
import com.pinery.findlove.util.HtmlUtil;
import com.pinery.findlove.util.ViewUtil;

/**
 * Created by gujian on 2018-08-05.
 */

public class BaikeContentView implements IContent{

  private Context mContext;
  private View mRootView;
  private TextView tvSimpleInfo;

  public BaikeContentView(Context context){
    mContext = context;

    mRootView = LayoutInflater.from(mContext).inflate(R.layout.layout_baike, null);
    tvSimpleInfo = ViewUtil.findViewById(mRootView, R.id.tv_simple_info);
  }

  @Override public View getView() {
    return mRootView;
  }

  @Override public void fillData(OCResultBean ocResultBean){
    if(ocResultBean == null){
      tvSimpleInfo.setText("");
      return;
    }
    SimpleOCResultBean bean = ocResultBean.simpleOCResultBean;

    String guessWord = bean.guessWord != null ? bean.guessWord : bean.multitags;

    String msg = new StringBuilder()
        .append("关键词：").append(guessWord)
        .append("\n图片地址：").append(bean.queryImageUrl)
        .append("\n百科地址：").append(bean.baikeUrl)
        .toString();


    if(bean.baikeBean != null){
      final BaikeBean baikeBean = bean.baikeBean;
      msg = new StringBuilder()
          .append("百度百科：")
          .append("<a href=\"").append(baikeBean.getBaikeUrl()).append("\">")
          .append(baikeBean.getBaikeName())
          .append("</a><br/>")
          .append(baikeBean.getBaikeText())
          .toString();

      if (Build.VERSION.SDK_INT >= 24)
        tvSimpleInfo.setText(Html.fromHtml(msg,Html.FROM_HTML_MODE_COMPACT));
      else
        tvSimpleInfo.setText(Html.fromHtml(msg));

      HtmlUtil.textHtmlClick(tvSimpleInfo, new HtmlUtil.OnURLSpanClickListener() {
        @Override public void onUrlClick(String url) {
          HtmlUtil.openUrl(mContext, url);
        }
      });
      return;
    }

    if(bean.plantInfo != null){
      final PlantInfo info = bean.plantInfo;
      StringBuilder sb = new StringBuilder();
      sb.append("百度百科：");

      if(info.terms != null && info.terms.size() > 0){
        for(PlantInfo.BaikeInfo item : info.terms){
          if(item != null && item.baike != null){
            sb.append("<br/><a href=\"").append(item.baike.url).append("\">")
                .append(item.name)
                .append("</a><br/>")
                .append(item.baike.description);
          }
        }

      }

      msg = sb.toString();

      if (Build.VERSION.SDK_INT >= 24)
        tvSimpleInfo.setText(Html.fromHtml(msg,Html.FROM_HTML_MODE_COMPACT));
      else
        tvSimpleInfo.setText(Html.fromHtml(msg));

      HtmlUtil.textHtmlClick(tvSimpleInfo, new HtmlUtil.OnURLSpanClickListener() {
        @Override public void onUrlClick(String url) {
          HtmlUtil.openUrl(mContext, url);
        }
      });
      return;
    }

    tvSimpleInfo.setText(msg);


  }

}

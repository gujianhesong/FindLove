package com.pinery.findlove.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gujian on 2018-08-04.
 */

public class HtmlUtil {

  public interface OnURLSpanClickListener{
    void onUrlClick(String url);
  }

  public static void openUrl(Context context, String url){
    Uri uri = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    context.startActivity(intent);
  }

  /**
   * 处理html文本超链接点击事件
   */
  public static void textHtmlClick(TextView tv, OnURLSpanClickListener listener) {
    tv.setMovementMethod(LinkMovementMethod.getInstance());
    CharSequence text = tv.getText();
    if (text instanceof Spannable) {
      int end = text.length();
      Spannable sp = (Spannable) text;
      URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
      SpannableStringBuilder style = new SpannableStringBuilder(text);
      style.clearSpans();// should clear old spans
      for (URLSpan url : urls) {
        MyURLSpan myURLSpan = new MyURLSpan(url.getURL(), tv.getContext(), listener);
        style.setSpan(myURLSpan, sp.getSpanStart(url), sp.getSpanEnd(url),
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
      }
      tv.setText(style);
    }
  }

  private static class MyURLSpan extends ClickableSpan {
    private String mUrl;
    private Context mContext;
    private OnURLSpanClickListener mListener;

    MyURLSpan(String url, Context context, OnURLSpanClickListener listener) {
      mContext = context;
      mUrl = url;
      mListener = listener;
    }

    @Override public void onClick(View widget) {
      if(mListener != null){
        mListener.onUrlClick(mUrl);
      }
    }
  }
}

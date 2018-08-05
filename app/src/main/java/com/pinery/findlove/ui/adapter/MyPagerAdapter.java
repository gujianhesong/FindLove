package com.pinery.findlove.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.findlove.moudle.content.IListContent;
import java.util.List;

/**
 * @author hesong
 * @e-mail hes1335@13322.com
 * @time 2018/2/26
 * @desc
 * @version: 3.1.2
 */

public class MyPagerAdapter extends PagerAdapter {
  protected IListContent listContent;

  public MyPagerAdapter(IListContent listContent){
    this.listContent = listContent;
  }

  @Override
  public boolean isViewFromObject(View arg0, Object arg1) {
    return arg0 == arg1;
  }

  @Override
  public int getCount() {
    return listContent.size();
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView(listContent.getContent(position).getView());
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    View view = listContent.getContent(position).getView();
    container.addView(view);

    return view;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    List<String> titleList = listContent.getTitleList();
    if(titleList != null && titleList.size() > position){
      return titleList.get(position);
    }
    return super.getPageTitle(position);
  }

}
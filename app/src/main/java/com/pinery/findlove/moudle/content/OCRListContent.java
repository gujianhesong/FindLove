package com.pinery.findlove.moudle.content;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import com.pinery.findlove.R;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.ui.adapter.MyPagerAdapter;
import com.pinery.findlove.ui.widget.ViewPagerTabs;
import com.pinery.findlove.util.ViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hesong
 * @e-mail hes1335@13322.com
 * @time 2018/2/26
 * @desc
 * @version: 3.1.2
 */

public class OCRListContent implements IListContent, IContent {

  HashMap<Integer, IContent> map = new HashMap<>();

  private Context mContext;
  private View mView;

  private ViewPagerTabs mViewPagerTabs;
  private ViewPager mViewPager;
  private MyPagerAdapter mPagerAdapter;

  private List<String> titleList;

  private OCResultBean mOCResultBean;

  public OCRListContent(Context context) {

    mContext = context;

    initViews();
  }

  protected void initViews() {
    mView = LayoutInflater.from(mContext).inflate(R.layout.layout_reader, null);

    mViewPager = ViewUtil.findViewById(mView, R.id.vp_reader);
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {
        map.get(position).fillData(mOCResultBean);
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
    mPagerAdapter = new MyPagerAdapter(this);
    mViewPager.setAdapter(mPagerAdapter);

    mViewPagerTabs = ViewUtil.findViewById(mView, R.id.vpTab_reader);
    mViewPagerTabs.setViewPager(mViewPager);
    mViewPager.addOnPageChangeListener(mViewPagerTabs);
  }

  public void onLocalChanged() {
    mViewPager.setAdapter(null);
    mViewPager.setAdapter(mPagerAdapter);
  }

  @Override public IContent getContent(int position) {
    IContent content = map.get(position);
    if (content == null) {
      content = createContent(position);
      if (content != null) {
        map.put(position, content);
      }
    }

    return content;
  }

  private IContent createContent(int position) {
    IContent content = null;

    switch (position) {
      case IContent.Type_Baike:

        BaikeContentView baikeContent = new BaikeContentView(mContext);
        baikeContent.fillData(mOCResultBean);
        content = baikeContent;

        break;
      case IContent.Type_Source:

        SourceContentView sourceContent = new SourceContentView(mContext);
        sourceContent.fillData(mOCResultBean);
        content = sourceContent;

        break;
      case IContent.Type_SameSize:

        SameSizeContentView sameSizeContent = new SameSizeContentView(mContext);
        sameSizeContent.fillData(mOCResultBean);
        content = sameSizeContent;

        break;
      case IContent.Type_Similary:

        SimilaryContentView similaryContent = new SimilaryContentView(mContext);
        similaryContent.fillData(mOCResultBean);
        content = similaryContent;

        break;
    }

    return content;
  }

  @Override public List<String> getTitleList() {
    if (titleList == null) {
      titleList = new ArrayList<>();
      titleList.add("百科");
      titleList.add("来源");
      titleList.add("相同尺寸");
      titleList.add("相关");
    }

    return titleList;
  }

  @Override public int size() {
    return getTitleList().size();
  }

  @Override public View getView() {
    return mView;
  }

  @Override public void fillData(OCResultBean bean) {
    mOCResultBean = bean;

    if (map.size() > 0) {
      for (IContent content : map.values()) {
        if (content != null) {
          content.fillData(bean);
        }
      }
    }
  }
}
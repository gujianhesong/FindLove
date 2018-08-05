package com.pinery.findlove.moudle.content;

import android.view.View;
import com.pinery.findlove.bean.OCResultBean;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public interface IContent {

    public static final int Type_Baike = 0;
    public static final int Type_Source = 1;
    public static final int Type_SameSize = 2;
    public static final int Type_Similary = 3;

    public View getView();

    public void fillData(OCResultBean bean);
}

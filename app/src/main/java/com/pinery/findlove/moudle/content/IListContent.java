package com.pinery.findlove.moudle.content;

import java.util.List;

/**
 * @author hesong
 * @e-mail hes1335@13322.com
 * @time 2018/2/26
 * @desc
 * @version: 3.1.2
 */

public interface IListContent {

  IContent getContent(int position);

  List<String> getTitleList();

  int size();

}

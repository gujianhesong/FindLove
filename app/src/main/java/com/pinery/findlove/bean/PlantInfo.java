package com.pinery.findlove.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gujian on 2018-08-04.
 */

public class PlantInfo {

  @SerializedName("class")
  private String classX;

  private int term_num;

  public List<BaikeInfo> terms;

  public static class BaikeInfo{
    public String name;
    public Baike baike;
  }

  public static class Baike{
    public String url;

    @SerializedName("abstract")
    public String description;

    public String small_0;
    public String big_0;

  }
}

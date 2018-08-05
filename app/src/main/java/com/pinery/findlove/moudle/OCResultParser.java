package com.pinery.findlove.moudle;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.pinery.findlove.bean.BaikeBean;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.bean.PlantInfo;
import com.pinery.findlove.bean.SimpleOCResultBean;
import com.pinery.findlove.http.UploadPicMoudle;
import com.pinery.findlove.util.TimeUtil;

/**
 * Created by gujian on 2018-08-03.
 */

public class OCResultParser {
  public interface OnParseCallback {
    void onSuccessSimple(SimpleOCResultBean bean);

    void onSuccessTotal(OCResultBean bean);

    void onFailure(String msg);
  }

  private Gson mGson;

  public OCResultParser() {
    mGson = new Gson();
  }

  public void parse(String content, OnParseCallback callback) {
    Logger.i("parse content:" + content);
    //Document doc = Jsoup.parse(content);
    //Elements elements = doc.select("script");
    //Elements childs = elements.select("window.bd");

    TimeUtil.updateTime();

    try {
      PlantInfo plantInfo = parsePlantInfo(content);
      TimeUtil.printTimeWithUpdate();
      BaikeBean baikeBean = parseBaikeInfo(content);
      TimeUtil.printTimeWithUpdate();
      int windowbdStartIndex = content.indexOf("window.bd");
      int windowbdEndIndex = content.indexOf("};", windowbdStartIndex);
      String windowbd = content.substring(windowbdStartIndex, windowbdEndIndex) + "}";
      windowbd = windowbd.substring(windowbd.indexOf("{"));
      //Logger.i(windowbd);

      SimpleOCResultBean simpleBean = parseSimpleInfo(windowbd);
      simpleBean.baikeBean = baikeBean;
      simpleBean.plantInfo = plantInfo;
      TimeUtil.printTimeWithUpdate();
      if (callback != null) {
        callback.onSuccessSimple(simpleBean);
      }

      OCResultBean bean = parseTotalInfo(windowbd);

      bean.simpleOCResultBean = simpleBean;

      if (callback != null) {
        callback.onSuccessTotal(bean);
      }
      TimeUtil.printTimeWithUpdate();

    } catch (Exception ex) {
      ex.printStackTrace();
      if (callback != null) {
        callback.onFailure(ex.getMessage());
      }
    }
  }

  private SimpleOCResultBean parseSimpleInfo(String content) {
    String guessword = parseWord(content, "guessWord");
    String queryImageUrl = parseWord(content, "queryImageUrl");
    String thumbImageUrl = parseWord(content, "thumbImageUrl");
    String baikeUrl = parseWord(content, "baikeUrl");
    String multitags = parseWord(content, "multitags");

    SimpleOCResultBean bean = new SimpleOCResultBean();
    bean.guessWord = guessword;
    bean.queryImageUrl = queryImageUrl;
    bean.thumbImageUrl = thumbImageUrl;
    bean.baikeUrl = baikeUrl;
    bean.multitags = multitags;

    return bean;
  }

  private OCResultBean parseTotalInfo(String content) {
    OCResultBean ocResultBean = mGson.fromJson(content, OCResultBean.class);

    return ocResultBean;
  }

  private BaikeBean parseBaikeInfo(String content) {
    try {
      BaikeBean baikeBean = new BaikeBean();

      int baikeNameStartIndex = content.indexOf("<a class=\"guess-newbaike-name\"");
      int baikeNameEndIndex = content.indexOf("</a>", baikeNameStartIndex);
      String subContent = content.substring(baikeNameStartIndex, baikeNameEndIndex);
      //Logger.i("subContent : " + subContent);

      String hrefKey = "href=\"";
      int hrefStartIndex = subContent.indexOf(hrefKey) + hrefKey.length();
      int hrefEndIndex = subContent.indexOf("\"", hrefStartIndex);
      String href = subContent.substring(hrefStartIndex, hrefEndIndex);
      //Logger.i("href : " + href);
      baikeBean.setBaikeUrl(href);

      int nameStartIndex = subContent.indexOf(">") + ">".length();
      String name = subContent.substring(nameStartIndex);
      //Logger.i("name : " + name);
      baikeBean.setBaikeName(name);

      String baikeTextKey = "<p class=\"guess-newbaike-text\">";
      int baikeTextStartIndex = content.indexOf(baikeTextKey) + baikeTextKey.length();
      int baikeTextEndIndex = content.indexOf("</p>", baikeTextStartIndex);
      String baikeText = content.substring(baikeTextStartIndex, baikeTextEndIndex);
      //Logger.i("baikeText : " + baikeText);
      baikeBean.setBaikeText(baikeText);

      return baikeBean;
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  private PlantInfo parsePlantInfo(String content) {
    try {
      String plantKey = "Plant.init(";
      int plantStartIndex = content.indexOf(plantKey) + plantKey.length();
      int plantEndIndex = content.indexOf(");", plantStartIndex);
      String plantContent = content.substring(plantStartIndex, plantEndIndex);
      //Logger.i("plantInfo : " + plantContent);

      PlantInfo plantInfo = mGson.fromJson(plantContent, PlantInfo.class);

      //Logger.i("plantInfo : " + plantInfo);
      return plantInfo;
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  private String parseWord(String content, String wordKey) {
    wordKey = "'" + wordKey + "'";
    int guesswordStartIndex = content.indexOf(wordKey) + wordKey.length();
    int startIndex = content.indexOf("'", guesswordStartIndex + 1);
    int endIndex = content.indexOf("'", startIndex + 1);
    String guessword = content.substring(startIndex + 1, endIndex);
    //Logger.i("parseWord : " + guessword);
    return guessword;
  }
}

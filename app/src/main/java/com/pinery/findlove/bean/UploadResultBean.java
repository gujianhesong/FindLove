package com.pinery.findlove.bean;

/**
 * Created by gujian on 2018-08-03.
 */

public class UploadResultBean {

  private int errono;
  private String url;
  private String querySign;
  private String simid;

  public int getErrono() {
    return errono;
  }

  public void setErrono(int errono) {
    this.errono = errono;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getQuerySign() {
    return querySign;
  }

  public void setQuerySign(String querySign) {
    this.querySign = querySign;
  }

  public String getSimid() {
    return simid;
  }

  public void setSimid(String simid) {
    this.simid = simid;
  }
}

package com.pinery.findlove.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gujian on 2018-08-03.
 */

public class OCResultBean {

  public String guessWord;
  public String queryImageUrl;
  public String thumbImageUrl;
  public String querySign;
  public String baikeUrl;
  public List<Source> sourceList;
  public List<Source> sameSizeList;
  public int sameNum;
  public List<Similary> simiList;

  public BaikeBean baikeBean;

  public SimpleOCResultBean simpleOCResultBean;

  public static class Source{
    public int data_type;
    public int srctype;
    public double score;
    public int classid;
    public int price;
    public int currentNum;
    public String objURL;
    public String thumbURL;
    public String fromURL;
    public String fromPageTitle;

    public String textHost;

    public long objTime;
    public long fileSize;
    public String objType;
    public int width;
    public int height;
    public String querysign;
    public String fromURLHost;
    public String flowURL;

  }

  public static class Similary{

    /**
     * ThumbnailContentSign : 327027957,1436590795
     * cont_sign : 327027957,1436590795
     * ThumbnailDomain : img2.imgtn.bdimg.com
     * ThumbnailSrcType : 0
     * SimiSourceFrom : 2
     * SimiValue : 0.7667474150657654
     * ThumbnailURL : http://img2.imgtn.bdimg.com/it/u=327027957,1436590795&fm=27&gp=0.jpg
     * LargeThumbnailImageUrl : http://img2.imgtn.bdimg.com/it/u=327027957,1436590795&fm=27&gp=0.jpg
     * MiddleThumbnailImageUrl : http://img2.imgtn.bdimg.com/it/u=327027957,1436590795&fm=27&gp=0.jpg
     * HoverURL : http://img2.imgtn.bdimg.com/it/u=327027957,1436590795&fm=23&gp=0.jpg
     * IsOnlySmallThumbnail : 0
     * ObjURL : http://s3.sinaimg.cn/middle/3e5ec476h881f01bfa7e2&690
     * HasThumbData : 0
     * ImageIndexNumber : 0
     * CurrentIndex : 0
     * FromURL : http://blog.sina.com.cn/s/blog_3e5ec4760100ivbk.html
     * simid_info : {"desc":{"ots":["荷包牡丹--微距习作"],"gpg":"http://blog.sina.com.cn/s/blog_3e5ec4760100ivbk.html","cont":"荷包牡丹 微距习作","ods":[]},"tags":{"keyword-cont2":[{"keyword":"荷包牡丹","max_vis_score":"0.6","maxword":"荷包牡丹","maxvote":"25","cur_vis_score":"0.6","maxscore":"0.482508003712"}]}}
     * face_info : {"simid":"20131210,6170110482586668277"}
     * FromURLHost : http://blog.sina.com.cn
     * ImageSourceType : 0
     * ImageDetailIndexNumber : 0
     * ImageNewsDate : 1970-01-01 08:00
     * FromPageSummary : 荷包牡丹--微距习作
     * FromPageSummaryOrig : 荷包牡丹--微距习作
     * FromPageSummaryPrefix :
     * FromPageName :
     * SpaceSignKey : 1105344728
     * ImageWidth : 690
     * ImageHeight : 517
     * BriefCat : 7
     * BriefCatNum : 0
     * BriefLoc : 0
     * BriefReleaseDate : 0
     * BriefCrawlerDate : 0
     * ImageSize : 50
     * ImageFormat : jpg
     * ImageSetSign : 0,0
     * ObjUrlSign : 1105344728,876551484
     * ImageSetImageCount : 0
     * AdDetailType : 0
     */

    private String ThumbnailContentSign;
    private String cont_sign;
    private String ThumbnailDomain;
    private int ThumbnailSrcType;
    private int SimiSourceFrom;
    private double SimiValue;
    private String ThumbnailURL;
    private String LargeThumbnailImageUrl;
    private String MiddleThumbnailImageUrl;
    private String HoverURL;
    private int IsOnlySmallThumbnail;
    private String ObjURL;
    private int HasThumbData;
    private int ImageIndexNumber;
    private int CurrentIndex;
    private String FromURL;
    private SimidInfoBean simid_info;
    private FaceInfoBean face_info;
    private String FromURLHost;
    private int ImageSourceType;
    private int ImageDetailIndexNumber;
    private String ImageNewsDate;
    private String FromPageSummary;
    private String FromPageSummaryOrig;
    private String FromPageSummaryPrefix;
    private String FromPageName;
    private long SpaceSignKey;
    private int ImageWidth;
    private int ImageHeight;
    private int BriefCat;
    private int BriefCatNum;
    private int BriefLoc;
    private int BriefReleaseDate;
    private int BriefCrawlerDate;
    private int ImageSize;
    private String ImageFormat;
    private String ImageSetSign;
    private String ObjUrlSign;
    private int ImageSetImageCount;
    private int AdDetailType;

    public String getThumbnailContentSign() {
      return ThumbnailContentSign;
    }

    public void setThumbnailContentSign(String ThumbnailContentSign) {
      this.ThumbnailContentSign = ThumbnailContentSign;
    }

    public String getCont_sign() {
      return cont_sign;
    }

    public void setCont_sign(String cont_sign) {
      this.cont_sign = cont_sign;
    }

    public String getThumbnailDomain() {
      return ThumbnailDomain;
    }

    public void setThumbnailDomain(String ThumbnailDomain) {
      this.ThumbnailDomain = ThumbnailDomain;
    }

    public int getThumbnailSrcType() {
      return ThumbnailSrcType;
    }

    public void setThumbnailSrcType(int ThumbnailSrcType) {
      this.ThumbnailSrcType = ThumbnailSrcType;
    }

    public int getSimiSourceFrom() {
      return SimiSourceFrom;
    }

    public void setSimiSourceFrom(int SimiSourceFrom) {
      this.SimiSourceFrom = SimiSourceFrom;
    }

    public double getSimiValue() {
      return SimiValue;
    }

    public void setSimiValue(double SimiValue) {
      this.SimiValue = SimiValue;
    }

    public String getThumbnailURL() {
      return ThumbnailURL;
    }

    public void setThumbnailURL(String ThumbnailURL) {
      this.ThumbnailURL = ThumbnailURL;
    }

    public String getLargeThumbnailImageUrl() {
      return LargeThumbnailImageUrl;
    }

    public void setLargeThumbnailImageUrl(String LargeThumbnailImageUrl) {
      this.LargeThumbnailImageUrl = LargeThumbnailImageUrl;
    }

    public String getMiddleThumbnailImageUrl() {
      return MiddleThumbnailImageUrl;
    }

    public void setMiddleThumbnailImageUrl(String MiddleThumbnailImageUrl) {
      this.MiddleThumbnailImageUrl = MiddleThumbnailImageUrl;
    }

    public String getHoverURL() {
      return HoverURL;
    }

    public void setHoverURL(String HoverURL) {
      this.HoverURL = HoverURL;
    }

    public int getIsOnlySmallThumbnail() {
      return IsOnlySmallThumbnail;
    }

    public void setIsOnlySmallThumbnail(int IsOnlySmallThumbnail) {
      this.IsOnlySmallThumbnail = IsOnlySmallThumbnail;
    }

    public String getObjURL() {
      return ObjURL;
    }

    public void setObjURL(String ObjURL) {
      this.ObjURL = ObjURL;
    }

    public int getHasThumbData() {
      return HasThumbData;
    }

    public void setHasThumbData(int HasThumbData) {
      this.HasThumbData = HasThumbData;
    }

    public int getImageIndexNumber() {
      return ImageIndexNumber;
    }

    public void setImageIndexNumber(int ImageIndexNumber) {
      this.ImageIndexNumber = ImageIndexNumber;
    }

    public int getCurrentIndex() {
      return CurrentIndex;
    }

    public void setCurrentIndex(int CurrentIndex) {
      this.CurrentIndex = CurrentIndex;
    }

    public String getFromURL() {
      return FromURL;
    }

    public void setFromURL(String FromURL) {
      this.FromURL = FromURL;
    }

    public SimidInfoBean getSimid_info() {
      return simid_info;
    }

    public void setSimid_info(SimidInfoBean simid_info) {
      this.simid_info = simid_info;
    }

    public FaceInfoBean getFace_info() {
      return face_info;
    }

    public void setFace_info(FaceInfoBean face_info) {
      this.face_info = face_info;
    }

    public String getFromURLHost() {
      return FromURLHost;
    }

    public void setFromURLHost(String FromURLHost) {
      this.FromURLHost = FromURLHost;
    }

    public int getImageSourceType() {
      return ImageSourceType;
    }

    public void setImageSourceType(int ImageSourceType) {
      this.ImageSourceType = ImageSourceType;
    }

    public int getImageDetailIndexNumber() {
      return ImageDetailIndexNumber;
    }

    public void setImageDetailIndexNumber(int ImageDetailIndexNumber) {
      this.ImageDetailIndexNumber = ImageDetailIndexNumber;
    }

    public String getImageNewsDate() {
      return ImageNewsDate;
    }

    public void setImageNewsDate(String ImageNewsDate) {
      this.ImageNewsDate = ImageNewsDate;
    }

    public String getFromPageSummary() {
      return FromPageSummary;
    }

    public void setFromPageSummary(String FromPageSummary) {
      this.FromPageSummary = FromPageSummary;
    }

    public String getFromPageSummaryOrig() {
      return FromPageSummaryOrig;
    }

    public void setFromPageSummaryOrig(String FromPageSummaryOrig) {
      this.FromPageSummaryOrig = FromPageSummaryOrig;
    }

    public String getFromPageSummaryPrefix() {
      return FromPageSummaryPrefix;
    }

    public void setFromPageSummaryPrefix(String FromPageSummaryPrefix) {
      this.FromPageSummaryPrefix = FromPageSummaryPrefix;
    }

    public String getFromPageName() {
      return FromPageName;
    }

    public void setFromPageName(String FromPageName) {
      this.FromPageName = FromPageName;
    }

    public long getSpaceSignKey() {
      return SpaceSignKey;
    }

    public void setSpaceSignKey(long SpaceSignKey) {
      this.SpaceSignKey = SpaceSignKey;
    }

    public int getImageWidth() {
      return ImageWidth;
    }

    public void setImageWidth(int ImageWidth) {
      this.ImageWidth = ImageWidth;
    }

    public int getImageHeight() {
      return ImageHeight;
    }

    public void setImageHeight(int ImageHeight) {
      this.ImageHeight = ImageHeight;
    }

    public int getBriefCat() {
      return BriefCat;
    }

    public void setBriefCat(int BriefCat) {
      this.BriefCat = BriefCat;
    }

    public int getBriefCatNum() {
      return BriefCatNum;
    }

    public void setBriefCatNum(int BriefCatNum) {
      this.BriefCatNum = BriefCatNum;
    }

    public int getBriefLoc() {
      return BriefLoc;
    }

    public void setBriefLoc(int BriefLoc) {
      this.BriefLoc = BriefLoc;
    }

    public int getBriefReleaseDate() {
      return BriefReleaseDate;
    }

    public void setBriefReleaseDate(int BriefReleaseDate) {
      this.BriefReleaseDate = BriefReleaseDate;
    }

    public int getBriefCrawlerDate() {
      return BriefCrawlerDate;
    }

    public void setBriefCrawlerDate(int BriefCrawlerDate) {
      this.BriefCrawlerDate = BriefCrawlerDate;
    }

    public int getImageSize() {
      return ImageSize;
    }

    public void setImageSize(int ImageSize) {
      this.ImageSize = ImageSize;
    }

    public String getImageFormat() {
      return ImageFormat;
    }

    public void setImageFormat(String ImageFormat) {
      this.ImageFormat = ImageFormat;
    }

    public String getImageSetSign() {
      return ImageSetSign;
    }

    public void setImageSetSign(String ImageSetSign) {
      this.ImageSetSign = ImageSetSign;
    }

    public String getObjUrlSign() {
      return ObjUrlSign;
    }

    public void setObjUrlSign(String ObjUrlSign) {
      this.ObjUrlSign = ObjUrlSign;
    }

    public int getImageSetImageCount() {
      return ImageSetImageCount;
    }

    public void setImageSetImageCount(int ImageSetImageCount) {
      this.ImageSetImageCount = ImageSetImageCount;
    }

    public int getAdDetailType() {
      return AdDetailType;
    }

    public void setAdDetailType(int AdDetailType) {
      this.AdDetailType = AdDetailType;
    }

    public static class SimidInfoBean {
      /**
       * desc : {"ots":["荷包牡丹--微距习作"],"gpg":"http://blog.sina.com.cn/s/blog_3e5ec4760100ivbk.html","cont":"荷包牡丹 微距习作","ods":[]}
       * tags : {"keyword-cont2":[{"keyword":"荷包牡丹","max_vis_score":"0.6","maxword":"荷包牡丹","maxvote":"25","cur_vis_score":"0.6","maxscore":"0.482508003712"}]}
       */

      private DescBean desc;
      private TagsBean tags;

      public DescBean getDesc() {
        return desc;
      }

      public void setDesc(DescBean desc) {
        this.desc = desc;
      }

      public TagsBean getTags() {
        return tags;
      }

      public void setTags(TagsBean tags) {
        this.tags = tags;
      }

      public static class DescBean {
        /**
         * ots : ["荷包牡丹--微距习作"]
         * gpg : http://blog.sina.com.cn/s/blog_3e5ec4760100ivbk.html
         * cont : 荷包牡丹 微距习作
         * ods : []
         */

        private String gpg;
        private String cont;
        private List<String> ots;
        private List<?> ods;

        public String getGpg() {
          return gpg;
        }

        public void setGpg(String gpg) {
          this.gpg = gpg;
        }

        public String getCont() {
          return cont;
        }

        public void setCont(String cont) {
          this.cont = cont;
        }

        public List<String> getOts() {
          return ots;
        }

        public void setOts(List<String> ots) {
          this.ots = ots;
        }

        public List<?> getOds() {
          return ods;
        }

        public void setOds(List<?> ods) {
          this.ods = ods;
        }
      }

      public static class TagsBean {
        @SerializedName("keyword-cont2") private List<Keywordcont2Bean> keywordcont2;

        public List<Keywordcont2Bean> getKeywordcont2() {
          return keywordcont2;
        }

        public void setKeywordcont2(List<Keywordcont2Bean> keywordcont2) {
          this.keywordcont2 = keywordcont2;
        }

        public static class Keywordcont2Bean {
          /**
           * keyword : 荷包牡丹
           * max_vis_score : 0.6
           * maxword : 荷包牡丹
           * maxvote : 25
           * cur_vis_score : 0.6
           * maxscore : 0.482508003712
           */

          private String keyword;
          private String max_vis_score;
          private String maxword;
          private String maxvote;
          private String cur_vis_score;
          private String maxscore;

          public String getKeyword() {
            return keyword;
          }

          public void setKeyword(String keyword) {
            this.keyword = keyword;
          }

          public String getMax_vis_score() {
            return max_vis_score;
          }

          public void setMax_vis_score(String max_vis_score) {
            this.max_vis_score = max_vis_score;
          }

          public String getMaxword() {
            return maxword;
          }

          public void setMaxword(String maxword) {
            this.maxword = maxword;
          }

          public String getMaxvote() {
            return maxvote;
          }

          public void setMaxvote(String maxvote) {
            this.maxvote = maxvote;
          }

          public String getCur_vis_score() {
            return cur_vis_score;
          }

          public void setCur_vis_score(String cur_vis_score) {
            this.cur_vis_score = cur_vis_score;
          }

          public String getMaxscore() {
            return maxscore;
          }

          public void setMaxscore(String maxscore) {
            this.maxscore = maxscore;
          }
        }
      }
    }

    public static class FaceInfoBean {
      /**
       * simid : 20131210,6170110482586668277
       */

      private String simid;

      public String getSimid() {
        return simid;
      }

      public void setSimid(String simid) {
        this.simid = simid;
      }
    }
  }

}

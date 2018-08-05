package com.pinery.findlove.http;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.pinery.findlove.api.BaiduApi;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.bean.SimpleOCResultBean;
import com.pinery.findlove.bean.UploadResultBean;
import com.pinery.findlove.moudle.OCResultParser;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by gujian on 2018-08-03.
 */

public class UploadPicMoudle {

  public interface UploadCallback {
    void onSuccess(UploadResultBean bean);

    void onFailure(String msg);
  }

  public interface OnQueryCallback {
    void onSuccessSimple(SimpleOCResultBean bean);

    void onSuccessTotal(OCResultBean bean);

    void onFailure(String msg);
  }

  private RetrofitClient client;
  private BaiduApi baiduApi;
  private OCResultParser parser;
  private Handler mHandler;

  public UploadPicMoudle() {
    client = new RetrofitClient();
    baiduApi = client.getRetrofit().create(BaiduApi.class);
    parser = new OCResultParser();
    mHandler = new Handler(Looper.getMainLooper());
  }

  public void queryPicture(File file, final OnQueryCallback callback){
    uploadPicture(file, new UploadPicMoudle.UploadCallback() {
      @Override public void onSuccess(UploadResultBean resultBean) {
        queryImage(resultBean.getUrl(), resultBean.getQuerySign(), callback);
      }

      @Override public void onFailure(final String msg) {
        mHandler.post(new Runnable() {
          @Override public void run() {
            if(callback != null){
              callback.onFailure(msg);
            }
          }
        });
      }
    });
  }

  private void uploadPicture(File file, final UploadCallback callback) {
    if (file == null || !file.exists()) {
      return;
    }

    final RequestBody requestFile =
        RequestBody.create(MediaType.parse("multipart/form-data"), file);
    MultipartBody.Part body =
        MultipartBody.Part.createFormData("file", file.getName(), requestFile);

    // 执行请求
    Call<ResponseBody> call = baiduApi.upload(body);
    call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
        Logger.i("Upload success:" + response.message());
        ResponseBody responseBody = response.body();
        try {
          String content = responseBody.string();
          Logger.i("return content:" + content);

          Gson gson = new Gson();
          UploadResultBean resultBean = gson.fromJson(content, UploadResultBean.class);

          if(resultBean != null){
            if(callback != null){
              callback.onSuccess(resultBean);
            }
          }else{
            if(callback != null){
              callback.onFailure("返回结果Null");
            }
          }

        } catch (IOException e) {
          e.printStackTrace();
          if(callback != null){
            callback.onFailure(e.getMessage());
          }
        }
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {
        Logger.e("Upload error:" + t.getMessage());
        if(callback != null){
          callback.onFailure("网络不佳，请稍后再试");
        }
      }
    });
  }

  private void queryImage(String imgUrl, String querySign, final OnQueryCallback callback) {
    Logger.i("queryImage url:" + imgUrl + ", " + querySign);

    Call<ResponseBody> call = baiduApi.queryImage(imgUrl, querySign);
    call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
        Logger.i("queryImage success:" + response.message());
        ResponseBody responseBody = response.body();
        try {
          String content = responseBody.string();

          parser.parse(content, new OCResultParser.OnParseCallback() {
            @Override public void onSuccessSimple(final SimpleOCResultBean bean) {
              mHandler.post(new Runnable() {
                @Override public void run() {
                  if(callback != null){
                    callback.onSuccessSimple(bean);
                  }
                }
              });
            }

            @Override public void onSuccessTotal(final OCResultBean bean) {
              mHandler.post(new Runnable() {
                @Override public void run() {
                  if(callback != null){
                    callback.onSuccessTotal(bean);
                  }
                }
              });
            }

            @Override public void onFailure(final String msg) {
              mHandler.post(new Runnable() {
                @Override public void run() {
                  if(callback != null){
                    callback.onFailure(msg);
                  }
                }
              });

            }
          });

        } catch (final IOException e) {
          e.printStackTrace();
          mHandler.post(new Runnable() {
            @Override public void run() {
              if(callback != null){
                callback.onFailure(e.getMessage());
              }
            }
          });

        }
      }

      @Override public void onFailure(Call<ResponseBody> call, final Throwable t) {
        Logger.e("queryImage error:" + t.getMessage());
        mHandler.post(new Runnable() {
          @Override public void run() {
            if(callback != null){
              callback.onFailure(t.getMessage());
            }
          }
        });
      }
    });

  }
}

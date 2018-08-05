package com.pinery.findlove.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.pinery.findlove.BuildConfig;
import com.pinery.findlove.common.Constants;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gujian on 2018-08-03.
 */

public class RetrofitClient {
  private OkHttpClient okHttpClient;
  private Retrofit retrofit;

  public RetrofitClient() {

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (BuildConfig.DEBUG) {
      builder.addNetworkInterceptor(new StethoInterceptor());
    }
    okHttpClient = builder.build();

    retrofit = new Retrofit.Builder().baseUrl(HttpUrl.parse(Constants.BAIDU_IMG_URL))
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public Retrofit getRetrofit() {
    return retrofit;
  }

  public OkHttpClient getOkHttpClient() {
    return okHttpClient;
  }
}

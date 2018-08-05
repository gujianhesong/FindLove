package com.pinery.findlove.api;

import com.pinery.findlove.common.Constants;
import java.net.URLEncoder;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by gujian on 2018-08-03.
 */

public interface BaiduApi {

  @Multipart @POST(Constants.UPLOAD_PIC_URL)
  Call<ResponseBody> upload(@Part MultipartBody.Part file);

  @GET(Constants.QUERY_PIC_URL + "&fm=home&uptype=upload_mobile&result=result_camera&vs=24ef640a0548bdceec8ea6d35f0c25108b52dd4e")
  Call<ResponseBody> queryImage(@Query("queryImageUrl") String url, @Query("querySign") String querySign);

}

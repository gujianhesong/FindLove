package com.pinery.findlove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.pinery.findlove.base.BaseActivity;
import com.pinery.findlove.bean.OCResultBean;
import com.pinery.findlove.bean.SimpleOCResultBean;
import com.pinery.findlove.http.UploadPicMoudle;
import com.pinery.findlove.moudle.content.OCRListContent;
import java.io.File;
import java.util.List;

public class MainActivity extends BaseActivity{
  private String curSelectPicture;
  private ImageView ivPicture;
  private UploadPicMoudle uploadPicMoudle;

  private FrameLayout container;

  private OCRListContent listContent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_select_pic).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        selectPicture();
      }
    });

    findViewById(R.id.btn_recognize_pic).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        recognizePicture();
      }
    });

    ivPicture = (ImageView)findViewById(R.id.iv_picture);

    container = (FrameLayout) findViewById(R.id.container);

  }

  private void selectPicture(){
    PictureSelector.create(this).openGallery(PictureMimeType.ofImage())
        .forResult(PictureConfig.CHOOSE_REQUEST);
  }

  private void recognizePicture(){
    if(curSelectPicture == null){
      Toast.makeText(this, "没有选择图片", Toast.LENGTH_SHORT).show();
      return;
    }

    showLoadingDialog(false);

    if(uploadPicMoudle == null){
      uploadPicMoudle = new UploadPicMoudle();
    }
    uploadPicMoudle.queryPicture(new File(curSelectPicture), new UploadPicMoudle.OnQueryCallback() {
      @Override public void onSuccessSimple(SimpleOCResultBean bean) {
        hideLoadingDialog();
      }

      @Override public void onSuccessTotal(OCResultBean bean) {
        hideLoadingDialog();

        showTotalInfo(bean);
      }

      @Override public void onFailure(String msg) {
        hideLoadingDialog();

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
      }
    });

  }



  private void showTotalInfo(OCResultBean bean){
    if(listContent == null){
      listContent = new OCRListContent(this);
    }

    if(listContent.getView().getParent() == null){
      container.addView(listContent.getView());
    }

    listContent.fillData(bean);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
      switch (requestCode) {
        case PictureConfig.CHOOSE_REQUEST:
          // 图片、视频、音频选择结果回调
          List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
          // 例如 LocalMedia 里面返回三种path
          // 1.media.getPath(); 为原图path
          // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
          // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
          // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的

          if(selectList != null && selectList.size() > 0){
            LocalMedia media = selectList.get(0);
            curSelectPicture = media != null ? media.getPath() : null;
          }

          Glide.with(this).load(curSelectPicture).into(ivPicture);

          break;
      }
    }
  }


}

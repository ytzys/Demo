package com.ytzys.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangyisu on 2016/7/6.
 */
public class ImageViewOverlayActivity extends Activity {

    @Bind(R.id.image1)
    ImageView imageView1;
    @Bind(R.id.image2)
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_overlay_activity);
        ButterKnife.bind(this);

        imageView1.setImageResource(R.mipmap.test1);
        imageView2.setImageResource(R.mipmap.download_mask_icon);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }).start();
    }
}

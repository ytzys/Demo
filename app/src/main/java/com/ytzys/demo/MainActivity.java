package com.ytzys.demo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.activity_anim)
    Button button_activity_anim;
    @Bind(R.id.silence_install)
    Button silence_install;
    @Bind(R.id.popwin)
    RelativeLayout popwin;
    @Bind(R.id.animation_test)
    Button animation_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PopupWindow pw = new PopupWindow(MainActivity.this);
//                pw.setWidth(50);
//                pw.setHeight(50);
//                pw.setContentView(View.inflate(MainActivity.this, R.layout.popwindow, null));
//                pw.setFocusable(true);
//                pw.setTouchable(true);
//                pw.setOutsideTouchable(true);
////                ColorDrawable cd = new ColorDrawable(Color.RED);
////                pw.setBackgroundDrawable(cd);
//                pw.showAtLocation(popwin, Gravity.NO_GRAVITY, 0, 400);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("tvfan.tv", "tvfan.tv.Bootloader"));
                intent.putExtra("programSeriesId", "79,3");
                intent.putExtra("actName", "OPEN_DETAIL");
                intent.setAction("android.intent.action.VIEW");
                startActivity(intent);

//                Intent tmp = new Intent(Intent.ACTION_VIEW, Uri.parse("liteclient://mliteAction?aid=89681&vid=1989336&launchMode=2&packageName=com.sumavision.talktv2"));
//                startActivity(tmp);

//                Intent intent = new Intent(MainActivity.this, ImageViewOverlayActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
        button_activity_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimActivity.class);
//                intent.setComponent(new ComponentName("tvfan.tv", "tvfan.tv.Bootloader"));
//                intent.putExtra("programSeriesId", "TVFAN-program-151532");
//                intent.putExtra("actName", "OPEN_DETAIL");
//                intent.setAction("android.intent.action.VIEW");
                startActivity(intent);
            }
        });

//        silence_install.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SilenceInstallActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @OnClick(R.id.animation_test)
    public void animationFun() {
        Intent intent = new Intent(MainActivity.this, PropertyAnimatorActivity.class);
        startActivity(intent);
    }
}

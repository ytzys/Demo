package com.ytzys.demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ytzys.demo.R;

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
    @Bind(R.id.click_through_test)
    Button clickThroughButton;
    @Bind(R.id.player_test)
    Button playButton;

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

    @OnClick(R.id.click_through_test)
    public void clickThroughTest() {
        Intent intent = new Intent(MainActivity.this, ClickThroughTestActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.player_test)
    public void playFun() {
//        Uri uri = Uri.parse("http://play.g3proxy.lecloud.com/vod/v2/MjQ3LzcvNDIvbGV0di11dHMvMTQvdmVyXzAwXzIyLTEwODE5Mzg0MzItYXZjLTE0NjkxMDQtYWFjLTk2MDAwLTQ0NDU3NjAtODc2NDQ5MDA3LTI0OTZlOGEwZmZmYTkyZjc1OWU2MjNmNTg2YmRmZjg1LTE0ODQ1NDQyMzgzMjQubXA0?b=1577&mmsid=62600109&tm=1484805916&key=69b045a35c8b6e1e347df9dae2b00df9&platid=6&splatid=602&orifrom=aHR0cDovL3R2ZXBnLmxldHYuY29tL2Z0bC9hcGsvZGF0YS9jb21tb24vc2VjdXJpdHkvcGxheXVybC9nZXR1cmwvYnl2aWQ=&orivid=27506445&clientIp01=122.114.152.188&clientIp02=111.206.210.33&playid=0&tss=tvts&vtype=51&cvid=384065246356&payff=0&pip=47ac29f176cfbc686793bde9a547beda");
//        Uri uri = Uri.parse("http://k.youku.com/player/getFlvPath/sid/1484804581055128c9b76_00/st/mp4/fileid/0300200100587DA38B4D4B011BA6A9277C46F3-9505-EE66-9334-21FE9057558D?k=cd886daeb7b818c3261f7794&hd=1&myp=0&ts=5869&ypremium=1&ymovie=1&sign=35a51094a99e0d19d61f7312b3651dec&ypp=0&ctype=12&ev=1&token=0929&oip=712725356&ep=cyacHkGNUssI5CPajT8bb3%2frJnAJXP4J9h%2bHgdJjALshQO%2fL6D3ZtZnESo1CF%2fhrAyR3Gen2rKPjbDYXYflGqW0QqjuuP%2frp%2ffPn5a9SsuUJZhwxd8jfwFSeSjL4");
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}

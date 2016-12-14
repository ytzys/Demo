package com.ytzys.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/13.
 */
public class PropertyAnimatorActivity extends Activity {

    @Bind(R.id.imageview)
    ImageView tv;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.translateAnimation)
    Button translateButton;
    @Bind(R.id.alphaAnimation)
    Button alphaButton;
    @Bind(R.id.rotateAnimation)
    Button rotateButton;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proper_anim_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        animation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        tv.startAnimation(animation);
    }

    @OnClick(R.id.translateAnimation)
    public void onClick1() {
        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        tv.startAnimation(animation);
    }

    @OnClick(R.id.alphaAnimation)
    public void onClick2() {
        animation = new AlphaAnimation(1, 0);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        tv.startAnimation(animation);
    }

    @OnClick(R.id.rotateAnimation)
    public void onClick3() {
        animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        tv.startAnimation(animation);
    }
}

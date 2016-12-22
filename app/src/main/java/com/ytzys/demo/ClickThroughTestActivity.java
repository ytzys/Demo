package com.ytzys.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/22.
 */
public class ClickThroughTestActivity extends Activity {

    @Bind(R.id.click_through_test_botton)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_through_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.click_through_test_botton)
    public void click() {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }
}

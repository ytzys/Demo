package com.ytzys.demo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ytzys.demo.Presenter.BasePresenter;
import com.ytzys.demo.R;
import com.ytzys.demo.iview.IBaseView;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    abstract int getLayoutId();
    abstract T initPresenter();
    abstract void initView();

}

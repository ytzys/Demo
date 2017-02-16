package com.ytzys.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ytzys.demo.Presenter.BasePresenter;
import com.ytzys.demo.iview.IBaseView;

import butterknife.ButterKnife;

/**
 * Created by ytzys on 2017/2/15.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView {

    T presenter;
    String TAG = getClass().getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initPresent();
        initView();
        return view;
    }

    abstract int getLayoutId();

    abstract void initPresent();

    abstract void initView();
}

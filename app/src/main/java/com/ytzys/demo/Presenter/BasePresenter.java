package com.ytzys.demo.Presenter;

import com.ytzys.demo.iview.IBaseView;

/**
 * Created by zhangyisu on 2017/2/15.
 */

public class BasePresenter<T extends IBaseView> {
    T iBaseView;
    String TAG = getClass().getName();

    public BasePresenter(T iView) {
        this.iBaseView = iView;
    }
}

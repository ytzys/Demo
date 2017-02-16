package com.ytzys.demo.Presenter;

import android.util.Log;

import com.ytzys.demo.bean.HomePageResult;
import com.ytzys.demo.http.MyRetrofit;
import com.ytzys.demo.http.interfaces.HomePageInterface;
import com.ytzys.demo.iview.IHomeView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ytzys on 2017/2/15.
 */
public class HomePresenter extends BasePresenter<IHomeView> {

    public HomePresenter(IHomeView iBaseView) {
        super(iBaseView);
    }

    public void getRecommendData() {
        HomePageInterface homePageInterface = MyRetrofit.getInstance().getClient(HomePageInterface.class);
        homePageInterface.getRecommendResult("Bearer OHk7U51j9pMj8t5CW5bl0G2W2kbIJstM1wxMKoTT", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomePageResult>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "OnError");
                    }

                    @Override
                    public void onNext(HomePageResult homePageResult) {
                        iBaseView.homeRecommendDataGot(homePageResult);
                    }
                });
    }
}

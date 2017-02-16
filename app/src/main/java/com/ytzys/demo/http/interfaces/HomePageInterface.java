package com.ytzys.demo.http.interfaces;

import com.ytzys.demo.bean.HomePageResult;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangyisu on 2017/2/15.
 */

public interface HomePageInterface {

    @GET("/api/streams")
    public Observable<HomePageResult> getRecommendResult(@Header("Authorization") String header, @Query("page") String pageValue);
}

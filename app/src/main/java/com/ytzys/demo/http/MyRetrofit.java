package com.ytzys.demo.http;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangyisu on 2017/2/15.
 */

public class MyRetrofit {

    private static MyRetrofit instance;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    String TAG = getClass().getName();

    private MyRetrofit() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClient = okHttpClientBuilder
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Log.i(TAG, chain.request().url().toString());
                        return chain.proceed(chain.request());
                    }
                })
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl("http://liveapi.9ddm.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    public static MyRetrofit getInstance() {
        if (instance == null) {
            instance = new MyRetrofit();
        }
        return instance;
    }

    public <T> T getClient(Class<T> clazz) {
        return (T) retrofit.create(clazz);
    }
}

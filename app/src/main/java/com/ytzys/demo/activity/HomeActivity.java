package com.ytzys.demo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ytzys.demo.Bean.HomePageResult;
import com.ytzys.demo.Presenter.BasePresenter;
import com.ytzys.demo.Presenter.HomePresenter;
import com.ytzys.demo.R;
import com.ytzys.demo.adapter.HomeRecommendAdapter;
import com.ytzys.demo.iview.IHomeView;

import butterknife.Bind;

/**
 * Created by zhangyisu on 2017/2/15.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeView {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    HomeRecommendAdapter homeRecommendAdapter;

    @Override
    int getLayoutId() {
        return R.layout.layout_home_activiy;
    }

    @Override
    HomePresenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    void initView() {
        homeRecommendAdapter = new HomeRecommendAdapter(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(homeRecommendAdapter);
        presenter.getRecommendData();
    }

    @Override
    public void resultGot(Object result) {

    }

    @Override
    public void homeRecommendDataGot(HomePageResult result) {
        homeRecommendAdapter.updateList(result.getData());
        homeRecommendAdapter.notifyDataSetChanged();
    }
}

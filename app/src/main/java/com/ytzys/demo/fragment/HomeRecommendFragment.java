package com.ytzys.demo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ytzys.demo.Presenter.HomePresenter;
import com.ytzys.demo.R;
import com.ytzys.demo.adapter.HomeRecommendAdapter;
import com.ytzys.demo.bean.HomePageResult;
import com.ytzys.demo.iview.IHomeView;

import butterknife.Bind;

/**
 * Created by ytzhs on 2017/2/15.
 */

public class HomeRecommendFragment extends BaseFragment<HomePresenter> implements IHomeView {

    HomeRecommendAdapter homeRecommendAdapter;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    int getLayoutId() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    void initPresent() {
        presenter = new HomePresenter(this);
    }

    @Override
    void initView() {
        homeRecommendAdapter = new HomeRecommendAdapter(getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(homeRecommendAdapter);
        presenter.getRecommendData();
    }

    @Override
    public void homeRecommendDataGot(HomePageResult result) {
        homeRecommendAdapter.updateList(result.getData());
        homeRecommendAdapter.notifyDataSetChanged();
    }

    @Override
    public void resultGot(Object result) {

    }
}

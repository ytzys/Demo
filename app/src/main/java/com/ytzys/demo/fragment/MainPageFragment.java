package com.ytzys.demo.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.ytzys.demo.Presenter.BasePresenter;
import com.ytzys.demo.R;
import com.ytzys.demo.adapter.MainPageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ytzys on 2017/2/16.
 */

public class MainPageFragment extends BaseFragment {

//    @Bind(R.id.search)
//    ImageView search;

    @Bind(R.id.tablayout_mainpage)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;
    private String[] titleName = {"关注", "推荐", "最新"};

    @Override
    int getLayoutId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    void initPresent() {

    }

    @Override
    void initView() {
        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(titleName[i]);
            tabLayout.addTab(tab);
        }
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new HomeRecommendFragment());
        list.add(new HomeRecommendFragment());
        list.add(new HomeRecommendFragment());
        viewPager.setAdapter(new MainPageFragmentAdapter(getFragmentManager(), list, titleName));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "");
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void resultGot(Object result) {

    }
}

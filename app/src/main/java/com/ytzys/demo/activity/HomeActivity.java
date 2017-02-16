package com.ytzys.demo.activity;

import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.ytzys.demo.bean.HomePageResult;
import com.ytzys.demo.Presenter.HomePresenter;
import com.ytzys.demo.R;
import com.ytzys.demo.adapter.HomeRecommendAdapter;
import com.ytzys.demo.fragment.HomeRecommendFragment;
import com.ytzys.demo.fragment.MainPageFragment;
import com.ytzys.demo.iview.IHomeView;

import butterknife.Bind;

/**
 * Created by ytzys on 2017/2/15.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeView {

    @Bind(android.R.id.tabhost)
    FragmentTabHost tabHost;

    HomeRecommendAdapter homeRecommendAdapter;
    private int[] drawable = {R.drawable.home_list_icon, R.drawable.home_live_icon, R.drawable.home_user_icon};
    private String[] tabsText = {"主页", "开播", "我的"};

    @Override
    int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    HomePresenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    void initView() {
//        homeRecommendAdapter = new HomeRecommendAdapter(this);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(llm);
//        recyclerView.setAdapter(homeRecommendAdapter);
//        presenter.getRecommendData();

        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.getTabWidget().setBackgroundDrawable(null);

        for (int i = 0; i < 3; i++) {
            TabHost.TabSpec spec = tabHost.newTabSpec(tabsText[i]).setIndicator(getTabIconView(i));
            if (i == 1) {
                tabHost.addTab(spec, null, null);
            } else if (i == 2) {
                tabHost.addTab(spec, HomeRecommendFragment.class, null);
            } else {
                tabHost.addTab(spec, MainPageFragment.class, null);
            }
        }

        tabHost.getTabWidget().getChildTabViewAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "跳转主播开播页面");
            }
        });

    }

    private View getTabIconView(int i) {
        View view = getLayoutInflater().inflate(R.layout.tabs, null, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.tabsIcon);
        imageView.setImageResource(drawable[i]);

        TextView textView = (TextView) view.findViewById(R.id.tabsText);
        textView.setText(tabsText[i]);
        return view;
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

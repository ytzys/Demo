package com.ytzys.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ytzys on 2017/2/16.
 */
public class MainPageFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> list;
    String[] titles;

    public MainPageFragmentAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.list = list;
        this.titles = titles; // 把tab名字通过数组传进来
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position]; // 在这里返回每个tab的名字
    }
}

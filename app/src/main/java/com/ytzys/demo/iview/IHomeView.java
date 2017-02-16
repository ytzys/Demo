package com.ytzys.demo.iview;

import com.ytzys.demo.bean.HomePageResult;

/**
 * Created by Administrator on 2017/2/15.
 */
public interface IHomeView extends IBaseView {
    public void homeRecommendDataGot(HomePageResult result);
}

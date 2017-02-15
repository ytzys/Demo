package com.ytzys.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ytzys.demo.Bean.HomePageResult;
import com.ytzys.demo.R;
import com.ytzys.demo.utils.GlideUtil;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ytzys on 2017/2/15.
 */
public class HomeRecommendAdapter extends RecyclerView.Adapter {

    List<HomePageResult.RecommendLiveBean> list = new ArrayList<HomePageResult.RecommendLiveBean>();
    Context context;

    public HomeRecommendAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public void setList(ArrayList list) {
//        this.list = list;
//    }

    public void updateList(List list) {
        this.list.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend, parent, false);
        ViewHoder viewHolder = new ViewHoder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHoder viewHolder = (ViewHoder) holder;
        HomePageResult.RecommendLiveBean data = list.get(position);
        viewHolder.audienceCount.setText(data.getWatched_nums() + "人观看");
        viewHolder.liveStatus.setText(data.getStatus() == 0 ? "已结束" : "直播中");
        viewHolder.location.setText(data.getCity());
        viewHolder.nickname.setText(data.getName());
        viewHolder.liveTitle.setText(data.getStream_title());
        GlideUtil.loadImg(context, data.getAvatar_small(), viewHolder.headPic);
        GlideUtil.loadImg(context, data.getAvatar(), viewHolder.livePic);
    }

    class ViewHoder extends RecyclerView.ViewHolder {

        @Bind(R.id.nickname)
        TextView nickname;

        @Bind(R.id.location)
        TextView location;

        @Bind(R.id.audienceCount)
        TextView audienceCount;

        @Bind(R.id.liveStatus)
        TextView liveStatus;

        @Bind(R.id.liveTitle)
        TextView liveTitle;

        @Bind(R.id.livePic)
        ImageView livePic;

        @Bind(R.id.headPic)
        ImageView headPic;

        public ViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

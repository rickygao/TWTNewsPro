package org.ricky.twtnewspro.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.ricky.twtnewspro.bean.NewsSummaryDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 2017/3/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsCardViewHolder> {

    private Activity mActivity;
    private List<NewsSummaryDataBean> mItems;
    private LayoutInflater mLayoutInflater;


    public NewsAdapter(Activity mActivity) {
        this.mActivity = mActivity;

        mLayoutInflater = LayoutInflater.from(mActivity);
        mItems = new ArrayList<>();
    }

    public void addItems(List<NewsSummaryDataBean> items) {
        int positionStart = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(positionStart, items.size());
    }

    public void clearItems() {
        int itemCount = mItems.size();
        mItems.clear();
        notifyItemRangeRemoved(0, itemCount);
    }

    @Override
    public NewsCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return NewsCardViewHolder.create(mLayoutInflater, parent, mActivity);
    }

    @Override
    public void onBindViewHolder(NewsCardViewHolder holder, int position) {
        holder.setItem(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
package org.ricky.twtnewspro.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Ricky on 2017/4/1.
 */

public abstract class OnScrollEndListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager mLinearLayoutManager;

    public OnScrollEndListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = mLinearLayoutManager.getChildCount();
        int totalItemCount = mLinearLayoutManager.getItemCount();
        int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if ((totalItemCount - visibleItemCount) <= firstVisibleItem) {
            onScrollEnd();
        }
    }

    public abstract void onScrollEnd();

}
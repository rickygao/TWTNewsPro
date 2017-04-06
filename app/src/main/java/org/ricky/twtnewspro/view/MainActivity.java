package org.ricky.twtnewspro.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.ricky.twtnewspro.R;
import org.ricky.twtnewspro.bean.NewsSummaryDataBean;
import org.ricky.twtnewspro.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainController {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private MainPresenter mPresenter;
    private NewsAdapter mNewsAdapter;
    private OnScrollEndListener mOnScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenter(this);

        setSupportActionBar(mToolBar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mNewsAdapter = new NewsAdapter(this);
        mOnScrollListener = new OnScrollEndListener(linearLayoutManager) {
            @Override
            public void onScrollEnd() {
                mPresenter.loadMorePage();
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mNewsAdapter.clearItems();
            mPresenter.initPage();
        });

        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.initPage();
    }

    @Override
    public void onLoadMorePage(List<NewsSummaryDataBean> bean) {
        mNewsAdapter.addItems(bean);
    }

    @Override
    public void onInitPage(List<NewsSummaryDataBean> bean) {
        mNewsAdapter.clearItems();
        mNewsAdapter.addItems(bean);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

}

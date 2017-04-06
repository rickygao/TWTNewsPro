package org.ricky.twtnewspro.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Toast;

import org.ricky.twtnewspro.R;
import org.ricky.twtnewspro.bean.NewsDetailDataBean;
import org.ricky.twtnewspro.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ricky on 2017/4/6.
 */

public class DetailActivity extends AppCompatActivity implements DetailController {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.webview_content)
    WebView mContentWebview;
    private DetailPresenter mPresenter;

    public static void startActivity(Context context, int index) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("index", index);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);

        int index = getIntent().getIntExtra("index", 0);

        mPresenter = new DetailPresenter(this);
        mPresenter.initDetail(index);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }

    @Override
    public void onInitDetail(NewsDetailDataBean bean) {
        String data = bean.getContent();
        mContentWebview.loadData(data, "text/html; charset=utf-8", null);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

}

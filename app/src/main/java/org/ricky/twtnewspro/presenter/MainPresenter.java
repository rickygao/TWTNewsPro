package org.ricky.twtnewspro.presenter;

import org.ricky.twtnewspro.model.NewsApiManager;
import org.ricky.twtnewspro.view.MainController;

/**
 * Created by Ricky on 2017/3/31.
 */

public class MainPresenter {

    private MainController mController;

    private NewsApiManager mApiManager;

    private int cate = 1;
    private int page;
    private boolean ready = true;

    public MainPresenter(MainController mController) {
        this.mController = mController;
        mApiManager = NewsApiManager.getInstance();
    }

    public void initPage() {
        if (ready) {
            ready = false;
            page = 1;
            mApiManager.getNewsPage(bean -> {
                        mController.onInitPage(bean);
                        ready = true;
                    },
                    throwable -> {
                        mController.onError(throwable);
                        ready = true;
                    },
                    cate, page);
            page++;
        }
    }

    public void loadMorePage() {
        if (ready) {
            ready = false;
            mApiManager.getNewsPage(bean -> {
                        mController.onLoadMorePage(bean);
                        ready = true;
                    },
                    throwable -> {
                        mController.onError(throwable);
                        ready = true;
                    },
                    cate, page);
            page++;
        }
    }

}

package org.ricky.twtnewspro.presenter;

import org.ricky.twtnewspro.model.NewsApiManager;
import org.ricky.twtnewspro.view.DetailController;

/**
 * Created by Ricky on 2017/4/6.
 */

public class DetailPresenter {

    private DetailController mController;
    private NewsApiManager mApiManager;

    public DetailPresenter(DetailController mController) {
        this.mController = mController;
        mApiManager = NewsApiManager.getInstance();
    }

    public void initDetail(int index) {
        mApiManager.getNewsDetail(bean -> mController.onInitDetail(bean),
                throwable -> mController.onError(throwable),
                index);
    }
}

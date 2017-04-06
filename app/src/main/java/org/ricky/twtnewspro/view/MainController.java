package org.ricky.twtnewspro.view;

import org.ricky.twtnewspro.bean.NewsSummaryDataBean;

import java.util.List;

/**
 * Created by Ricky on 2017/3/31.
 */

public interface MainController {

    void onInitPage(List<NewsSummaryDataBean> bean);

    void onLoadMorePage(List<NewsSummaryDataBean> bean);

    void onError(Throwable throwable);

}

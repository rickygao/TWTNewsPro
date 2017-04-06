package org.ricky.twtnewspro.view;

import org.ricky.twtnewspro.bean.NewsDetailDataBean;

/**
 * Created by Ricky on 2017/4/6.
 */

public interface DetailController {

    void onInitDetail(NewsDetailDataBean bean);

    void onError(Throwable throwable);

}

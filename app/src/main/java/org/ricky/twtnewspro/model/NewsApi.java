package org.ricky.twtnewspro.model;

import org.ricky.twtnewspro.bean.ApiResult;
import org.ricky.twtnewspro.bean.NewsDetailDataBean;
import org.ricky.twtnewspro.bean.NewsSummaryDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ricky on 2017/3/17.
 */

public interface NewsApi {

    @GET("v1/news/{cate}/page/{page}")
    Observable<ApiResult<List<NewsSummaryDataBean>>> getNewsPage(@Path("cate") int cate, @Path("page") int page);

    @GET("v1/news/{index}")
    Observable<ApiResult<NewsDetailDataBean>> getNewsDetail(@Path("index") int index);

}

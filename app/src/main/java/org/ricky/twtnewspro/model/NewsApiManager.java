package org.ricky.twtnewspro.model;


import org.ricky.twtnewspro.bean.ApiResult;
import org.ricky.twtnewspro.bean.NewsDetailDataBean;
import org.ricky.twtnewspro.bean.NewsSummaryDataBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricky on 2017/3/17.
 */

public final class NewsApiManager {

    private static final String BASE_URL = "http://open.twtstudio.com/api/";
    private static final int CONNECT_TIME_OUT = 10;
    private OkHttpClient mClient;
    private Retrofit mRetrofit;
    private NewsApi mNewsApi;
    private Observable<ApiResult<List<NewsSummaryDataBean>>> mPageObservable;

    private NewsApiManager() {

        mClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(mClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mNewsApi = mRetrofit.create(NewsApi.class);

    }

    /**
     * NewsApiManager使用饿汉单例模式
     *
     * @return 返回NewsApiManager的全局唯一实例
     */
    public static NewsApiManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getNewsPage(Consumer<List<NewsSummaryDataBean>> onNext, Consumer<Throwable> onError, int cate, int page) {
        mNewsApi.getNewsPage(cate, page)
                .map(ApiResult::getData)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

    public void getNewsDetail(Consumer<NewsDetailDataBean> onNext, Consumer<Throwable> onError, int index) {
        mNewsApi.getNewsDetail(index)
                .map(ApiResult::getData)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

    private static class SingletonHolder {
        private static final NewsApiManager INSTANCE = new NewsApiManager();
    }

}

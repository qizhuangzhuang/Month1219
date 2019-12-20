package com.bawei.month1219.mvp;

import com.bawei.month1219.ApiService;
import com.bawei.month1219.bean.LeftResultBean;
import com.bawei.month1219.net.Refiut;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Model implements LeftContract.LeftModel {
    @Override
    public void show(final DataCallBack dataCallBack) {
        Retrofit retrofit = Refiut.getInstance().getRetrofit();
        ApiService apisever = retrofit.create(ApiService.class);
        Observable<LeftResultBean> show = apisever.show();
        show.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<LeftResultBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LeftResultBean leftResultBean) {
                 dataCallBack.success(leftResultBean);

            }

            @Override
            public void onError(Throwable e) {
                dataCallBack.fainals(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        })      ;
    }
}

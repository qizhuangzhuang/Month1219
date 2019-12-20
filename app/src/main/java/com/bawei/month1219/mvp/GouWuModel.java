package com.bawei.month1219.mvp;


import com.bawei.month1219.ApiService;
import com.bawei.month1219.bean.GouWuResult;
import com.bawei.month1219.net.Refiut;
import com.google.gson.Gson;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class GouWuModel implements GouWuContract.GouWuModel {
    @Override
    public void GouWushow(final DataCallBack dataCallBack) {
        Retrofit retrofit = Refiut.getInstance().getRetrofit();
        ApiService apisever = retrofit.create(ApiService.class);
        Observable<GouWuResult> gouWu = apisever.getGouWu();
        gouWu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GouWuResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GouWuResult gouWuResult) {
                            dataCallBack.success(gouWuResult);


                    }

                    @Override
                    public void onError(Throwable e) {
                         dataCallBack.fainals(e.getMessage());


                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

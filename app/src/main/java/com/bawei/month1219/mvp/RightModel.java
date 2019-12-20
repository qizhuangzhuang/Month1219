package com.bawei.month1219.mvp;

import android.util.Log;

import com.bawei.month1219.ApiService;
import com.bawei.month1219.bean.RightResultBean;
import com.bawei.month1219.net.Refiut;
import com.google.gson.Gson;
import java.util.Map;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RightModel implements RightContract.RightModel {
    @Override
    public void RightShow(final Map<String, String> map, final DataCallBack dataCallBack) {

        Retrofit retrofit = Refiut.getInstance().getRetrofit();
        ApiService apisever = retrofit.create(ApiService.class);
        Observable<RightResultBean> right = apisever.RightShow(map);
        right.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightResultBean rightResultBean) {
                        Log.d("tag", "onNext: ");
                        dataCallBack.success(rightResultBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("1111",e.getMessage());
//                        Table unique = tableDao.queryBuilder().where(TableDao.Properties.Url.eq(map.get("categoryId"))).limit(1).unique();
//                        if (unique!=null){
//                            String json = unique.getJson();
//                            RightResultBean bean = new Gson().fromJson(json, RightResultBean.class);
//                            dataCallBack.success(bean);
//                        }
                        dataCallBack.fainal(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

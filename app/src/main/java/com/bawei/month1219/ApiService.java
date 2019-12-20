package com.bawei.month1219;

import com.bawei.month1219.bean.GouWuResult;
import com.bawei.month1219.bean.LeftResultBean;
import com.bawei.month1219.bean.RightResultBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/19
 *@Time:19:15
 *@Description功能: * */
public interface ApiService {
    @GET("commodity/v1/findCategory")
    Observable<LeftResultBean> show();

    //记住
    @GET("commodity/v1/findCommodityByCategory")
    Observable<RightResultBean> RightShow(@QueryMap Map<String,String> map);

    @GET("order/verify/v1/findShoppingCart")
    @Headers({"userId:10922","sessionId:157675479038510922"})
    Observable<GouWuResult> getGouWu();
}

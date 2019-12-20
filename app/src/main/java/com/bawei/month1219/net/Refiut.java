package com.bawei.month1219.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/19
 *@Time:19:37
 *@Description功能: * */
public class Refiut {
    public static Refiut refiut;
    public Retrofit retrofit;
    private Refiut(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/small/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .build()).build();
    }

    public static synchronized Refiut getInstance(){
        if (refiut==null){
            refiut=   new Refiut();
        }
        return refiut;




    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}

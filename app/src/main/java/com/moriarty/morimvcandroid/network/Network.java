package com.moriarty.morimvcandroid.network;

import android.os.Build;
import android.os.Environment;

import com.moriarty.morimvcandroid.app.BaseApplication;
import com.moriarty.morimvcandroid.network.api.AllCategoryApi;
import com.moriarty.morimvcandroid.network.api.WechatApi;
import com.moriarty.morimvcandroid.network.cookie.AddCookiesInterceptor;
import com.moriarty.morimvcandroid.network.cookie.ReceivedCookiesInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 网络请求框架
 */
public class Network {

    public static final String MOB_ROOT_URL = "http://apicloud.mob.com/";

    private static WechatApi mWechatApi;
    private static AllCategoryApi mAllCategoryApi;

    private static final long cacheSize = 1024 * 1024 * 20;// 缓存文件最大限制大小20M
    private static String cacheDirectory = Environment.getExternalStorageDirectory() + "/okttpcaches"; // 设置缓存文件路径
    private static Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
    private static final OkHttpClient cacheClient;

    static {
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别
        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        //builder.cookieJar(new CookieManger(BaseApplication.getInstance()));
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("User-Agent", "Kaizo")
                        .header("Accept", "application/vnd.yourapi.v1.full+json")
                        .header("deviceId", Build.SERIAL)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        builder.interceptors().add(new ReceivedCookiesInterceptor(BaseApplication.getInstance()));
        builder.interceptors().add(new AddCookiesInterceptor(BaseApplication.getInstance()));
        builder.connectTimeout(8, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(8, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(8, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        builder.cache(cache);// 设置缓存
        cacheClient = builder.build();
    }

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static AllCategoryApi getAllCategoryApi() {
        if (mAllCategoryApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(cacheClient)
                    .baseUrl(MOB_ROOT_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mAllCategoryApi = retrofit.create(AllCategoryApi.class);
        }
        return mAllCategoryApi;
    }

    public static WechatApi getWechatApi() {
        if (mWechatApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(MOB_ROOT_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mWechatApi = retrofit.create(WechatApi.class);
        }
        return mWechatApi;
    }


}

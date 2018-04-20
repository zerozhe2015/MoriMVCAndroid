package com.moriarty.morimvcandroid.network.api;


import com.moriarty.morimvcandroid.model.entities.AllCategoryBean;

import retrofit2.http.GET;
import rx.Observable;




public interface AllCategoryApi {
    @GET("wx/article/category/query?key=1cc099ede9137")
    Observable<AllCategoryBean> getAllCategory();
}

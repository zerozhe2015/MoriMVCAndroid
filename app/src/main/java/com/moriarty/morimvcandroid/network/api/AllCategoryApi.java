package com.moriarty.morimvcandroid.network.api;


import com.moriarty.morimvcandroid.model.entities.AllCategoryBean;

import retrofit2.http.GET;
import rx.Observable;

/*******************************************************************
 *    * * * *   * * * *   *     *       Created by OCN.Yang
 *    *     *   *         * *   *       Time:2018/1/19 16:32.
 *    *     *   *         *   * *       Email address:ocnyang@gmail.com
 *    * * * *   * * * *   *     *.Yang  Web site:www.ocnyang.com
 *******************************************************************/


public interface AllCategoryApi {
    @GET("wx/article/category/query?key=1cc099ede9137")
    Observable<AllCategoryBean> getAllCategory();
}

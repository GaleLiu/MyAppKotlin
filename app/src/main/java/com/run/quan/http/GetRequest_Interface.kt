package com.run.quan.http

import com.run.quan.http.bean.PicBean
import com.run.quan.http.bean.PicDetailBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/21
 */
interface GetRequest_Interface {

    @GET("api/v1/search/")
    fun getSearchCall():Call<PicBean>

    @GET("api/v1/w/{id}")
    fun getPicDetailCall(@Path("id") id:String):Call<PicDetailBean>
}
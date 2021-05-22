package com.run.quan.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/22
 */
class RetrofitHelper {
    companion object{
        @Volatile private var instance:RetrofitHelper?=null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: RetrofitHelper().also { instance = it }
            }
    }

    fun <T> helperGet(service:Class<T>) =
        Retrofit.Builder().baseUrl("https://wallhaven.cc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(service)
}
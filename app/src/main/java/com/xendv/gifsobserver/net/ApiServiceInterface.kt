package com.xendv.gifsobserver.net

import com.xendv.gifsobserver.common.Constants
import com.xendv.gifsobserver.dataClasses.Post
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("${Constants.DEV_LIFE_BASE_URL}random?json=true")
    fun getRandomPost(): Observable<Post>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.DEV_LIFE_BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}
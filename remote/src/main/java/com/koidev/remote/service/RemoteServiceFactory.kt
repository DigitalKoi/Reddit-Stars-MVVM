package com.koidev.remote.service

import com.google.gson.Gson
import com.koidev.remote.service.api.RedditApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteServiceFactory(client: OkHttpClient) {

    private val builder = Retrofit.Builder()
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(Gson()))

    fun buildRedditApi(baseUrl: String): RedditApi = builder
        .baseUrl(baseUrl)
        .build()
        .create(RedditApi::class.java)
}
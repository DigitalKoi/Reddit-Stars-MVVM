package com.koidev.remote.service.http

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpFactory {

    fun buildOkHttpClient(
        interceptors: List<Interceptor>,
        networkInterceptors: List<Interceptor>
    ): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)

        interceptors.forEach { interceptor -> builder.addInterceptor(interceptor) }
        networkInterceptors.forEach { interceptor -> builder.addNetworkInterceptor(interceptor) }

        return builder.build()
    }
}
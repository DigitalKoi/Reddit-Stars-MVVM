package com.koidev.remote.service.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiResponseInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        val response = chain.proceed(builder.build())

        // TODO: here need to implement error code

        return response
    }
}
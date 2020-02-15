package com.koidev.remote.service.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiRequestInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            val encodedPath = chain.request().url().encodedPath()
            // TODO: add headers here
        }

        return chain.proceed(builder.build())
    }

}
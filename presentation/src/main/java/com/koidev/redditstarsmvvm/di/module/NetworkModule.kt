package com.koidev.redditstarsmvvm.di.module

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.koidev.redditstarsmvvm.global.RedditApplication
import com.koidev.remote.service.RemoteServiceFactory
import com.koidev.remote.service.api.RedditApi
import com.koidev.remote.service.http.OkHttpFactory
import com.koidev.remote.service.interceptor.ApiRequestInterceptor
import com.koidev.remote.service.interceptor.ApiResponseInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule(
    private val redditBaseUrl: String
) {

    @Provides @Singleton
    fun provideRedditApi(factory: RemoteServiceFactory): RedditApi = factory
        .buildRedditApi(redditBaseUrl)

    @Provides @Singleton
    fun provideHttpClient(
        apiRequestInterceptor: ApiRequestInterceptor,
        apiResponseInterceptor: ApiResponseInterceptor
    ): OkHttpClient {

        val interceptors = listOf(
            apiRequestInterceptor,
            apiResponseInterceptor
        )

        val networkInterceptor = listOf(
            StethoInterceptor(),
            FlipperOkhttpInterceptor(RedditApplication.flipperNetworkPlugin)
        )

        return OkHttpFactory().buildOkHttpClient(
            interceptors = interceptors,
            networkInterceptors = networkInterceptor
        )
    }

    @Provides @Singleton
    fun provideResponseInterceptor(): ApiResponseInterceptor = ApiResponseInterceptor()

    @Provides @Singleton
    fun provideRequestInterceptor(): ApiRequestInterceptor = ApiRequestInterceptor()
}
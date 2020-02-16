package com.koidev.domain.proxy

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface Proxy<T> {
    fun intercept() : Observable<T>
    fun stream(strategy : BackpressureStrategy = BackpressureStrategy.LATEST) : Flowable<T>
    fun dispatch(update : T) : Completable
}
package com.koidev.domain.base

import io.reactivex.Single

abstract class StreamingSingleUseCase<T, in Params> {
    abstract fun buildUseCaseObservable(params: Params? = null): Single<T>
    open fun stream(params: Params? = null): Single<T> {
        return this.buildUseCaseObservable(params)
    }
}
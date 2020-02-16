package com.koidev.domain.base

import com.koidev.domain.executor.PostExecutionThread
import com.koidev.domain.proxy.Proxy
import io.reactivex.Completable

open class DispatchUseCase<T>(
    postExecutionThread: PostExecutionThread,
    private val proxy: Proxy<T>
) : CompletableUseCase<T>(postExecutionThread) {

    override fun buildUseCaseCompletable(params: T?): Completable {
        if (params == null) throw IllegalArgumentException("Argument can't be null")
        return proxy.dispatch(params)
    }
}
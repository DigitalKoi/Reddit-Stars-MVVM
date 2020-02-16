package com.koidev.domain.base

import com.koidev.domain.executor.PostExecutionThread
import com.koidev.domain.proxy.Proxy
import io.reactivex.Observable

open class InterceptUseCase<T>(
    postExecutionThread: PostExecutionThread,
    private val proxy: Proxy<T>
) : ObservableUseCase<T, Unit>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<T> {
        return proxy.intercept()
    }
}
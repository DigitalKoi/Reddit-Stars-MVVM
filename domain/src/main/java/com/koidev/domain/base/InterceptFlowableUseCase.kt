package com.koidev.domain.base

import com.koidev.domain.executor.PostExecutionThread
import com.koidev.domain.proxy.Proxy
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

open class InterceptFlowableUseCase<T>(
    postExecutionThread: PostExecutionThread,
    private val strategy : BackpressureStrategy,
    private val proxy: Proxy<T>
) : FlowableUseCase<T, Unit>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Flowable<T> {
        return proxy.stream(strategy)
    }
}
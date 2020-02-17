package com.koidev.redditstarsmvvm.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.jakewharton.rxrelay2.BehaviorRelay
import com.koidev.domain.interactor.GetRedditPosts
import com.koidev.domain.model.reddit.Reddit
import com.koidev.redditstarsmvvm.mvvm.common.ViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class RedditListViewModel (
    private val getRedditPosts: GetRedditPosts
): ViewModel() {

    private val subscriptions = CompositeDisposable()

    private val viewState by lazy { BehaviorRelay.create<ViewState<Reddit>>() }

    init {

        Timber.d("View model is created")

        getRedditPosts.execute(
            observer = GetRedditPostsSubscriber(),
            // TODO: add here pagination implementation
            params = 0
        )
    }

    fun observeViewState(): Observable<ViewState<Reddit>> = viewState

    // region INTERCEPTORS
    // endregion

    // region SUBSCRIBERS
    inner class GetRedditPostsSubscriber : DisposableSingleObserver<Reddit>() {

        override fun onStart() {
            super.onStart()
            viewState.accept(ViewState.Loading)
        }

        override fun onSuccess(reddit: Reddit) {
            // TODO: add here showing implementation
            viewState.accept(ViewState.Success(reddit))
        }

        override fun onError(e: Throwable) {
            viewState.accept(ViewState.Error(e.localizedMessage))
            Timber.e(e, "Error while loading reddit list")
        }
    }
    // endregion

    override fun onCleared() {
        Timber.d("onCleared")
        super.onCleared()
        getRedditPosts.dispose()
        subscriptions.clear()
    }
}
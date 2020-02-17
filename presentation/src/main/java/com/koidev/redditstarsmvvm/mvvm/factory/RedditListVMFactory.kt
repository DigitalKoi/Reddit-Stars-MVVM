package com.koidev.redditstarsmvvm.mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.koidev.domain.interactor.GetRedditPosts
import com.koidev.redditstarsmvvm.mvvm.viewmodel.RedditListViewModel

class RedditListVMFactory (
    private val getRedditPosts: GetRedditPosts
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RedditListViewModel(
        getRedditPosts
    ) as T
}
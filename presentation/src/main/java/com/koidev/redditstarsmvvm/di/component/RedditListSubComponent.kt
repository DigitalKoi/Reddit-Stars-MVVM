package com.koidev.redditstarsmvvm.di.component

import com.koidev.redditstarsmvvm.di.module.RedditListModule
import com.koidev.redditstarsmvvm.di.scope.RedditListScope
import dagger.Subcomponent

@RedditListScope
@Subcomponent(modules = [
    RedditListModule::class
])
interface RedditListSubComponent {
    // TODO: add inject method for fragment
//    fun inject(redditListFragment: RedditListFragment)
}
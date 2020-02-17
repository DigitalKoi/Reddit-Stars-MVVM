package com.koidev.redditstarsmvvm.navigation

import com.koidev.redditstarsmvvm.ui.fragment.RedditListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class RedditScreen : SupportAppScreen() {
        override fun getFragment() = RedditListFragment.newInstance()
    }
}
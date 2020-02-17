package com.koidev.redditstarsmvvm.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.koidev.redditstarsmvvm.R
import com.koidev.redditstarsmvvm.utils.RedditNavigator
import com.koidev.redditstarsmvvm.utils.componentManager
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val subscriptions by lazy { CompositeDisposable() }

    private val ciceroneNavigator by lazy {
        RedditNavigator(this, R.id.fragmentContainer)
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        injectDependencies()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(ciceroneNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.clear()
    }

    private fun injectDependencies() {
    }
}

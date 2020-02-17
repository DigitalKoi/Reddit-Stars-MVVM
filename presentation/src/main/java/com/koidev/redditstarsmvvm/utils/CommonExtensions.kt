package com.koidev.redditstarsmvvm.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.koidev.redditstarsmvvm.global.RedditApplication
import com.koidev.redditstarsmvvm.di.common.ComponentManager


fun Activity.componentManager(): ComponentManager {
    return (this.application as RedditApplication).getComponentManager()
}

fun Activity.hideKeyboard(focus: View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
        hideSoftInputFromWindow(focus.windowToken, 0)
    }
}

fun Activity.showKeyboard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
        toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}

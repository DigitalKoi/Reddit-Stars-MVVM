package com.koidev.redditstarsmvvm.utils

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class RedditNavigator(
    activity: FragmentActivity,
    containerId: Int,
    private val fragmentManager: FragmentManager
) : SupportAppNavigator(activity, fragmentManager, containerId) {

    constructor(
        activity: FragmentActivity,
        containerId: Int
    ) : this(
        activity,
        containerId,
        activity.supportFragmentManager
    )

    override fun applyCommand(command: Command?) {
        super.applyCommand(command)

//        fragmentManager.executePendingTransactions()
//
//        command ?: return
//
//        val fragment = when (command) {
//            is Replace  -> (command.screen as? SupportAppScreen)?.fragment
//            else        -> return
//        }
    }
}
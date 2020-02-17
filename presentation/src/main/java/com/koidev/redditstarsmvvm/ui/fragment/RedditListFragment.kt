package com.koidev.redditstarsmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.koidev.domain.common.disposedBy
import com.koidev.redditstarsmvvm.R
import com.koidev.redditstarsmvvm.mvvm.viewmodel.RedditListViewModel
import com.koidev.redditstarsmvvm.ui.BaseFragment

class RedditListFragment : BaseFragment() {

    private val vm by lazy {
        ViewModelProviders.of(requireActivity()).get(RedditListViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_reddit_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.apply {

            observeViewState().subscribe { state ->
                // TODO: implement here rendering view state
            }.disposedBy(subscriptions)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.clear()
    }

    override fun injectDependencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun releaseDependencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {

        fun newInstance(): RedditListFragment = RedditListFragment()

        private const val SCREENT_NAME = "RedditList"
    }
}
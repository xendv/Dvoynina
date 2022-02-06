package com.xendv.gifsobserver.mvp.presenter

import android.widget.Toast
import com.xendv.gifsobserver.application.App
import com.xendv.gifsobserver.dao.PostsDAO
import com.xendv.gifsobserver.dataClasses.Post
import com.xendv.gifsobserver.mvp.contract.MainContract
import com.xendv.gifsobserver.mvp.view.MainView
import com.xendv.gifsobserver.net.ApiServiceInterface
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    //private lateinit var section: String
    //private var pageCounter: Int = 0

    @Inject
    lateinit var mPostsDao: PostsDAO

    init {
        App.graph.inject(this)
    }

    fun loadNewPost() {
        val subscribe = api.getRandomPost().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ post: Post ->
                mPostsDao.savePost(post)
                viewState.showErrorMessage("" + mPostsDao.tempPost?.post?.gifURL + " " + mPostsDao.tempPost?.post?.description)
                viewState.updateView()
            }, { error ->
                viewState.showErrorMessage(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    fun onNextClick() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }


}
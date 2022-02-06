package com.xendv.gifsobserver.di.component

import com.xendv.gifsobserver.di.module.PostsDAOModule
import com.xendv.gifsobserver.mvp.presenter.MainPresenter

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PostsDAOModule::class))
interface AppComponent {
    //fun inject(application: App)
    fun inject(mainPresenter: MainPresenter)
}
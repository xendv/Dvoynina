package com.xendv.gifsobserver.application

import android.app.Application
//import com.activeandroid.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.xendv.gifsobserver.di.component.AppComponent
import com.xendv.gifsobserver.di.component.DaggerAppComponent
import com.xendv.gifsobserver.di.module.PostsDAOModule

class App: Application() {

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().postsDAOModule(PostsDAOModule()).build()
    }
}
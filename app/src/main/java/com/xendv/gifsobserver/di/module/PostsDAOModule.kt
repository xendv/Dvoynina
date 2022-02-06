package com.xendv.gifsobserver.di.module

import com.xendv.gifsobserver.dao.PostsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PostsDAOModule {
    @Provides
    @Singleton
    fun providePostsDao() : PostsDAO = PostsDAO()
}
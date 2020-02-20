package com.nanda.archmvvmdaggercoroutine.di.component

import com.nanda.archmvvmdaggercoroutine.di.module.NetworkModule
import com.nanda.archmvvmdaggercoroutine.view.PostListViewModel
import com.nanda.archmvvmdaggercoroutine.view.PostViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)
    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
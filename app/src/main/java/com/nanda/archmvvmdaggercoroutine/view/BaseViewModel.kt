package com.nanda.archmvvmdaggercoroutine.view

import androidx.lifecycle.ViewModel
import com.nanda.archmvvmdaggercoroutine.di.component.ApplicationComponent
import com.nanda.archmvvmdaggercoroutine.di.module.NetworkModule


abstract class BaseViewModel : ViewModel() {
    /*private val injector: ApplicationComponent = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }*/
}
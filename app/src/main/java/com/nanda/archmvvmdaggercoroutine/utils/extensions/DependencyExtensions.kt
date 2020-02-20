package com.nanda.archmvvmdaggercoroutine.utils.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nanda.archmvvmdaggercoroutine.di.ViewModelFactory

/**
 * Kotlin extensions for dependency injection
 */

inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

/*inline fun <reified T : ViewModel> FragmentActivity.viewModelProvider(viewModel: ViewModel) {
    return ViewModelProviders.of(this, ViewModelFactory(this)).get(viewModel)
}*/

/*
ViewModelProviders.of(this, ViewModelFactory(this))
            .get(PostListViewModel::class.java)
*/


package com.nanda.archmvvmdaggercoroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nanda.archmvvmdaggercoroutine.R
import com.nanda.archmvvmdaggercoroutine.di.ViewModelFactory
import com.nanda.archmvvmdaggercoroutine.utils.extensions.injectViewModel
import javax.inject.Inject

class PostActivity : AppCompatActivity() {
    private lateinit var viewModel: PostListViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(PostListViewModel::class.java)

        //viewModel = ViewModelProviders.of(this, factory).get(PostListViewModel::class.java)

        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.fl_main,
            PostLIstFragment()
        )
        transaction.commit()*/
    }
}

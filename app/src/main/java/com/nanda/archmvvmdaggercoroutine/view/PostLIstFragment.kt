package com.nanda.archmvvmdaggercoroutine.view


import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.nanda.archmvvmdaggercoroutine.R
import com.nanda.archmvvmdaggercoroutine.di.ViewModelFactory

import com.nanda.archmvvmdaggercoroutine.model.Post
import com.nanda.archmvvmdaggercoroutine.utils.extensions.injectViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PostLIstFragment : Fragment() {
    private lateinit var viewModel: PostListViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(PostListViewModel::class.java)*/

        //viewModel = injectViewModel(viewModelFactory)
    }

    public fun showPost(postList:List<Post>){

    }
}

package com.nanda.archmvvmdaggercoroutine.view

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.nanda.archmvvmdaggercoroutine.di.component.ViewModelInjector
import com.nanda.archmvvmdaggercoroutine.model.Post
import com.nanda.archmvvmdaggercoroutine.model.PostDao
import com.nanda.archmvvmdaggercoroutine.service.api.PostApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    val loading: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPostList() }

    private lateinit var subscription: Disposable

    init {
        loadPostList()
    }

    private fun loadPostList() {
        subscription = Observable.fromCallable { postDao.all }
            .concatMap { dbPostList ->
                if (dbPostList.isEmpty())
                    postApi.getPosts().concatMap { apiPostList ->
                        postDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart() {
        loading.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish() {
        loading.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList: List<Post>) {
        Log.d("NandaDebug", "success")
        Log.d("NandaDebug", "list: ${postList}")
    }

    private fun onRetrievePostListError() {

    }
}
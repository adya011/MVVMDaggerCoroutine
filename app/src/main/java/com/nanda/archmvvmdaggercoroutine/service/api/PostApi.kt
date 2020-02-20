package com.nanda.archmvvmdaggercoroutine.service.api

import com.nanda.archmvvmdaggercoroutine.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}
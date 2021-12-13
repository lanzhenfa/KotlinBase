package com.me.kotlinbase.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Create by lzf on 2021/12/13
 */
interface ApiService {

    @GET(value = "user/query")
    fun queryUser(@Query(value = "userId", encoded = true) userId: String): Call<UserResponse>

    @GET(value = "static/book/assets/study.json")
    fun getStudy(): Call<List<Course>>
}
package com.me.kotlinbase

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.me.kotlinbase.http.CommonOkHttp
import com.me.kotlinbase.retrofit.ApiService
import com.me.kotlinbase.retrofit.CommonRetrofit
import com.me.kotlinbase.retrofit.Course
import com.me.kotlinbase.retrofit.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        R.id.helloWorldTv.onClick(this) {
            println("click hello world")
        }

//        CommonOkHttp.get()
//        CommonOkHttp.getAsync()
//        CommonOkHttp.post()
//        CommonOkHttp.postAsync()
//        CommonOkHttp.postAsyncString()

        val apiService = CommonRetrofit.create(CommonRetrofit.BASE_URL, ApiService::class.java)
        //onFailure和onResponse的回调都是在主线程的
        apiService.queryUser("1600932269").enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(TAG, t.message ?: "unknow reason")
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                Log.e(TAG, response.body()?.toString() ?: "response is null")
            }
        })

        val apiService2 = CommonRetrofit.create(CommonRetrofit.BASE_URL2, ApiService::class.java)
        //onFailure和onResponse的回调都是在主线程的
        apiService2.getStudy().enqueue(object : Callback<List<Course>> {
            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                Log.e(TAG, t.message ?: "unknow reason")
            }

            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                Log.e(TAG, response.body()?.toString() ?: "response is null")
            }
        })
    }
}

fun Int.onClick(activity: Activity, click: () -> Unit) {
    activity.findViewById<View>(this).setOnClickListener {
        click()
    }
}
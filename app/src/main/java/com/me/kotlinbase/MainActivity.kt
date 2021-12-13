package com.me.kotlinbase

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.me.kotlinbase.http.CommonOkHttp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        R.id.helloWorldTv.onClick(this) {
            println("click hello world")
        }

        CommonOkHttp.get()
        CommonOkHttp.getAsync()
        CommonOkHttp.post()
        CommonOkHttp.postAsync()
        CommonOkHttp.postAsyncString()
    }
}

fun Int.onClick(activity: Activity, click: () -> Unit) {
    activity.findViewById<View>(this).setOnClickListener {
        click()
    }
}
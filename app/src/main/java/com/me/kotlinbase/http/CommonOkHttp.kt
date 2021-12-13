package com.me.kotlinbase.http

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Create by lzf on 2021/12/12
 */
object CommonOkHttp {

    private val TAG = "CommonOkHttp"
    private val BASE_URL = "http://123.56.232.18:8080/serverdemo"
    private val client: OkHttpClient

    init {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        client = OkHttpClient.Builder().//builder构造者设计模式
            connectTimeout(10, TimeUnit.SECONDS).//连接超时时间
            readTimeout(10, TimeUnit.SECONDS).//读取超时时间
            writeTimeout(10, TimeUnit.SECONDS).//写超时，也就是请求超时
//            addInterceptor(mHttpLoggingInterceptor).//拦截器
            addInterceptor(LoggingInterceptor()).//拦截器
            build()
    }

    //android 分为主线程和子线程
    //主线程就是App一启动，android framework层会启动一个线程，主线程（UI线程）
    //子线程 --new Thread().start()

    fun get() {//网络请求接口
        Thread(Runnable {
            //构造请求体
            val request = Request.Builder().url("$BASE_URL/user/query?userId=1600932269").build()
            //构造请求对象
            val call = client.newCall(request)
            //发起同步请求execute--同步执行，100ms、1000ms...
            val response = call.execute()
            val body = response.body?.string()
            Log.e(TAG, "get response:$body")
        }).start()
    }

    fun getAsync() {//网络请求接口
        //构造请求体
        val request = Request.Builder().url("$BASE_URL/user/query?userId=1600932269").build()
        //构造请求对象
        val call = client.newCall(request)
        //发起异步请求enqueue--异步执行，100ms、1000ms...
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "getAsync response onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                Log.e(TAG, "getAsync response:$body")
            }
        })
    }

    fun post() {//网络请求接口
        Thread(Runnable {
            val formBody = FormBody.Builder().add("userId", "1600932269").add("tagId", "71").build()
            //构造请求体
            val request = Request.Builder().url("$BASE_URL/tag/toggleTagFollow").post(formBody)
                .build()
            //构造请求对象
            val call = client.newCall(request)
            //发起同步请求execute--同步执行，100ms、1000ms...
            val response = call.execute()
            val body = response.body?.string()
            Log.e(TAG, "post response:$body")
        }).start()
    }

    /**
     * POST异步请求【表单提交】
     */
    fun postAsync() {//网络请求接口
        val formBody = FormBody.Builder().add("userId", "1600932269").add("tagId", "71").build()
        //构造请求体
        val request = Request.Builder().url("$BASE_URL/tag/toggleTagFollow").post(formBody)
            .build()
        //构造请求对象
        val call = client.newCall(request)
        //发起异步请求enqueue--异步执行，100ms、1000ms...
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "postAsync response onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                Log.e(TAG, "postAsync response:$body")
            }
        })
    }

    /**
     * POST异步请求【多表单文件上传】
     */
    fun postAsyncMultipart() {
        val file = File("")
        if (!file.exists()) {
            //文件不存在
            return
        }
        val requestBody = MultipartBody.Builder().addFormDataPart("key", "value").addFormDataPart(
            "server_file",
            "local_file",
            RequestBody.create("application/octet-stream".toMediaType(), file)
        ).build()
        val request = Request.Builder().url("接口需要支持文件上传才可以使用").post(requestBody).build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "postAsyncMultipart response onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                Log.e(TAG, "postAsyncMultipart response:$body")
            }
        })
    }

    /**
     * POST异步请求【提交字符串】
     */
    fun postAsyncString() {
        val json = "text/plain;charset=utf-8".toMediaType()
        val jsonObj = JSONObject()
        jsonObj.put("key1", "value1")
        jsonObj.put("key2", "value2")

        val textObj = "{username:admin,password:admin}"
        val textPlain = "text/plain;charset=utf-8".toMediaType()

        val requestBody =
//            RequestBody.create(json, jsonObj.toString())
            RequestBody.create(textPlain, textObj)
        val request = Request.Builder().url("$BASE_URL").post(requestBody).build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "postAsyncString response onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                Log.e(TAG, "postAsyncString response:$body")
            }
        })
    }
}
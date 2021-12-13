package com.me.kotlinbase.retrofit

import com.me.kotlinbase.http.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Create by lzf on 2021/12/13
 */
object CommonRetrofit {

    val BASE_URL = "http://123.56.232.18:8080//serverdemo/"
    val BASE_URL2 = "http://www.songyubao.com/"

    private val client = OkHttpClient.Builder().//builder构造者设计模式
        connectTimeout(10, TimeUnit.SECONDS).//连接超时时间
        readTimeout(10, TimeUnit.SECONDS).//读取超时时间
        writeTimeout(10, TimeUnit.SECONDS).//写超时，也就是请求超时
//            addInterceptor(mHttpLoggingInterceptor).//拦截器
        addInterceptor(LoggingInterceptor()).//拦截器
        build()

    fun <T> create(url: String, clazz: Class<T>): T {
        val retrofit =
            Retrofit.Builder().client(client).baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//数据转换适配器
                .build()
        return retrofit.create(clazz)
    }
}
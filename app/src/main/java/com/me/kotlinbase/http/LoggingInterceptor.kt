package com.me.kotlinbase.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer

/**
 * Create by lzf on 2021/12/12
 */
class LoggingInterceptor : Interceptor {

    private val TAG = "LoggingInterceptor"

    override fun intercept(chain: Interceptor.Chain): Response {
        val timeStart = System.nanoTime()

        val request = chain.request()
        val buffer = Buffer()
        request.body?.writeTo(buffer)
        val requestBody = buffer.readUtf8()
        Log.e(TAG, String.format("Sending request %s with params %s:", request.url, requestBody))

        val response = chain.proceed(request)
        val responseBody = response.body?.string() ?: "response body null"
        Log.e(
            TAG,
            String.format(
                "Receive response from %s in %.1fms >> %s",
                request.url,
                (System.nanoTime() - timeStart) / 1e6,
                responseBody
            )
        )

        //构造新的Response对象并返回
        val mediaType = response.body?.contentType()
        val newResponseBody = ResponseBody.create(mediaType, responseBody)
        return response.newBuilder().body(newResponseBody).build()
    }
}
package com.me.kotlinbase.retrofit

/**
 * Create by lzf on 2021/12/13
 */
data class UserResponse(
    val message: String,
    val status: String,
    val data: Data
)

data class Data(val data: User)

data class User(
    val avatar: String,
    val commentCount: Int,
    val description: String,
    val expires_time: Long,
    val favoriteCount: Int,
    val feedCount: Int,
    val followCount: Int,
    val followerCount: Int,
    val hasFollow: Boolean,
    val historyCount: Int,
    val id: Int,
    val likeCount: Int,
    val name: String,
    val qqOpenId: String,
    val score: Int,
    val topCommentCount: Int,
    val userId: Int
)
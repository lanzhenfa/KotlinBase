package com.me.kotlinbase

import java.lang.IllegalArgumentException

/**
 * Create by lzf on 2021/12/11
 * Kotlin 条件控制
 */
fun main() {

    println("maxOf:${maxOf(5, 10)}")

    eval(10)
    println("eval2:${eval2(10)}")
    println("eval3:${eval3()}")
}

fun maxOf(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxOf2(a: Int, b: Int): Int {
    //三目运算
    return if (a > b) a else b
}

fun eval(number: Number) {
    //如果是Int类型
    //is 是判断是否是某一种类型
    if (number is Int) {
        println("this is Int number")
    } else if (number is Double) {
        println("this is Double number")
    } else if (number is Float) {
        println("this is Float number")
    } else if (number is Long) {
        println("this is Long number")
    } else if (number is Byte) {
        println("this is Byte number")
    } else if (number is Short) {
        println("this is Short number")
    } else {
        throw IllegalArgumentException("invalid argument")
    }
}

//when 同样是带有返回值的
//when 将它的参数与所有的分支条件顺序比较，知道某个分支满足条件
fun eval2(number: Number): String = when (number) {
    200f -> "the number is 200f"
    is Int -> "this is Int number"
    is Double -> "this is Double number"
    is Float -> {
        println("check number is Float body")
        "this is Float number"
    }
    is Long -> "this is Long number"
    is Byte -> "this is Byte number"
    is Short -> "this is Short number"
    else -> "invalid argument"
}

fun eval3(): String = when (val value = getValue()) {
    200f -> "the number is 200f"
    is Int -> "this is Int number"
    is Double -> "this is Double number"
    is Float -> {
        println("check number is Float body")
        "this is Float number"
    }
    is Long -> "this is Long number"
    is Byte -> "this is Byte number"
    is Short -> "this is Short number"
    else -> "invalid argument"
}

fun getValue(): Any {//类似于java中的object
    return 100f
}
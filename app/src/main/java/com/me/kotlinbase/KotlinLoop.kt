package com.me.kotlinbase

/**
 * Create by lzf on 2021/12/11
 * Kotlin 循环控制
 */
fun main() {

    val items = listOf<String>("java", "kotlin", "android")
    //for-in
    for (item in items) {
        println("for in:$item")
    }
    //forEach
    items.forEach {
        println("forEach:$it")
    }
    //forEachIndexed
    items.forEachIndexed { index: Int, item: String ->
        println("forEachIndexed:$index -> $item")
    }

    //while循环
    //循环条件是否满足。
    //若满足，继续执行循环体；不满足则退出循环
    var index = 0
    while (index < items.size) {//while循环的遍历方式
        println("the $index element is ${items[index++]}")
    }

    //do-while先执行一次循环体，再看循环条件是否满足。
    //若满足，继续执行循环体；不满足则退出循环
    index = 0
    do {
        println("the $index element is ${items[index++]}")
    } while (index < items.size)

    //区间迭代器
    //遍历区间，注意Kotlin的区间的包含或是闭合的
    //for-in 左右闭合的区间[1,10]
    for (i in 1..10) {
        print("$i ")
    }
    println()
    //for in-until 不包含最后一个元素，左闭右开的区间[1,10)
    for (i in 1 until 10) {
        print("$i ")
    }
    println()
    //for in downTo 倒序
    for (i in 10 downTo 1) {
        print("$i ")
    }
    println()
    //for in downTo step 倒序且忽略步长的下标
    for (i in 10 downTo 1 step 2) {
        print("$i ")
    }
    println()
    for (i in 0..10) {
        if (i > 5) {
            break//终止循环
        }
        print("$i ")
    }
    println()
    for (i in 0..10) {
        if (i == 5) {
            continue//继续下一个循环，跳过本次循环
        }
        print("$i ")
    }
}
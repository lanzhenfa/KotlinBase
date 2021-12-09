package com.me.kotlinbase

import org.json.JSONObject

/**
 * Create by lzf on 2021/12/6
 * Kotlin数据容器：数组
 */
fun main() {

    //Kotlin数组
    //1.使用arrayOf创建数组，必须指定数组的元素，可以是任意类型
    val arrayNumber: Array<Int> = arrayOf(1, 2, 3, 4)
    //Kotlin中的Any 等价于 java中的Object对象
    val arrays: Array<Any> = arrayOf(1, true, "2"/*, JSONObject()*/)

    //2.使用arrayOfNulls创建空数组，
    //创建一个指定大小的，所有元素都为空的数组，但必须指定集合中的元素类型
    val arrayOfNulls: Array<String?> = arrayOfNulls<String>(5)
    arrayOfNulls[0] = "element1"
    arrayOfNulls[1] = "element2"
    arrayOfNulls[2] = "element3"
    arrayOfNulls[3] = "element4"
    arrayOfNulls[4] = null

    //3.利用array的构造函数，动态创建数组
    //创建一个Array<String> 初始化为["0","1","4","9","16"]
    //i = 0,1,2,3,4
    //i * i = "0","1","4","9","16"
    //数组创建的时候，会循环5次，i就是数组的下标
    //-> 右边的表达式的结果，就是数组中当前下标的元素
    val asc = Array(5) { i -> (i * i).toString() }

    //4.字节数组
    val bytes = ByteArray(5)
    bytes[0] = 0

    //5.使用IntArray创建整型数据数组
    //创建一个长度为5的空的IntArray
    val intArray = IntArray(5)
    //创建一个长度为5的空的IntArray
    val intArray2 = IntArray(5) { it * 2 }

    //数组是如何进行for循环遍历
    //依次取出数组中的元素，for-in的形式
    for (item in intArray2) {
        println(item)
    }

    //根据下标再取出对应位置的元素
    //for-in
    for (i in intArray2.indices) {
        println("$i -> ${intArray2[i]}")
    }

    //同时遍历下标和元素
    for ((index, item) in intArray2.withIndex()) {
        println("$index --> $item")
    }

    //forEach会依次回调给我们数组中的元素
    intArray2.forEach {
        println("forEach:$it") //it 代表的是数组的元素
    }

    //forEach增强版 会依次回调给我们数组中的下标和元素
    intArray2.forEachIndexed { index, i ->
        println("$index: $i")
    }
}
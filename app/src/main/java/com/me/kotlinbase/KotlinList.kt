package com.me.kotlinbase

/**
 * Create by lzf on 2021/12/9
 * Kotlin数据容器：集合
 * List：是一个有序列表，可通过索引（下标）访问元素。元素可以在list中出现多次、元素可重复。
 * Set：是元素唯一的集合。一般来说Set中元素的顺序并不重要、无序集合。
 * Map：（字典）是一组键值对。键是唯一的，每个键都刚好映射到一个值，值可以重复。
 */
fun main() {

    //列表的创建方式--可变列表
    val mutableList = mutableListOf<String>()
    mutableList.add("1")
    mutableList.add("2")
    mutableList.add("3")
    mutableList.add(3, "4")

    val mutableList2 = mutableListOf<String>("1", "2", "3")
    mutableList2.add("4")

    //列表的创建方式--不可变列表
    //必须指定元素类型
    //必须指定初始化数据元素
    val list = listOf<Int>(1, 2, 3)

    //Map字典的创建方式--可变字典
    val mutableMap = mutableMapOf<String, String>()
    mutableMap["1"] = "1"
    mutableMap["2"] = "2"
    mutableMap["3"] = "2"
    mutableMap["3"] = "3"//此时，会覆盖上面的记录

    //使用Pair指定集合中初始化的元素
    val mutableMap2 = mutableMapOf<String, String>(Pair("key", "value"))

    //Map字典的创建方式--不可变字典
    val mutableMap3 = mapOf<String, String>()//此时为空，不可动态添加、删除元素
    val mutableMap4 = mapOf<String, String>(Pair("key", "value"))

    //Set集合的创建方式--可变集合
    val mutableSet = mutableSetOf<String>()
    mutableSet.add("1")
    mutableSet.add("2")
    mutableSet.add("3")
    mutableSet.add("3")//添加不进去的
    for (item in mutableSet) {
        println(item)
    }

    val mutableSet2 = mutableSetOf<String>("1", "2", "3")
    mutableSet2.add("1")

    //Set集合的创建方式--不可变集合
    val mutableSet3 = setOf<String>("1", "2", "3")

    //下面的方法，同样适用于Map、Set
    val stringList = mutableListOf<String>("1", "2", "3", "4", "5", "2")
    println("inEmpty:${stringList.isEmpty()}")
    println("contains:${stringList.contains("6")}")
    println("get:${stringList[0]}")
    println("indexOf:${stringList.indexOf("4")}")//判断第一个元素在集合中的下标位置
    println("indexOf:${stringList.indexOf("6")}")//不在集合中，返回-1
    println("lastIndexOf:${stringList.lastIndexOf("2")}")//判断最后一个元素在集合中的下标位置
    stringList.iterator().forEach {
        println("it:${it}")
    }
    stringList.clear()//集合中的元素就会被清除，isEmpty = true
    println("size:${stringList.size}")
    stringList.add("7")//添加到最后面
    stringList[0] = "0"//修改下标对应的元素
    stringList.add(1, "7")//指定位置插入元素
    stringList.removeAt(0)

    val numberList = mutableListOf<Int>(1, 2, 3, 4)
    numberList.reverse()//集合元素翻转
    numberList.forEach {
        println("reverse:$it")
    }
    numberList.shuffle()//随机排列元素
    numberList.forEach {
        println("shuffle:$it")
    }
    numberList.sort()//按照从小到大排序
    numberList.forEach {
        println("sort:$it")
    }
    numberList.sortDescending()//按照从大到小排序
    numberList.forEach {
        println("sortDescending:$it")
    }
}
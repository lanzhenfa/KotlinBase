package com.me.kotlinbase

/**
 * Create by lzf on 2021/12/9
 * Kotlin Lambda表达式
 */
fun main() {

    //调用具有方法类型参数的方法
    val numbers = arrayOf(1, 2, 3, 4)
    //具名参数调用，即使用参数名action给它赋值
    transform(numbers, action = { index, element ->
        index * element //闭包中最后一行表达式，计算后的结果，就是action函数的返回值
    })
    numbers.forEach {
        println("transform:$it")
    }

    transform(numbers) { index, element ->
        index * element //闭包中最后一行表达式，计算后的结果，就是action函数的返回值
    }
    numbers.forEach {
        println("transform:$it")
    }

    //Lambda隐形参数it
    //并不是Kotlin中的一个关键字（保留字）
    //是在一个高阶方法中Lambda表达式的参数只有一个的时候可以使用it来使用此参数
    //可表示为单个参数的隐式名称，是Kotlin语言约定的
    numbers.forEach {
        println(it)
    }

    val list = arrayListOf<Int>(1, 2, 3, 4, 5, 6)
    list.forEachIndexed(action = { index, element ->
        println("forEachIndexed:$index->$element")
    })
    list.forEachIndexed { index, element ->
        println("forEachIndexed2:$index->$element")
    }
}

/**
 * Lambda表达式作为方法中的参数时，定义transform方法，可以对数组中的元素进行变换。
 * array：要求传入一个数组，元素类型为Int整型类型
 * action：要求传入的是一个方法，接收两个参数下标index，元素element，要求返回变化后的元素，会替换掉老的元素
 */
fun transform(array: Array<Int>, action: (index: Int, element: Int) -> Int) {
    for (index in array.indices) {
        val newValue = action(index, array[index])
        array[index] = newValue
    }
}
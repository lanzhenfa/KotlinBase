package com.me.kotlinbase

import java.lang.StringBuilder

/**
 * Create by lzf on 2021/12/9
 * Kotlin 方法
 */
fun main() {

    //普通类的成员方法声明与调用
    //需要先构建出实例对象，才能访问成员方法
    //实例对象的构建，只需要在类名后面加上()
    Person().test()
    Person.test2()

    //静态类里面的方法，都是静态方法
    //不需要构建实例对象，可以通过类名，直接访问静态方法
    val result = NumUtil.double(1)
    println("result:$result")

    //方法中的参数
    //默认参数
    read(2, 1)
    //具名参数
    read(start = 1)//仅仅给start传递值，使用默认值offset=0

    read(2, 1, action = {
        val result = 1 * 2
        //方法体的最后一行，就是该方法的返回值
        "括号内使用具名参数，传递action参数"
    })

    read(2, 1) {
        "括号外传递action参数"
    }

    val appendResult = append('1', '2', '3', '4')
    println("appendResult:$appendResult")

    val world = charArrayOf('w', 'o', 'r', 'l', 'd')
    val appendResult2 = append('h', 'e', 'l', 'l', 'o', ' ', *world, offset = 1)
    println("appendResult2:$appendResult2")
}

//普通类
class Person {
    fun test() {
        println("成员方法")
    }

    //在普通类里，定义静态方法
    //不需要构建实例对象，可以通过类名，直接访问静态方法
    companion object {
        fun test2() {
            println("静态方法")
        }
    }
}

//静态类
object NumUtil {
    fun double(num: Int): Int {
        return num * 2
    }
}

fun read(offset: Int = 0, start: Int) {
    println("read:$offset, $start")
}

/**
 * offset:int 默认值为0
 * start:int 没有默认值
 * 方法，参数名为action:()，返回值使用 -> 类型
 */
fun read(offset: Int = 0, start: Int, action: () -> String) {
    println("read:$offset, $start ${action()}")
}

//可变参数的要求：
//一个方法里，只有一个参数可以标注为 vararg
//如果vararg 参数不是最后一个参数，可以使用具名参数语法，给后面的参数传递值
fun append(vararg str: Char): String {
    val result = StringBuilder()
    for (char in str) {
        result.append(char)
    }
    return result.toString()
}

fun append(vararg str: Char, offset: Int): String {
    val result = StringBuilder()
    for (char in str) {
        result.append(char)
    }
    return result.toString()
}
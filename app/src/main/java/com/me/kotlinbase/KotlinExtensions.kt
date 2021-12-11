package com.me.kotlinbase

/**
 * Create by lzf on 2021/12/11
 * Kotlin 扩展方法
 * 原理：工具栏 Tools - Kotlin - ShowKotlinBytecode,
 * 点击Decompile，在生成的文件中找到扩展方法，可发现Java中调用方法时要传入类对象
 */
fun main() {

    Jump().test()
    Jump().doubleJump()

    val list = mutableListOf<Int>(1, 2, 3, 4)
    list.swap(0, 2)
    list.forEach {
        println("$it")
    }

    val android = "android"
    println("${android.lastChar}")

    Jump.print("为伴生对象的扩展")

    testLet("studio")
    testRun(Jump())
    //apply 内置扩展函数
    testApply()
}

class Jump {
    fun test() {
        println("jump test")
        //在被扩展的类中使用
        println("extensions:${doubleJump()}")
    }

    companion object {}
}

//扩展方法的定义，就是在方法的前面加上类前缀
fun Jump.doubleJump(): String = "double jump"

//泛型扩展方法
fun <T> MutableList<T>.swap(index: Int, index2: Int) {
    val temp = this[index]
    this[index] = this[index2]
    this[index2] = temp
}

//扩展属性
val String.lastChar: Char get() = this[this.length - 1]

//为伴生对象添加扩展
fun Jump.Companion.print(str: String) {
    println(str)
}

//let扩展函数: 实际上是一个作用域函数
//使用场景：
//1、当需要去定义一个变量在一个特定的作用域范围内
//2、可以避免写一些判断null的操作
//类后面加上？代表参数可能为空，使用的时候注意判空
fun testLet(str: String?) {
    //判空用法，当str为空，则不会触发闭包里面的逻辑
    str?.let {
        val str2 = "android"
        println("$str2 $it")
    }
    //println($str2)访问不到
}

//run扩展函数：只接收一个Lambda函数为参数，以闭包形式返回，
//返回值为最后一行的值或指定的return的表达式，在run函数中可以直接访问实例的共有属性和方法
fun testRun(jump: Jump): String {
    jump.run {
        //jump.test()
        test()
        println("test run")
        return "222"
    }
}

//apply扩展函数
//作用是：调用某对象的apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象
//从结构上看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样：
//run函数是以闭包形式返回最后一行代码的值
//apply函数返回的是传入的对象本身
fun testApply() {
    ArrayList<String>().apply {
        add("111")
        add("222")
    }.run {
        this.forEach {
            println("apply:$it")
        }
    }
}
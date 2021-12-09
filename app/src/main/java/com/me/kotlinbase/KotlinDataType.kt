package com.me.kotlinbase

/**
 * Create by lzf on 2021/12/6
 * Kotlin数据类型
 */
fun main() {

    //如何声明一个基本数据类型的变量，有哪些方式？
    //基本数据类型的整型默认数据类型均为Int，如果超过了Int的取值范围，则会推断为Long

    //编辑器会根据赋值【100】，推断变量number数据类型为Int
    val number = 100

    //虽然没有明确指定变量bigNumber的数据类型，
    // 但是编辑器根据赋值发现【8000000000】已经超过了Int的最大值
    //所以bigNumber的数据类型会升级为Long
    val bigNumber = 8000000000

    //在赋值的数字的后面加上L，会自动推断为Long类型
    val longNumber = 20L

    //在变量的后面加上: 数据类型
    val byteNumber: Byte = 1

    //浮点类型
    //编辑器同样会根据赋值推断变量的类型
    val doubleNumber = 3.1415928888
    val floatNumber = 3.1415928888f

    println("floatNumber:$floatNumber")
    println("doubleNumber:$doubleNumber")

    //字符类型
    //字符的赋值用单引号
    val char: Char = '0'

    //布尔类型，使用Boolean来声明类型，只有两种值true/false
    val isVisible: Boolean = false//true
    val isVisible2 = true

    //字符串类型
    val str = "1234567890"
    //字符串的取值
    val strNumber2 = str[0]
    //字符串的模板表达式 以$开始
    println("The result is $str")
    println("The length is ${str.length}")
    //字符串的拼接操作
    println("I am ${18} years old!")
    //字符转义 \n换行符
    val helloWorld = "Hello, world!\n"
    println("$helloWorld\n how are you")

    //jsonStr要求它的字符串内容是json格式
    val jsonStr = "{\"key\", \"value\"}"
    //"""分界符，字符串内容无需转义
    val jsonStr2 = """
        |Tell me and I forget.
        ||Teach me and I remember.
        |{"key1","value1"}
        |{"key2","value2"}
        """.trimMargin()

    //数据类型间的强制转化
    val number100 = 100//声明一个整型 number对象
    println("转化为string：${number100.toString()}")
    println("转化为string：${number100.toLong()}")

    //数据类型的加减乘除
    //在计算机中整数除以整数，结果是整数，小数点会被抹掉
    val numberInt = 3 / 2
    println("numberInt：$numberInt")//输出 1

    //整数除以小数，结果是小数
    val numberDouble = 3 / 2.toDouble()
    println("numberDouble：$numberDouble")//输出 1.5

    println("乘法：${numberInt * numberDouble}")
    println("取余：${3 % 2}")//输出 1

    //位运算
    val vip = true
    val admin = false
    //与操作，要求两个都满足，结果才会为true
    val result = vip.and(admin)

    //或操作，只要一个条件是true，结果才会为true
    val result2 = vip.or(admin)

    //无符号右移
    //0000 10000  ---> 0000 0010 = 2
    val result3 = 8 ushr (2)
    println("result:$result")
    println("result2:$result2")
    println("result3:$result3")
}
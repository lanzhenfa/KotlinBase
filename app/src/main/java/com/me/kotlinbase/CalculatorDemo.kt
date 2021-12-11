package com.me.kotlinbase

import kotlin.system.exitProcess

/**
 * Create by lzf on 2021/12/11
 * Kotlin 使用基础知识实现四则运算表达式的Demo
 */
fun main() {

    while (true) {
        println("========请输入您的表达式========")
        val input: String? = readLine()
        try {
            input?.let {
                val ret = calculate(input)
                println("$input=$ret")
                println("是否继续使用（y/n）")
                val cmd: String? = readLine()
                cmd?.let {
                    if (it == "n") {
                        exitProcess(-1)
                    } else {
                        //继续使用程序
                    }
                }
            }
        } catch (e: Exception) {
            println("exception:${e.message}")
            break
        }
    }
}

fun calculate(input: String): String {
    //1+2
    //1-2
    //1/2
    //1*2
    if (input.contains("+")) {
        val numbers = input.trim().split("+")
        return operate("+", numbers[0].toDouble(), numbers[1].toDouble()).toString()
    } else if (input.contains("-")) {
        val numbers = input.trim().split("-")
        return operate("-", numbers[0].toDouble(), numbers[1].toDouble()).toString()
    } else if (input.contains("*")) {
        val numbers = input.trim().split("*")
        return operate("*", numbers[0].toDouble(), numbers[1].toDouble()).toString()
    } else if (input.contains("/")) {
        val numbers = input.trim().split("/")
        return operate("/", numbers[0].toDouble(), numbers[1].toDouble()).toString()
    } else {
        return "您输入的表达式有误！"
    }
}

fun operate(operate: String, num1: Double, num2: Double): Double {
    return when (operate) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> 0.0
    }
}
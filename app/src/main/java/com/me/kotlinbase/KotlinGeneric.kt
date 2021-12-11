package com.me.kotlinbase

import org.json.JSONObject

/**
 * Create by lzf on 2021/12/11
 * Kotlin 泛型
 */
fun main() {

    //1.泛型接口
    val drinkApple = DrinkApple()
    drinkApple.drink("apple")

    //2.泛型类
    val blueColor = BlueColor("blue")
    blueColor.printColor()

    //3.泛型方法
    fromJson<String>("""{key, value}""", String::class.java)

    //4.泛型约束
    fromJson1<JSONObject>("""{key, value}""", JSONObject::class.java)
    fromJson2<User>("""{key, value}""", User::class.java)
}

interface Drink<T> {
    fun drink(t: T/*泛型字段*/)
}

class DrinkApple : Drink<String> {
    override fun drink(t: String) {
        println("drink:$t")
    }
}

abstract class Color<T>(val t: T/*泛型字段*/) {
    abstract fun printColor()
}

class BlueColor(val color: String) : Color<String>(color) {
    override fun printColor() {
        println("color:$color")
    }
}

fun <T> fromJson(json: String, tClass: Class<T>): T? {
    val instance: T? = tClass.newInstance()
    return instance
}

//泛型类型限定-1
//所有的类型T必须满足是JSONObject的子类 或 JSONObject类
fun <T : JSONObject> fromJson1(json: String, tClass: Class<T>): T? {
    val instance: T? = tClass.newInstance()
    return instance
}

//泛型类型限定-2
//所有的类型T必须同时满足where子句的所有条件
//在下面的示例中，类型T必须实现了JSONObject，也实现了Comparable
fun <T> fromJson2(json: String, tClass: Class<T>): T? where T : JSONObject, T : Comparable<T> {
    val instance: T? = tClass.newInstance()
    return instance
}

class User : JSONObject(), Comparable<User> {
    override fun compareTo(other: User): Int {
        return 0
    }
}

open class Animal
class Dog : Animal()
class Cat : Animal()
class WhiteDog : Animal()

fun animalFuns() {
    //使用处使用out关键字声明--泛型上限
    //传入的泛型参数可以是Animal及Animal的子类Dog、Cat、WhiteDog...
    val animalList: ArrayList<out Animal> = ArrayList<Dog>()
    val animalList2: OutArrayList<Animal> = OutArrayList<Dog>()

    //使用处使用in关键字声明，约定泛型下限
    //允许传入的泛型类型是Dog及其Dog的父类Animal..
    val animalList3: ArrayList<in Dog> = ArrayList<Animal>()
    val animalList4: InArrayList<Dog> = InArrayList<Animal>()
}

//定义处使用out关键字声明，允许传入的泛型参数可以是T以及T的子类
open class OutArrayList<out T>

//定义处使用in关键字声明，允许传入的泛型参数可以是T以及T的父类
open class InArrayList<in T>
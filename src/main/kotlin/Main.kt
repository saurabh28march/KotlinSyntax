fun main() {
    println(divByFive(10))
    printList()
    conditionals()
    whenBlock()
}

private fun conditionals(): Unit {
    // 'if' is an expression in Kotlin that means it returns a value
    // last statement of if and else block is the returned value
    val num1 = 4
    val num2 = 5
    val result = if (num1 < num2) {
        val sum = num1 + num2
        "Lesser"
    } else {
        val diff = num1 - num2
        "Greater"
    }
    println("result is $result")

    val result1 = if (num1 > num2) "$num1" else "$num2"
    //{ ternary operator is not present in kotlin, if else works fine}
    println("result1 is $result1")
}

private fun whenBlock() {

    //similar to switch case in Java
    // It can be used as an expression - returns value
    // It can also be used as a statement

    //else condition is necessary when returning a value otherwise we can skip it if default case is not needed
    //add two or more conditions by a ','
    //check in side a collection, particular value , type
    val list = listOf<Any>("34", 56, "A", "c")
    var inputValue: Any = 56
    when (inputValue) {
        is String -> println("is a string")
        20 -> println("is  Number 20")
        !is Int -> {
            println("is an Int")
        }
        in list -> {
            println("present in list")
        }
        in 1..30 -> {
            println("between 1 and 30")
        }
        40, 50 -> {
            println("is either 40 or 50")
        }
        "90".toInt() -> {
            println("is 90")
        }
        else -> println("default case")
    }

    // when using when as an expression
    // enum , sealed classes
    val value = Vehicle.BIKE
    val res = when (value) {
        Vehicle.CAR -> {
            "car"
        }
        Vehicle.BIKE -> {
            "bike"
        }
    }
    println(res)
    // if not covering all cases , then we have to include else branch

}

enum class Vehicle {
    BIKE, CAR
}


private fun divByFive(num: Int): Boolean {
    return num % 5 == 0
}

// result as an expression
/**
private fun divByFive(num: Int) = num%5 == 0
private fun divByFive(num: Int) = if(num%5 == 0) true else false
 */

//Iteration
fun printList() {
    val list = listOf<Int>(1, 2, 34, 65, 33)
    for (element in list) {
        println(element)
    }

    for (index in list.indices) {
        println(index)
    }


    // 1..4 -> 1<=element<=4
    // 1 until 4  -> 1<=element<4

    if (1 !in list)
        println("not present")
    else
        println("present")

    for (i in 1..5) {
        println(i)
    }

    for (i in (1..6).reversed()) {
        println(i)
    }

    println((1..10).filter { it % 3 == 0 })

    for (i in 10 downTo 4 step 3)
        println(i)

    for ((index, value) in list.withIndex())
        println("$index and $value")

    list.forEachIndexed { index, i ->
        println("element $i is present at index = $index")
    }

    // first it checks the condition then executes
    var itr = 0
    while (itr < list.size) {
        println(list[itr])
        itr++
    }

    //run at least once,first it executes then it checks the condition
    do {
        val info = getInfo()
        println(info)
    } while (info.isEmpty())

}

fun getInfo(): String {
    return "Some Data..."
}
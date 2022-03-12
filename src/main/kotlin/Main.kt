import kotlin.math.exp
import kotlin.math.sqrt

/**
 * functions are declared with fun keyword
 * */

fun main() {
    println(square(45))
    println(square1(45))
    println(square2(45))


    println(power(exp = 3))
    println(power(base = 4, exp = 5))
    lambda(3) { power(4, 7) }

    //higher order functions
    println(demo(2, 3, "demoString") { x: Int, str: String -> x.toString() + str })

    //extension function
    println("demo".modify())

    getList("A", "B", "c")
    getList(*arrayOf<String>("A", "V", "T")) // using spread operator '*'
}

private fun square(num: Int): Int {
    return num * num
}

// single block - omit return
private fun square1(num: Int): Int = num * num

// return type can be inferred by the compiler
private fun square2(num: Int) = num * num

// using default arguments and named arguments
private fun power(base: Int = 2, exp: Int): Int {
    var res = 1
    for (i in 1..exp) {
        res *= base
    }
    return res
}

//if last argument in a fun is a lambda then it could be passed as an argument or can be taken out of function
fun lambda(num: Int, x: () -> Int) {
    println(x.invoke())
}

//vararg and spread operator

fun getList(vararg string: String) {
    for (i in string) println(i)
}

//tailrec optimizes the code as we have in traditional for loops
tailrec fun squareRoot(x: Double) {
    if (x < 1E-12) {
        return;
    }
    squareRoot(sqrt(x));
}

//higher order functions -> which takes or return a lambda
fun demo(x: Int, y: Int, str: String, task: (Int, String) -> String) = task.invoke(x + y, str)

////extension function
fun String?.modify(): String {
    return (this + this ?: -1).toString()
}


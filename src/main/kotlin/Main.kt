/**
entry point of application is Main function
 **/

fun main(){
    printSomething()
    println( addTwoNumbers(67,89))
    println(returnNothing(45,23))
}

//another Form with arguments
//fun main(args : Array<String>){
//    println("${args.contentToString()}")
//}

/**
 *println() and print()
 * println() -> moves to the next  line after printing
 * print() -> stays on the same line after printing
 **/

fun printSomething(){
    print(4)
    print(5)
    println()
    println(4)
    println(5)
}

/**
 * Functions - performs a task may return or may not return a value
 * */

// primary way
fun addTwoNumbers(num1: Int,num2 :Int) : Int{
    return  num1+num2
}

// shorter way
fun shorterWay(num1: Int,num2 :Int) = num1 + num2

// return nothing
fun returnNothing(num1 :Int,num2:Int) {
    println(num1-num2)
}

/**
 * val vs var
 * val - assigned only once
 * var - can be assigned many times
 * */
val x : Int= 3
var y :String = "Kotlin"








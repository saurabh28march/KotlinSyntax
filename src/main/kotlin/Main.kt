fun main() {
    val obj = Vehicle("car", "aaaaaaaa", "red")
    println("${obj.type} ${obj.modelNo} ${obj.color}")

    val obj1 = Vehicle("bike", "bbbbbb", "yellow")
    println("${obj1.type} ${obj1.modelNo} ${obj1.color}")
    println(obj1.params)

    //string templates
    val string1 = "value of string1 is ${obj.type}"
    println(string1)
}

class Vehicle(val type: String,val modelNo: String, val color: String){
    val params = type+modelNo+color
}

// inheritance -> all classes are final by default , to inherit them use open keyword
open class Transport(val params : String)
class Bike(bikeParams : String) : Transport(params = bikeParams){
}

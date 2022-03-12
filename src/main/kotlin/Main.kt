fun main() {
    val obj = Vehicle("car", "aaaaaaaa", "red")
    println("${obj.type} ${obj.modelNo} ${obj.color}")

    val obj1 = Vehicle("bike", "bbbbbb", "yellow")
    println("${obj1.type} ${obj1.modelNo} ${obj1.color}")
    println(obj1.params)

    //string templates
    val string1 = "value of string1 is ${obj.type}"
    println(string1)

    //data class - use to store data
    val user1 = User("User1", 45)
    val user2 = User("User2", 34)

    println("user1 = $user1 and user2 = $user2")

    //enum class - distinct set of values (limited values)
    val v1 = Vehicles.CAR
    println(v1.color)

    //sealed classes - to restrict inheritance in other classes
    val humans: Humans = Humans("Name", 23)

    //singleton
    val x = Abc.age
    println(x)

    //companion object are declared inside a class , when we want static behaviour in our class
    /**
     * companion object Abc{
     *   fun getInstance(){
     *    // some implementation
     *   }
     * }
     * */


}

object Abc {  //lazily initialized when this object is called
    val name: String = "Name"
    val age: Int = 27
}

class Vehicle(val type: String,val modelNo: String, val color: String){
    val params = type+modelNo+color
}

// inheritance -> all classes are final by default , to inherit them use open keyword
open class Transport(val params : String)
class Bike(bikeParams : String) : Transport(params = bikeParams){
}

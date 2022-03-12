sealed class Mammals(val name: String)

class Animals(name: String) : Mammals(name) {

}

class Humans(name: String, age: Int) : Mammals(name) {

}



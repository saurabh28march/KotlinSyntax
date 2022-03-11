/**
 * Null safety - accessing member of Null reference leads to NPE
 * ? - for Nullable value
 * ?. - null safety operator
 * */


fun main() {
    nullSafety()
}

private fun nullSafety() {

    var name: String? = "Name"
    if (System.currentTimeMillis().mod(2) == 0) {
        name = null
    }
    //null safety
    println(name?.length)  // -> if name is null , then whole result becomes null

    //using let keyword
    name?.let {
        println(it.length)
    }

    //checking value as null
    if (name != null) println(name.length)

    //Elvis Operator ?: -> if expression becomes null then return right side expression
    val res = name?.length ?: -5  //-> if(name != null) b.length else -5
    println(res)

    //non-null assertion operator (!!) , not preferred to use , may give NPE for if value was null
    val anotherName = name!!  //gives NPE if name is null
    println(anotherName)

    //Safe Cast :
    val key = 3
//    val x : String = key as String     //gives Class Cast exception

    val y = key as? String // returns null if key is not of String type , not exception

    //filtering not null values
    val list = listOf<String?>("A", "S", "D", null, "V").filterNotNull()
    println(list)

    /**
     * Type checks - to check if the element is of Specific type - use 'is' operator
     * */

    var x1: Any = "SomeString"
    x1 = 5
    if (x1 is String) {
        // perform any operation on x related to String
    } else {
        //not a string
    }

    if (x1 !is String) {
        //not a string
    } else {
        //perform any operation on a string
    }
}
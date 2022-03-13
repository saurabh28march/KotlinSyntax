/**
 * let
 * run
 * with
 * apply
 * also
 * */

data class User(
    val name: String,
    var age: Int,
    var address: String,
    val email: String?
) {

    fun getDetails(): String {
        return "details......."
    }

}

fun main() {

    /**
     * let
     * - acts on object and object can be accessed by it keyword
     * - for null safe checks - to avoid accessing objects that are null
     * - returns the last expression as result from let block
     * */
    val user = User(
        name = "user1",
        age = 45,
        address = "address.....",
        email = "aaaaa@gmail.com"
    )
    println(user)
    val user1 = user.let {
        it.age = 56
        it.address = "new address...."
        it
    }
    println(user)
    println(user1)

    val user2: User? = null
    user2?.let {
        // null safe check
    }

    //for 2 consequent null safe checks -

    user2?.let { user ->
        user.email?.let { email ->
            // code
        }
    }

    /**
     * run
     * - same as let
     * - object is accessed by 'this' keyword
     * - used when we want to call member function on that object
     * */

    val res1 = user.run {
        age = 78
        getDetails()
    }
    println(user)
    println(res1)


    /**
     * with
     * - omit this keyword while referring object
     * */

    with(user) {
        age = 67
        getDetails()
    }
    println(user)
    println(res1)

    /**
     * apply
     * - object refer by this
     * - this is used for initializing the object property
     * - returns the object itself
     * - can chain other operations with apply because return value is object
     * */

    val res2 = user.apply {
        age = 90
        address = "some address ...."
    }

    //same object is returned
    println(user.hashCode())
    println(res2.hashCode())
    println(res2.getDetails())

    /**
     * also
     * - same as apply
     * - returns the same object
     * - object refer by it
     * - used when passing object itself in another function
     * */

    val res3 = user.also {
        getUser(it)
    }

    println(res3 === user)
}

fun getUser(user: User) {
    // code
}




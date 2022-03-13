fun main() {
    collections()
    functionsInCollection()
}

private fun collections() {
    /**collections -> DataStructures that holds some value / objects
    - List , Set , Map (Dictionary)*/

    //Collections -> Mutable(read,remove,add,update) , Non Mutable (only read operations)

    //Non Mutable List
    val nonMutableList = listOf<Int>(1, 3, 6, 63, 3, 2, 4, 4)
    for (i in nonMutableList) print("$i ")

    println()

    for (index in nonMutableList.indices) {
        print("${nonMutableList[index]} ")
    }

// nonMutableList[0] = 5 -> wrong , cannot update the value

    /**
     * can duplicate elements in List including null
     * */
    //Mutable List = Non Mutable List + write operations
    val mutableList = mutableListOf<Int>(1, 3, 6, 63, 3, 2, 4, 4)

    mutableList.add(56)
    mutableList[3] = 89
    mutableList.removeAt(1)

    println()
    for (i in mutableList) print("$i ")

    /**
     * Set -> mutable and non mutable
     * mutable -> write operations
     * non mutable -> read only
     * */
    println()
    val nonMutableSet = setOf<Int>(1, 3, 3, 3, 34, 7, 5, 3) // contains only unique value including null
    for (i in nonMutableSet) print("$i ")

    println()
    val mutableSet: HashSet<Int> = HashSet(
        listOf(
            1,
            3,
            3,
            3,
            34,
            7,
            5,
            3
        )
    ) // do not preserve the order of insertion, it is fast and takes less space
//    val mutableSet = mutableSetOf<Int>(1, 3, 3, 3, 34, 7, 5, 3)  // preserve the order , slow
    mutableSet.add(67)
    mutableSet.remove(1)
    for (i in mutableSet) print("$i ")

    /**
     * Map<K,V> -> params are key and value { key -> value }
     * mutable and non mutable map
     * */


    val nonMutableMap = mapOf<String, Int>("first" to 1, "second" to 2, "fifth" to 5)
    println()
    for (i in nonMutableMap.keys)
        print("$i ")

    println()
    for (i in nonMutableMap.values)
        print("$i ")

    println()
    for ((key, value) in nonMutableMap.entries)
        print("$key $value ")

    //Mutable Map
    val mutableMap = mutableMapOf<String, Int>("first" to 1, "second" to 2, "fifth" to 5)
    mutableMap["first"] = 76
    mutableMap["seven"] = 7
    mutableMap.put("fifth", 56)
    println()
    for (i in mutableMap.keys)
        print("$i ")

    println()
    for (i in mutableMap.values)
        print("$i ")

    println()
    for ((key, value) in mutableMap.entries)
        print("$key $value ")
}

private fun functionsInCollection() {

    println()
    val list = listOf<Int>(1, 3, 34, 234, 324, 23, 2112, -12, -9, 3, -2)

    //filter - filters out the result which satisfy the condition given in lambda
    var x = list.filter { it > 4 }
    println(x)

    x = list.filter { it < 0 }
    println(x)

    x = list.filter { element -> element > 0 }
    println(x)

    //map - transforms the result
    x = list.map { it / 4 }
    println(x)

    //all , any , none
    //all -> returns true  if all elements  satisfy the condition
    //any -> returns true  if any elements  satisfy the condition
    //none -> returns true  if no element  satisfy the condition

    var res = list.any { it > 4 }
    println(res)

    res = list.all { it > 4 }
    println(res)

    res = list.none { it == 0 }
    println(res)

    //find -> return last element which satisfy the condition else null
    //findLast -> return last element which satisfy the condition else null

    var element = list.find { it > 5 }
    println(element)

    element = list.findLast { it < 0 }
    println(element)

    element = list.findLast { it > 3000 }
    println(element)

    //first -> return first element which satisfy the condition else NoSuchElementException
    //last -> return last element which satisfy the condition else NoSuchElementException
    //firstOrNull -> return first element which satisfy the condition else null
    //lastOrNull -> return first element which satisfy the condition else null

    try {
        val num = list.first { it > 3000 }
    } catch (e: NoSuchElementException) {
        // handle exception
        println("got the exception")
    }

    val num = list.firstOrNull { it > 3000 }
    println(num)

    //count -> count total no of elements in a collection
    var c = list.count() // total
    println(c)

    c = list.count { it > 5 }
    println(c)

    //associateBy -> returns a map according to key selector and value selector
    //if value selector not provided then take corresponding entity as value
    //value is the last matched value in the list

    val names = listOf<User>(
        User("user1", 34, "aaaaa@gmail.com"),
        User("user2", 35, "bbbbbb@gmail.com"),
        User("user3", 36, "ccccc@gmail.com"),
        User("user4", 37, "dddddd@gmail.com"),
        User("user5", 34, "aaaaa@gmail.com"),
        User("user6", 35, "bbbbbb@gmail.com"),
    )

    var mapResult = names.associateBy { it.emailId }
    println(mapResult)

    var mapResult1 = names.associateBy(User::name, User::emailId)
    println(mapResult1)

    //groupBy -> maps key selector to list of elements satisfying the condition
    var mapResult3 = names.groupBy { it.emailId }
    println(mapResult3)

    var mapResult4 = names.groupBy(User::emailId, User::name)
    println(mapResult4)


    //partition -> splits the result into 2 half
    //first -> which satisfy the condition
    //second -> which do not satisfy the condition

    val res1 = list.partition { it > 0 }
    println(res1)

    val (pos, neg) = list.partition { it > 0 } //destructuring
    println(pos)
    println(neg)

    val list1 = listOf<String>("user1", "user2", "user3")
    val list2 = listOf<String>("user4", "user5", "user6")
    val list3 = listOf(list1, list2)
    val mapUser = list3.map { it }
    println(mapUser)
    val flatMap = list3.flatMap { it } // flattens the collection into single list of elements
    println(flatMap)

    // minOrNull -> if list is empty it returns null else min from list
    // maxOrNull ->  if list is empty it returns null else max from list
    println(list.minOrNull())
    val demoEmptyList = listOf<Int>()
    println(demoEmptyList.maxOrNull())

    //sortedBy -> sorted in ascending order defined by selector function
    //sortedByDescending  -> in desc order
    println(list.sortedBy { it })
    println(list.sortedByDescending { it })
    println(names.sortedByDescending { it.age })

    // Accessing Map
    // getValue() -> returns NoSuchElementException when key is invalid
    // [] -> return null if key is invalid

    val map1 = mapOf("user1" to 1, "user2" to 2, "user3" to 3)
    println(map1["user1"])
    println(map1["user4"])
    println(map1.getValue("user1"))
    try {
        val ele = map1.getValue("user4")
    } catch (e: NoSuchElementException) {
        println("got the exception")
    }

    //zip function -> merges 2 collection as pairs by default else returns result according to given condition
    //size is same as shorter collection
    val x1 = listOf(1, 4, 2, 5, 0, 6, 7, 8)
    val x2 = listOf(5, 6, 7, 8, 9, 10, 7, 8, 89, 89, 56)

    val resultZip = x1 zip x2
    println(resultZip)

    val resultZip1 = x1.zip(x2) { x, y -> x + y }
    println(resultZip1)

    //getOrElse -> get the value at index else return the default value provided
    //provides safer access to collection
    println(map1.getOrElse("user1") { 0 })
    println(map1.getOrElse("user4") { 89 })
    println(list.getOrElse(78) { null })

}

data class User(
    val name: String,
    val age: Int,
    val emailId: String
)
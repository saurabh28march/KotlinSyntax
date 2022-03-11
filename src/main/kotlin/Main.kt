fun main() {
    collections()
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
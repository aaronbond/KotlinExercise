package main.kotlin

import OwnerSorter
import service.WebService

fun main(args: Array<String>) {
    val service = WebService()

    //This is run synchronously
    val response = service.getOwners().execute()
    val sorter = OwnerSorter()

    if (response.isSuccessful) {
        println("\nMale")
        sorter.sortCatsByOwnerGender(response.body()!!, "Male").map { println("\t${it.name}") }
        println("\nFemale")
        sorter.sortCatsByOwnerGender(response.body()!!, "Female").map { println("\t${it.name}") }
    } else {
        //handle error case here
        println("Error reaching API")
    }
}
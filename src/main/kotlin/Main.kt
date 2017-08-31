package main.kotlin

import service.WebService

fun main(args: Array<String>) {
    println("kotlin!")

    val service = WebService()
    val response = service.getOwners().execute()

    if(response.isSuccessful) {
        response.body()?.map { print(it) }
    }
}
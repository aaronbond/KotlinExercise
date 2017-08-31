package service

import main.kotlin.model.Owner
import retrofit2.Call
import retrofit2.http.GET

interface WebApi {
    @GET("/people.json")
    fun getOwners(): Call<ArrayList<Owner>>
}
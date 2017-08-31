package service

import main.kotlin.model.Owner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebService {

    val webApi : WebApi

    init {
        val retrofit = Retrofit
                .Builder()
                .baseUrl("http://agl-developer-test.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        webApi = retrofit.create(WebApi::class.java)
    }

    fun getOwners() : Call<ArrayList<Owner>> {
        return webApi.getOwners()
    }
}
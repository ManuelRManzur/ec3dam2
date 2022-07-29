package com.rmanzur.ec3

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val client=OkHttpClient.Builder().build()

    private val retrofit=Retrofit.Builder()
        .baseUrl("https://62e3453eb54fc209b886b698.mockapi.io/ec3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(serviceClass: Class<T>):T{
        return retrofit.create(serviceClass)
    }

}
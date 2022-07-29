package com.rmanzur.ec3

import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("productos")
    fun getProductos(): Call<List<ProductModel>>
}
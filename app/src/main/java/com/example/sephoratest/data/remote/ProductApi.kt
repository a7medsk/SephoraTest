package com.example.sephoratest.data.remote

import com.example.sephoratest.data.local.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


/**
 *Created by haskhiri on 14/10/2021
 */
interface ProductApi {

    @GET("/items.json")
    suspend fun getItems(): ProductResponse


}
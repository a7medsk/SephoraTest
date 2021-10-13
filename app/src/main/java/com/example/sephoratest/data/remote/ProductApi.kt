package com.example.sephoratest.data.remote

import com.example.sephoratest.data.local.ProductItem
import retrofit2.http.GET


/**
 *Created by haskhiri on 14/10/2021
 */
interface ProductApi {

    @GET("/items")
    suspend fun getItems(): List<ProductItem>


}
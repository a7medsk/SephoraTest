package com.example.sephoratest.data.remote

import com.example.sephoratest.data.local.Product
import com.google.gson.annotations.SerializedName


/**
 *Created by haskhiri on 14/10/2021
 */
data class ProductResponse(
    @SerializedName("items") val items :List<Product>


)

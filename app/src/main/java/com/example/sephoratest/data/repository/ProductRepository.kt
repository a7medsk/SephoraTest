package com.example.sephoratest.data.repository

import androidx.lifecycle.LiveData
import com.example.sephoratest.data.local.Product


/**
 *Created by haskhiri on 14/10/2021
 */
interface ProductRepository {

    fun getAllProductItems(): LiveData<List<Product>>

    suspend fun refreshItems()
}
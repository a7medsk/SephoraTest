package com.example.sephoratest.data.repository

import androidx.lifecycle.LiveData
import com.example.sephoratest.data.local.ProductDao
import com.example.sephoratest.data.local.ProductItem
import com.example.sephoratest.data.remote.ProductApi
import javax.inject.Inject


/**
 *Created by haskhiri on 14/10/2021
 */
class ProductRepository @Inject constructor(
    private val productApi: ProductApi,
    private val productDao: ProductDao

) {

    fun getAllSephoraItems(): LiveData<List<ProductItem>> {
        return productDao.getAllSephoraItems()
    }

    suspend fun refreshItems() {
        productApi.getItems().also { productDao.insertAllSephoraItems(it) }
    }
}
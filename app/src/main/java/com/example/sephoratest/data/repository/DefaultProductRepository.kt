package com.example.sephoratest.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sephoratest.data.local.ProductDao
import com.example.sephoratest.data.local.Product
import com.example.sephoratest.data.remote.ProductApi
import com.example.sephoratest.data.remote.ProductResponse
import com.example.sephoratest.other.Resource
import javax.inject.Inject


/**
 *Created by haskhiri on 14/10/2021
 */
class DefaultProductRepository @Inject constructor(
    private val productApi: ProductApi,
    private val productDao: ProductDao

) :ProductRepository {

    override fun getAllProductItems(): LiveData<List<Product>> {
        return productDao.getAllProductItems()
    }

    override suspend fun refreshItems() {

        productApi.getItems().also {
            productDao.insertAllProductItems(it.items) }

    }
}
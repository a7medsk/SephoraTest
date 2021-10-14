package com.example.sephoratest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sephoratest.data.local.Product
import com.example.sephoratest.data.repository.ProductRepository


/**
 *Created by haskhiri on 14/10/2021
 */
class FakeProductRepository :ProductRepository {

    private val productItems = mutableListOf<Product>()


    private val observableProductItems = MutableLiveData<List<Product>>(productItems)


    override fun getAllProductItems(): LiveData<List<Product>> {
        return observableProductItems
    }

    override suspend fun refreshItems() {

        observableProductItems.postValue(productItems)
    }
}
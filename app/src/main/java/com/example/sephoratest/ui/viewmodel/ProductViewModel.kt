package com.example.sephoratest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sephoratest.data.local.Product
import com.example.sephoratest.data.repository.DefaultProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 *Created by haskhiri on 14/10/2021
 */
@HiltViewModel
class ProductViewModel @Inject constructor(private val repositoryDefault: DefaultProductRepository) :
    ViewModel() {



    private val selected = MutableLiveData<Product>()

    fun getProducts(): LiveData<List<Product>> {
        viewModelScope.launch {
            repositoryDefault.refreshItems()
        }
        return products
    }

    private val products = repositoryDefault.getAllProductItems()

    fun select(item: Product) {
        selected.value= item
    }

    fun getSelected():LiveData<Product> = selected
}
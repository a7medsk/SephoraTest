package com.example.sephoratest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sephoratest.data.remote.ProductResponse
import retrofit2.Call


/**
 *Created by haskhiri on 13/10/2021
 */
@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductItem(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProductItems(products:List<Product>)

    @Query("select * from sephora_items")
    fun getAllProductItems(): LiveData<List<Product>>

}
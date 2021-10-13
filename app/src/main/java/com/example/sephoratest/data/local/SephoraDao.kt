package com.example.sephoratest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 *Created by haskhiri on 13/10/2021
 */
@Dao
interface SephoraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSephoraItem(sephoraItem: SephoraItem)

    @Query("select * from sephora_items")
    fun observeAllSephoraItems(): LiveData<List<SephoraItem>>

}
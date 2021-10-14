package com.example.sephoratest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 *Created by haskhiri on 13/10/2021
 */

@Database(entities = [Product::class],
    version =1)
abstract class ProductItemDataBase :RoomDatabase() {
    abstract fun productDao():ProductDao
}
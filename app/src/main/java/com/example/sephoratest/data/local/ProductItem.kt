package com.example.sephoratest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 *Created by haskhiri on 13/10/2021
 */
@Entity(tableName = "sephora_items")
data class ProductItem(

 @PrimaryKey val id: Int,
 val description :String,
 val location :String,
 val image :String

)

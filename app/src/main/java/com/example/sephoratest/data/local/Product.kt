package com.example.sephoratest.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.annotation.Nullable


/**
 *Created by haskhiri on 13/10/2021
 */
@Entity(tableName = "sephora_items")
data class Product(

    @PrimaryKey  var id: String,
    var description: String,
    var location: String,
    var image: String

)
